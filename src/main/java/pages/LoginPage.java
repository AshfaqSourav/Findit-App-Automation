package pages;

import enums.LocatorClassName;
import config.DeviceConfig;
import enums.LocatorType;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage() {
        super();
    }

    // Example: OTP Handling
    public void enterOtp(String... otps) {
        for (int i = 0; i < otps.length; i++) {
            String locatorKey = "LOGIN_EMAIL_OTP_" + (i + 1); // Dynamically construct locator key
            String locator = getLocator(locatorKey, LocatorClassName.LOGIN_LOCATOR_CLASS.toString());
            WebElement otpField = waitUntilElementIsVisible(LocatorType.XPATH, locator); // Use WebElement
            otpField.click();
            otpField.clear();
            otpField.sendKeys(otps[i]);
        }
        hideKeyboard();
    }


    public void LoginWithEmail(String email) {
        this.sleep(2000);

        // Clicking on the "LOGIN_WITH_EMAIL_BUTTON"
        this.clickButton("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        logger.info("Clicked on LOGIN_WITH_EMAIL_BUTTON");

        // Entering email into the text field
        this.clickTextField("LOGIN_EMAIL_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, email);
        logger.info("Entered email: {}", email);

        // Proceeding with "LOGIN_EMAIL_NEXT_BUTTON"
        this.clickButton("LOGIN_EMAIL_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        logger.info("Clicked on LOGIN_EMAIL_NEXT_BUTTON");

        // Enter OTP using predefined password fields in the config
        this.enterOtp(
                DeviceConfig.properties.getProperty("login.password1"),
                DeviceConfig.properties.getProperty("login.password2"),
                DeviceConfig.properties.getProperty("login.password3"),
                DeviceConfig.properties.getProperty("login.password4"),
                DeviceConfig.properties.getProperty("login.password5"),
                DeviceConfig.properties.getProperty("login.password6")
        );
        logger.info("Entered OTP successfully");

        // Verify login and allow notifications
        this.clickButton("LOGIN_EMAIL_VERIFY_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        logger.info("Clicked on LOGIN_EMAIL_VERIFY_BUTTON");
//        waitForVisibilityOfElement("TURN_ON_NOTIFICATION_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,30);

        this.clickButton("TURN_ON_NOTIFICATION_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        logger.info("Clicked on TURN_ON_NOTIFICATION_BUTTON");

        this.clickButton("ALLOW_NOTIFICATION", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.ID);
        logger.info("Clicked on ALLOW_NOTIFICATION");

        // Waiting for a few seconds to complete the login process
        this.sleep(3000);
    }
}
