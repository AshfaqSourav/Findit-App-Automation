
//package pages;
//
//import com.google.common.collect.ImmutableMap;
//import config.DeviceConfig;
//import config.LocatorClassConfig;
//import enums.LocatorType;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileBy;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.android.nativekey.KeyEvent;
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.File;
//import java.lang.reflect.Field;
//import java.net.URL;
//
//public class BasePage {
//    public static final Logger logger = LoggerFactory.getLogger(BasePage.class);
//    private static AppiumDriverLocalService appiumService;
//    public static AppiumDriver<MobileElement> driver;
//    public static String platform;
//
//    public BasePage() {
//        PageFactory.initElements(new AppiumFieldDecorator(BasePage.driver), this);
//    }
//
//    public static void initializeDriver(String platformName) throws Exception {
//        BasePage.startAppiumServer();
//        BasePage.platform = platformName;
//        DesiredCapabilities capabilities;
//
//        if (platformName.equalsIgnoreCase("Android")) {
//            capabilities = DeviceConfig.getAndroidCapabilities();
//            BasePage.driver = new AndroidDriver<>(new URL(DeviceConfig.properties.getProperty("serverURL")), capabilities);  // Explicitly using AndroidDriver
//        } else if (platformName.equalsIgnoreCase("iOS")) {
//            capabilities = DeviceConfig.getIOSCapabilities();
//            BasePage.driver = new IOSDriver<>(new URL(DeviceConfig.properties.getProperty("serverURL")), capabilities);  // Explicitly using IOSDriver
//        } else {
//            throw new IllegalArgumentException("Invalid platform name: " + platformName);
//        }
//
//        URL serverURL = new URL(DeviceConfig.properties.getProperty("serverURL"));
//        BasePage.driver = new AppiumDriver<>(serverURL, capabilities);
//        logger.info("Driver initialized for platform: {}", platformName);
//    }
//
//    public static void quitDriver() {
//        if (BasePage.driver != null) {
//            BasePage.driver.quit();
//            logger.info("Driver quit successfully.");
//            BasePage.stopAppiumServer();
//        }
//    }
//    public static void startAppiumServer() {
//        if (appiumService == null) {
//            appiumService = new AppiumServiceBuilder()
//                    .usingPort(4723)                                    // Set Appium server port
//                    .withLogFile(new File("appium_server_logs.txt"))    // Set log file
//                    .withArgument(() -> "--base-path", "/wd/hub")       // Enable /wd/hub prefix for backward compatibility
//                    .withArgument(() -> "--relaxed-security")           // Allow non-standard capabilities
//                    .build();
//        }
//        appiumService.start();
//        System.out.println("Appium server started...");
//    }
//
//    // Stop Appium server
//    public static void stopAppiumServer() {
//        if (appiumService != null && appiumService.isRunning()) {
//            appiumService.stop();
//            System.out.println("Appium server stopped...");
//        }
//    }
//    public static String getPlatform() {
//        return platform;
//    }
//
//protected String getLocator(String locatorFieldName, String pageName) {
//    try {
//        // Determine the platform-specific locator class dynamically
//        Class<?> locatorClass = getPlatform().equalsIgnoreCase("Android")
//                ? LocatorClassConfig.androidLocators.get(pageName)
//                : LocatorClassConfig.iosLocators.get(pageName);
//
//        if (locatorClass == null) {
//            throw new RuntimeException("No locator class found for page: " + pageName + " on platform: " + getPlatform());
//        }
//
//        // Fetch the field from the specified class
//        Field field = locatorClass.getDeclaredField(locatorFieldName);
//        return (String) field.get(null); // Return the value of the field
//    } catch (NoSuchFieldException | IllegalAccessException e) {
//        logger.error("Locator not found: {} in page: {}", locatorFieldName, pageName, e);
//        throw new RuntimeException("Locator not found: " + locatorFieldName + " in page: " + pageName, e);
//    }
//}
//
//
//    public MobileElement waitUntilElementIsVisible(LocatorType locatorType, String locatorValue) {
//        WebDriverWait wait = new WebDriverWait(BasePage.driver, 30);
//        boolean isAndroid = "Android".equalsIgnoreCase(BasePage.platform);
//
//        By locator = getDynamicLocator(locatorType, locatorValue, isAndroid);
//        if (locator == null) {
//            logger.error("Invalid or unsupported locator type for platform: {}", locatorType);
//            throw new IllegalArgumentException("Invalid or unsupported locator type for platform: " + locatorType);
//        }
//
//        return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
//    }
//
//    private By getDynamicLocator(LocatorType locatorType, String locatorValue, boolean isAndroid) {
//        switch (locatorType) {
//            case UI_AUTOMATOR:
//                return isAndroid ? MobileBy.AndroidUIAutomator(locatorValue) : MobileBy.iOSNsPredicateString(locatorValue);
//            case IOS_CLASS_CHAIN:
//                return isAndroid ? null : MobileBy.iOSClassChain(locatorValue);
//            case XPATH:
//                return MobileBy.xpath(locatorValue);
//            case ID:
//                return MobileBy.id(locatorValue);
//            case CLASS_NAME:
//                return MobileBy.className(locatorValue);
//            case ACCESSIBILITY_ID:
//                return MobileBy.AccessibilityId(locatorValue);
//            default:
//                return null;
//        }
//    }
//
//    public boolean isKeyboardVisible() {
//        try {
//            BasePage.driver.getKeyboard();
//            logger.info("Keyboard is visible.");
//            return true;
//        } catch (Exception e) {
//            logger.info("Keyboard is not visible.");
//            return false;
//        }
//    }
//
//    public void hideKeyboard() {
//        try {
//            if (isKeyboardVisible()) {
//                BasePage.driver.hideKeyboard();
//                logger.info("Keyboard hidden successfully.");
//                sleep(1000);
//            } else {
//                logger.info("Keyboard is not visible; no action taken.");
//            }
//        } catch (Exception e) {
//            logger.error("Error while hiding the keyboard: {}", e.getMessage(), e);
//        }
//    }
//
//    public void back() {
//        try {
//            ((AndroidDriver<?>) BasePage.driver).pressKey(new KeyEvent(AndroidKey.BACK));
//            logger.info("Back key pressed.");
//        } catch (Exception e) {
//            logger.error("Error pressing the back key: {}", e.getMessage(), e);
//        }
//    }
//
//    public boolean waitForVisibility(MobileElement ele) {
//        try {
//            WebDriverWait wait = new WebDriverWait(BasePage.driver, 3);
//            wait.until(ExpectedConditions.visibilityOf(ele));
//            logger.info("Element is visible: {}", ele);
//            return true;
//        } catch (Exception e) {
//            logger.warn("Element is not visible: {}", ele, e);
//            return false;
//        }
//    }
//
//    public void sleep(long milliseconds) {
//        try {
//            Thread.sleep(milliseconds);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            logger.error("Sleep interrupted: {}", e.getMessage(), e);
//        }
//    }
//    public void clickButton (String locatorName ,String locatorClass , LocatorType locatorType){
//        String locator = getLocator(locatorName, locatorClass);
//        MobileElement Button = waitUntilElementIsVisible(locatorType,locator);
//        Button.click();
//    }
//    public MobileElement getElement (String locatorName ,String locatorClass , LocatorType locatorType){
//        String locator = getLocator(locatorName, locatorClass);
//        MobileElement Button = waitUntilElementIsVisible(locatorType,locator);
//        return Button;
//    }
//    public void clickTextField (String locatorName ,String locatorClass , LocatorType locatorType,String text){
//        String locator = getLocator(locatorName, locatorClass);
//        MobileElement textField = waitUntilElementIsVisible(locatorType,locator);
//        textField.click();
//        textField.clear();
//        textField.sendKeys(text);
//        hideKeyboard();
//
//    }
//    public void scrollToEnd() {
//        try {
//            // Use UiScrollable to scroll to the end of a scrollable container
//            String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)";
//            driver.findElement(MobileBy.AndroidUIAutomator(uiScrollable));
//            logger.info("Scrolled to the end of the screen.");
//        } catch (Exception e) {
//            logger.error("Failed to scroll to the end of the screen.", e);
//        }
//    }
//
//}
package pages;

import config.DeviceConfig;
import config.LocatorClassConfig;
import enums.LocatorType;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Collections;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class BasePage {

    public static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    private static AppiumDriverLocalService appiumService;
    public static AppiumDriver driver;  // Updated here
    public static String platform;

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(BasePage.driver), this);
    }

    public static void initializeDriver(String platformName) throws Exception {
        BasePage.startAppiumServer();
        platform = platformName;
        DesiredCapabilities capabilities;

        if (platformName.equalsIgnoreCase("Android")) {
            capabilities = DeviceConfig.getAndroidCapabilities();
            driver = new AndroidDriver(new URL(DeviceConfig.properties.getProperty("serverURL")+ "/wd/hub"), capabilities);
        } else if (platformName.equalsIgnoreCase("iOS")) {
            capabilities = DeviceConfig.getIOSCapabilities();
            driver = new IOSDriver(new URL(DeviceConfig.properties.getProperty("serverURL")+ "/wd/hub"), capabilities);
        } else {
            throw new IllegalArgumentException("Invalid platform name: " + platformName);
        }

        logger.info("Driver initialized for platform: {}", platformName);
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
                    .build();
        }
        appiumService.start();

        logger.info("Appium server started...");
    }

    public static void stopAppiumServer() {
        if (appiumService != null && appiumService.isRunning()) {
            appiumService.stop();
            logger.info("Appium server stopped...");
        }
    }

    public static String getPlatform() {
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
}


