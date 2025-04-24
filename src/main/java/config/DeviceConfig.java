package config;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class DeviceConfig {

    public static final Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config/Config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load Config.properties. Ensure the file exists and is properly formatted.");
        }
    }

    public static DesiredCapabilities getCapabilities(String platformName) {
        switch (platformName.toLowerCase()) {
            case "android":
                return getAndroidCapabilities();
            case "ios":
                return getIOSCapabilities();
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platformName);
        }
    }


public static String detectPlatform() {
    try {
        // Check if an iOS device is connected
        if (checkForConnectedIOSDevices()) {
            System.out.println("iOS device detected.");
            return "iOS";
        }

        // Check if an Android device or emulator is connected
        if (checkForConnectedAndroidDevices()) {
            System.out.println("Android device detected.");
            return "Android";
        }

        // If no devices are detected, throw an exception
        throw new RuntimeException("No supported devices detected. Ensure a device or emulator is connected.");
    } catch (Exception e) {
        throw new RuntimeException("Platform detection failed due to an error: " + e.getMessage(), e);
    }
}

    private static boolean checkForConnectedAndroidDevices() {
        try {
            Process process = Runtime.getRuntime().exec("adb devices");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches(".*\\sdevice$")) { // Matches lines ending with 'device'
                    return true; // Android device or emulator is connected
                }
            }
        } catch (IOException e) {
            System.err.println("Error checking for Android devices: " + e.getMessage());
        }
        return false;
    }

    private static boolean checkForConnectedIOSDevices() {
        try {
            Process process = Runtime.getRuntime().exec("idevice_id -l");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    return true; // iOS device is connected
                }
            }
        } catch (IOException e) {
            System.err.println("Error checking for iOS devices: " + e.getMessage());
        }
        return false;
    }



    public static DesiredCapabilities getDynamicCapabilities() {
        return getCapabilities(detectPlatform());
    }

    private static DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:platformName", properties.getProperty("platformName"));
        capabilities.setCapability("appium:automationName", properties.getProperty("automationName"));
        capabilities.setCapability("appium:newCommandTimeout", Integer.parseInt(properties.getProperty("newCommandTimeout")));

        String apkPath = System.getenv("GITHUB_ACTIONS") != null
                ? "/home/runner/work/Findit-App/findit.apk"
                : System.getProperty("user.dir") + "/" + properties.getProperty("appPath");
        capabilities.setCapability("appium:appWaitActivity", "*");
        capabilities.setCapability("appium:newCommandTimeout", 0);
        capabilities.setCapability("appium:app", apkPath);
        capabilities.setCapability("appium:uiautomator2ServerLaunchTimeout", 120000);
        capabilities.setCapability("appium:unicodeKeyboard", true);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:adbExecTimeout", 60000);
        capabilities.setCapability("appium:androidInstallTimeout", 90000);
        capabilities.setCapability("appium:uiautomator2ServerInstallTimeout", 120000);
        capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);
        capabilities.setCapability("appium:appPackage", "com.findit.id");
        capabilities.setCapability("appium:appActivity", "com.findit.id.MainActivity");

        return capabilities;
    }

    private static DesiredCapabilities getIOSCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:platformName", properties.getProperty("iosPlatformName"));
        capabilities.setCapability("appium:deviceName", properties.getProperty("iosDeviceName"));
        capabilities.setCapability("appium:automationName", properties.getProperty("iosAutomationName"));
        capabilities.setCapability("appium:udid", properties.getProperty("iosUdid"));
        capabilities.setCapability("appium:bundleId", properties.getProperty("iosBundleId"));
        capabilities.setCapability("appium:platformVersion", properties.getProperty("iosPlatformVersion"));
        capabilities.setCapability("appium:wdaLaunchTimeout", 60000);
        capabilities.setCapability("appium:wdaConnectionTimeout", 60000);
        capabilities.setCapability("appium:clearSystemFiles", true);
        capabilities.setCapability("appium:autoAcceptAlerts", true);
        capabilities.setCapability("appium:unicodeKeyboard", true);
        capabilities.setCapability("appium:noReset", true);
        capabilities.setCapability("appium:fullReset", false);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:usePrebuiltApp", true);
        capabilities.setCapability("appium:resetOnLaunch", true);
        capabilities.setCapability("appium:newCommandTimeout", 300);
        return capabilities;
    }
}

