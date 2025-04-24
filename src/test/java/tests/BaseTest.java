package tests;


import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import config.DeviceConfig;
import enums.Credentials;
import pages.*;
import utils.ScreenRecordingUtils;
import utils.ScreenshotUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected LogoutPage logoutPage;
    protected String buyerEmail;
    protected String sellerEmail;
    protected String productName;
    protected String productPrice;
    protected String productLocation;
    protected ProductUploadPage productUploadPage;
    protected UrlRedirectionPage urlRedirectionPage;

//    @BeforeMethod(alwaysRun = true)
//    public void startScreenRecording() {
//        try {
//            System.out.println("🎥 Starting screen recording via ADB...");
//            Runtime.getRuntime().exec("adb shell screenrecord /sdcard/test_video.mp4");
//            TimeUnit.SECONDS.sleep(2); // Give it some time to start recording
//        } catch (IOException | InterruptedException e) {
//            System.out.println("❌ Failed to start screen recording: " + e.getMessage());
//        }
//    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("platformName") // TestNG parameter
    public void setup() throws Exception {
        BasePage.initializeDriver(); // Initialize driver from BasePage
        driver = BasePage.driver; // Assign driver to local instance
        this.setCredential();
        this.loginPage = new LoginPage(); // Pass driver instance to page classes
        this.productUploadPage = new ProductUploadPage(); // Pass driver instance to page classes
        this.logoutPage = new LogoutPage();
        this.urlRedirectionPage = new UrlRedirectionPage();
        startScreenRecording();
    }
    private void startScreenRecording() {
        try {
            System.out.println("🎥 Starting screen recording via ADB...");
            Runtime.getRuntime().exec("adb shell screenrecord /sdcard/test_video.mp4");
            TimeUnit.SECONDS.sleep(2); // Give it some time to start recording
        } catch (IOException | InterruptedException e) {
            System.out.println("❌ Failed to start screen recording: " + e.getMessage());
        }
    }

    public void setCredential() {
        this.buyerEmail = DeviceConfig.properties.getProperty(Credentials.EMAIL_BUYER.toString());
        this.sellerEmail = DeviceConfig.properties.getProperty(Credentials.EMAIL_SELLER.toString());
        this.productName = DeviceConfig.properties.getProperty(Credentials.PRODUCT_NAME.toString());
        this.productPrice = DeviceConfig.properties.getProperty(Credentials.PRODUCT_PRICE.toString());
        this.productLocation = DeviceConfig.properties.getProperty(Credentials.PRODUCT_LOCATION.toString());
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SUCCESS_PERCENTAGE_FAILURE) {
            System.out.println("⚠️ Test Failed/Broken - Capturing Screenshot...");
            String localScreenshotName= result.getMethod().getMethodName();
            ScreenshotUtils.captureScreenshot(driver,localScreenshotName);
            ScreenshotUtils.attachScreenshotToAllure(driver,localScreenshotName);  // ✅ Now calling from BasePage
        }
        try {
            System.out.println("📽 Stopping screen recording via ADB...");
            Runtime.getRuntime().exec("adb shell pkill -l2 screenrecord");
            Thread.sleep(2000); // Ensure recording stops properly
            ScreenRecordingUtils.saveRecordingToFile(result);
        } catch (IOException | InterruptedException e) {
            System.out.println("❌ Error stopping screen recording: " + e.getMessage());
        }
    }

    @AfterClass
    public void quitDriver() {
        BasePage.quitDriver(); // Quit driver using BasePage method
    }
}



