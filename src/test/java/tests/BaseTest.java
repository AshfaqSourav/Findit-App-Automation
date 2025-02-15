package tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import config.DeviceConfig;
import enums.Credentials;
import pages.LoginPage;
import pages.BasePage;
import pages.LogoutPage;
import pages.ProductUploadPage;



public class BaseTest {

    protected WebDriver driver; // Use WebDriver instead of MobileElement-specific AppiumDriver
    protected LoginPage loginPage;
    protected LogoutPage logoutPage;
    protected String buyerEmail;
    protected String sellerEmail;
    protected String productName;
    protected String productPrice;
    protected String productLocation;
    protected ProductUploadPage productUploadPage;

    @BeforeClass
    @Parameters("platformName") // TestNG parameter
    public void setup() throws Exception {
        BasePage.initializeDriver(); // Initialize driver from BasePage
        driver = BasePage.driver; // Assign driver to local instance
        this.setCredential();
        this.loginPage = new LoginPage(); // Pass driver instance to page classes
        this.productUploadPage = new ProductUploadPage(); // Pass driver instance to page classes
        this.logoutPage = new LogoutPage();
    }

    public void setCredential() {
        this.buyerEmail = DeviceConfig.properties.getProperty(Credentials.EMAIL_BUYER.toString());
        this.sellerEmail = DeviceConfig.properties.getProperty(Credentials.EMAIL_SELLER.toString());
        this.productName = DeviceConfig.properties.getProperty(Credentials.PRODUCT_NAME.toString());
        this.productPrice = DeviceConfig.properties.getProperty(Credentials.PRODUCT_PRICE.toString());
        this.productLocation = DeviceConfig.properties.getProperty(Credentials.PRODUCT_LOCATION.toString());
    }

    @AfterClass
    public void tearDown() {
        BasePage.quitDriver(); // Quit driver using BasePage method
    }
}

