//package config;
//
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public class DeviceConfig {
//
//    public static Properties properties;
//
//    static {
//        properties = new Properties();
//        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config/Config.properties")) {
//            properties.load(fileInputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to load Config.properties");
//        }
//    }
//
//    public static DesiredCapabilities getAndroidCapabilities() {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.getProperty("platformName"));
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("deviceName"));
//        capabilities.setCapability(MobileCapabilityType.UDID, properties.getProperty("udid"));
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, properties.getProperty("platformVersion"));
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("automationName"));
//        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, Integer.parseInt(properties.getProperty("newCommandTimeout")));
//        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/" + properties.getProperty("appPath"));
//        capabilities.setCapability("noReset", false);
//        capabilities.setCapability("fullReset", false);
//        capabilities.setCapability("unicodeKeyboard", true);
//        return capabilities;
//    }
//
//    public static DesiredCapabilities getIOSCapabilities() {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.getProperty("iosPlatformName"));
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("iosDeviceName"));
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("iosAutomationName"));
//        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/" + properties.getProperty("iosAppPath"));
//        return capabilities;
//    }
//}
package config;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DeviceConfig {

    public static Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config/Config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load Config.properties");
        }
    }

    public static DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", properties.getProperty("platformName"));
        capabilities.setCapability("appium:deviceName", properties.getProperty("deviceName"));
        capabilities.setCapability("appium:udid", properties.getProperty("udid"));
        capabilities.setCapability("appium:platformVersion", properties.getProperty("platformVersion"));
        capabilities.setCapability("appium:automationName", properties.getProperty("automationName"));
        capabilities.setCapability("appium:newCommandTimeout", Integer.parseInt(properties.getProperty("newCommandTimeout")));
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/" + properties.getProperty("appPath"));
        capabilities.setCapability("appium:noReset", false);
        capabilities.setCapability("appium:fullReset", false);
        capabilities.setCapability("appium:unicodeKeyboard", true);
        return capabilities;
    }

    public static DesiredCapabilities getIOSCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", properties.getProperty("iosPlatformName"));
        capabilities.setCapability("appium:deviceName", properties.getProperty("iosDeviceName"));
        capabilities.setCapability("appium:automationName", properties.getProperty("iosAutomationName"));
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/" + properties.getProperty("iosAppPath"));
        return capabilities;
    }
}

