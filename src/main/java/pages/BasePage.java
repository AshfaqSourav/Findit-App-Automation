package pages;

import config.DeviceConfig;
import config.LocatorClassConfig;
import enums.LocatorType;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Duration;
import java.util.Collections;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;



public class BasePage {

    public static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    private static AppiumDriverLocalService appiumService;
    public static AppiumDriver driver;  // Updated here
    public static String platform;

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(BasePage.driver), this);
    }

    public static void initializeDriver() throws Exception {
        BasePage.startAppiumServer();
        platform = DeviceConfig.detectPlatform();

        DesiredCapabilities capabilities = DeviceConfig.getDynamicCapabilities();
        String serverURL = DeviceConfig.properties.getProperty("serverURL") + "/wd/hub";
        driver = new AppiumDriver(new URL(serverURL), capabilities);
        System.out.println("Driver initialized for platform: {}"+ platform);
    }

    public static void quitDriver() {
        driver.quit();
        BasePage.stopAppiumServer();
    }

    public static void startAppiumServer() {
        if (appiumService == null) {
        String appiumPath = System.getenv("APPIUM_PATH");

            // Fallback to known locations if APPIUM_PATH is not set
            if (appiumPath == null || appiumPath.isEmpty()) {
                System.out.println("⚠️ APPIUM_PATH is not set, checking default locations...");
                if (System.getProperty("os.name").toLowerCase().contains("win")) {
                    appiumPath = "C:\\Users\\ashfa\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
                } else {
                    // Updated paths to check
                    String[] possiblePaths = {
                            System.getenv("HOME") + "/.npm-global/lib/node_modules/appium/build/lib/main.js",
                            "/usr/local/lib/node_modules/appium/build/lib/main.js",
                            "/opt/hostedtoolcache/node/20.18.2/x64/lib/node_modules/appium/build/lib/main.js" // ✅ Correct CI/CD path
                    };

                    for (String path : possiblePaths) {
                        File appiumFile = new File(path);
                        if (appiumFile.exists()) {
                            appiumPath = path;
                            break;
                        }
                    }
                }
            }

            if (appiumPath == null || appiumPath.isEmpty() || !new File(appiumPath).exists()) {
                throw new RuntimeException("❌ Appium main.js not found! Check installation.");
            }

            // Configure Appium service
            appiumService = new AppiumServiceBuilder()
                    .withAppiumJS(new File(appiumPath)) // Explicitly set Appium path
                    .usingPort(4723) // Set Appium to use port 4723
                    .withArgument(() -> "--base-path", "/wd/hub")
                    .withLogFile(new File("appium_server_logs.txt"))
                    .withArgument(() -> "--relaxed-security") // Fix argument format
                    .build();

            appiumService.start(); // Start Appium service with timeout handling
            try {
                Thread.sleep(5000); // Allow Appium time to initialize
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("✅ Appium server started..."+ appiumPath);
        }
    }

    public static void stopAppiumServer() {
        if (appiumService != null && appiumService.isRunning()) {
            appiumService.stop();
            logger.info("Appium server stopped...");
        }
    }

    public static String getPlatform() {
        System.out.println("Returning platform: {}" + platform);
        return platform;
    }

    protected String getLocator(String locatorFieldName, String pageName) {
        try {
            Class<?> locatorClass = getPlatform().equalsIgnoreCase("Android")
                    ? LocatorClassConfig.androidLocators.get(pageName)
                    : LocatorClassConfig.iosLocators.get(pageName);

            if (locatorClass == null) {
                throw new RuntimeException("No locator class found for page: " + pageName + " on platform: " + getPlatform());
            }

            Field field = locatorClass.getDeclaredField(locatorFieldName);
            return (String) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            logger.error("Locator not found: {} in page: {}", locatorFieldName, pageName, e);
            throw new RuntimeException("Locator not found: " + locatorFieldName + " in page: " + pageName, e);
        }
    }

    public WebElement waitUntilElementIsVisible(LocatorType locatorType, String locatorValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        boolean isAndroid = "Android".equalsIgnoreCase(platform);

        By locator = getDynamicLocator(locatorType, locatorValue, isAndroid);
        if (locator == null) {
            logger.error("Invalid or unsupported locator type for platform: {}", locatorType);
            throw new IllegalArgumentException("Invalid or unsupported locator type for platform: " + locatorType);
        }

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement waitForVisibilityOfElement(String locatorName, String locatorClass, LocatorType locatorType,int maximum_timeout) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maximum_timeout));
    boolean isAndroid = "Android".equalsIgnoreCase(platform);

    // Get the locator string using the class and field name
    String locatorValue = getLocator(locatorName, locatorClass);

    // Get the dynamic locator based on locatorType
    By locator = getDynamicLocator(locatorType, locatorValue, isAndroid);

    if (locator == null) {
        System.err.println("Invalid or unsupported locator type for platform: " + locatorType);
        throw new IllegalArgumentException("Invalid or unsupported locator type for platform: " + locatorType);
    }

    // Wait for the element to be clickable
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
}


    private By getDynamicLocator(LocatorType locatorType, String locatorValue, boolean isAndroid) {
        switch (locatorType) {
            case UI_AUTOMATOR:
                return isAndroid ? AppiumBy.androidUIAutomator(locatorValue) : AppiumBy.iOSNsPredicateString(locatorValue);
            case IOS_CLASS_CHAIN:
                return isAndroid ? null : AppiumBy.iOSClassChain(locatorValue);
            case XPATH:
                return AppiumBy.xpath(locatorValue);
            case ID:
                return AppiumBy.id(locatorValue);
            case CLASS_NAME:
                return AppiumBy.className(locatorValue);
            case ACCESSIBILITY_ID:
                return AppiumBy.accessibilityId(locatorValue);
            default:
                return null;
        }
    }

    public boolean isKeyboardVisible() {
        try {
            if (driver instanceof AndroidDriver) {
                // Check for Android
                boolean isKeyboardShown = ((AndroidDriver) driver).isKeyboardShown();
                logger.info("Android keyboard visibility: {}", isKeyboardShown);
                return isKeyboardShown;
            } else if (driver instanceof IOSDriver) {
                // Check for iOS
                boolean isKeyboardShown = ((IOSDriver) driver).isKeyboardShown();
                logger.info("iOS keyboard visibility: {}", isKeyboardShown);
                return isKeyboardShown;
            } else {
                logger.warn("Unsupported driver type: {}", driver.getClass().getSimpleName());
                return false;
            }
        } catch (Exception e) {
            logger.error("Error checking keyboard visibility: {}", e.getMessage(), e);
            return false;
        }
    }

    public void hideKeyboard() {
        try {
            if (isKeyboardVisible()) {
                if (driver instanceof AndroidDriver) {
                    // Android-specific hide keyboard
                    ((AndroidDriver) driver).hideKeyboard();
                } else if (driver instanceof IOSDriver) {
                    // iOS-specific hide keyboard
                    ((IOSDriver) driver).hideKeyboard();
                } else {
                    logger.warn("Unsupported driver type for hiding keyboard: {}", driver.getClass().getSimpleName());
                    return;
                }
                logger.info("Keyboard hidden successfully.");
                sleep(1000);
            } else {
                logger.info("Keyboard is not visible; no action taken.");
            }
        } catch (Exception e) {
            logger.error("Error while hiding the keyboard: {}", e.getMessage(), e);
        }
    }



    public boolean waitForVisibility(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info("Element is visible: {}", element);
            return true;
        } catch (Exception e) {
            logger.warn("Element is not visible: {}", element, e);
            return false;
        }
    }

    public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Sleep interrupted: {}", e.getMessage(), e);
        }
    }

    public void clickButton(String locatorName, String locatorClass, LocatorType locatorType) {
        String locator = getLocator(locatorName, locatorClass);
        WebElement button = waitUntilElementIsVisible(locatorType, locator);
        button.click();
    }

//    public WebElement getElement(String locatorName, String locatorClass, LocatorType locatorType) {
//        String locator = getLocator(locatorName, locatorClass);
//        return waitUntilElementIsVisible(locatorType, locator);
//    }
    public WebElement getElement(String locatorName, String locatorClass, LocatorType locatorType) {
    try {
        String locator = getLocator(locatorName, locatorClass);
        return waitUntilElementIsVisible(locatorType, locator);
    } catch (NoSuchElementException e) {
        System.out.println("Element not found: " + locatorName);
        return null; // Return null if element is not found
    }
}

    public void clickTextField(String locatorName, String locatorClass, LocatorType locatorType, String text) {
        String locator = getLocator(locatorName, locatorClass);
        WebElement textField = waitUntilElementIsVisible(locatorType, locator);
        textField.click();
        textField.clear();
        textField.sendKeys(text);
        hideKeyboard();
    }

    public void scrollHalfway() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.75); // Start from 75% of screen height
        int endY = (int) (size.height * 0.25);   // Move to 25% of screen height

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public void scrollFullScreen() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.9); // Start from 90% height
        int endY = (int) (size.height * 0.1);   // Scroll to 10% height

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }


    public boolean displayStatus(String locatorName, String locatorClass, LocatorType locatorType) {
        try {
            // Get the locator value dynamically
            String locatorValue = getLocator(locatorName, locatorClass);
            if (locatorValue == null || locatorValue.isEmpty()) {
                System.out.println("Locator value not found for " + locatorName + " in class " + locatorClass);
                return false;
            }

            // Determine platform (Android or iOS)
            boolean isAndroid = "Android".equalsIgnoreCase(platform);

            // Get the By locator
            By locator = getDynamicLocator(locatorType, locatorValue, isAndroid);
            if (locator == null) {
                System.out.println("Invalid or unsupported locator type: " + locatorType);
                return false;
            }

            // Short timeout for quick visibility check
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            System.out.println("Element " + locatorName + " is visible.");
            return true; // Element is visible
        } catch (TimeoutException e) {
            System.out.println("Element " + locatorName + " is NOT visible within timeout.");
            return false;
        } catch (Exception e) {
            System.out.println("Error checking display status for locator: " + locatorName + " in class " + locatorClass);
            e.printStackTrace();
            return false;
        }
    }


    public void enterTextIfEmpty(String locatorName, String locatorClass, LocatorType locatorType, String textToEnter) {
        WebElement  field = getElement(locatorName, locatorClass, locatorType);
        String fieldValue = field.getText();

        if (fieldValue == null || fieldValue.trim().isEmpty()) {
            field.click();
            field.clear();
            field.sendKeys(textToEnter);
            System.out.println("Entered value: " + textToEnter);
        } else {
            System.out.println("Field already contains value: " + fieldValue);
        }
    }
    public static void restartFreshApp() throws Exception {
        driver.quit();
        BasePage.initializeDriver();
        System.out.println("12112");
    }
}


