package pages;

import com.google.common.collect.ImmutableMap;
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


import java.io.*;
import java.time.Duration;
import java.util.Collections;

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
        // **Add Chrome-Specific Capabilities to Disable First-Time Popups**
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of(
                "args", new String[]{
                        "--no-first-run",          // Skips first-time setup
                        "--disable-fre",           // Disables first-run experience
                        "--disable-popup-blocking" // Ensures no unwanted popups
                }
        ));
        driver = new AppiumDriver(new URL(serverURL), capabilities);
        System.out.println("Driver initialized for platform: {}"+ platform);
    }

    public static void quitDriver() {
        driver.quit();
        BasePage.stopAppiumServer();
    }

    public static void startAppiumServer() {
        if (appiumService == null) {
            appiumService = new AppiumServiceBuilder()
                    .usingPort(4723)
                    .withArgument(() -> "--base-path", "/wd/hub")
                    .withLogFile(new File("appium_server_logs.txt"))
                    .withArgument(() -> "--relaxed-security")
                    .withTimeout(Duration.ofSeconds(60))
                    .build();
        }
        appiumService.start();

        System.out.println("Appium server started...");
    }
    public static void stopAppiumServer() {
        if (appiumService != null && appiumService.isRunning()) {
            appiumService.stop();
            System.out.println("Appium server stopped...");
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

//    public WebElement waitForVisibilityOfElement(String locatorName, String locatorClass, LocatorType locatorType,int maximum_timeout) {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maximum_timeout));
//    boolean isAndroid = "Android".equalsIgnoreCase(platform);
//
//    // Get the locator string using the class and field name
//    String locatorValue = getLocator(locatorName, locatorClass);
//
//    // Get the dynamic locator based on locatorType
//    By locator = getDynamicLocator(locatorType, locatorValue, isAndroid);
//
//    if (locator == null) {
//        System.err.println("Invalid or unsupported locator type for platform: " + locatorType);
//        throw new IllegalArgumentException("Invalid or unsupported locator type for platform: " + locatorType);
//    }
//
//    // Wait for the element to be clickable
//    return wait.until(ExpectedConditions.elementToBeClickable(locator));
//}
public void waitForVisibilityOfElement(String locatorName, String locatorClass, LocatorType locatorType, int maximum_timeout) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maximum_timeout));
    boolean isAndroid = "Android".equalsIgnoreCase(platform);

    String locatorValue = getLocator(locatorName, locatorClass);
    By locator = getDynamicLocator(locatorType, locatorValue, isAndroid);

    if (locator == null) {
        System.err.println("Invalid or unsupported locator type for platform: " + locatorType);
        throw new IllegalArgumentException("Invalid or unsupported locator type for platform: " + locatorType);
    }

    wait.until(ExpectedConditions.elementToBeClickable(locator)); // Just wait, no return
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

    public void writeTextField(String locatorName, String locatorClass, LocatorType locatorType, String text) {
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

    //Screen size of Pixel 9
    private static final int REFERENCE_WIDTH = 1080;
    private static final int REFERENCE_HEIGHT = 2424;
    public static void performTapUsingReferencePoint(Point referencePoint ) {
        // Get the current device screen dimensions
        Dimension screenSize = driver.manage().window().getSize();
        int actualWidth = screenSize.getWidth();
        int actualHeight = screenSize.getHeight();

        // Calculate percentages relative to Pixel 9 reference resolution
        double xPercentage = (double) referencePoint.getX() / REFERENCE_WIDTH;
        double yPercentage = (double) referencePoint.getY() / REFERENCE_HEIGHT;

        // Convert the percentages into actual pixel coordinates for the current device
        int actualX = (int) (xPercentage * actualWidth);
        int actualY = (int) (yPercentage * actualHeight);

        // Log calculations for debugging
        System.out.println("Reference Point: " + referencePoint);
        System.out.println("Screen Width: " + actualWidth + ", Screen Height: " + actualHeight);
        System.out.println("Calculated Actual X: " + actualX + ", Actual Y: " + actualY);

        // Perform the tap action using the calculated coordinates
//        performTapAtCoordinates(actualX, actualY);
    }

//    private static void performTapAtCoordinates(int x, int y) {
//        final PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        var tap = new Sequence(finger, 1);
//
//        tap.addAction(finger.createPointerMove(
//                Duration.ofMillis(0),
//                PointerInput.Origin.viewport(),
//                x,
//                y
//        ));
//        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//        driver.perform(Arrays.asList(tap));
//    }
}


