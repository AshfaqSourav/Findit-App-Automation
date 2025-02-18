package pages;

import enums.LocatorClassName;
import config.DeviceConfig;
import enums.LocatorType;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    public void LoginWithEmail(String email) {
        System.out.println("sdfd");
        System.out.println(BasePage.driver.getPageSource());
        waitForVisibilityOfElement("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,20);
        System.out.println("wsuccess");
        this.clickButton("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickTextField("LOGIN_EMAIL_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, email);
        this.clickButton("LOGIN_EMAIL_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.enterOtp(
                DeviceConfig.properties.getProperty("login.password1"),
                DeviceConfig.properties.getProperty("login.password2"),
                DeviceConfig.properties.getProperty("login.password3"),
                DeviceConfig.properties.getProperty("login.password4"),
                DeviceConfig.properties.getProperty("login.password5"),
                DeviceConfig.properties.getProperty("login.password6")
        );
        this.clickButton("LOGIN_EMAIL_VERIFY_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("TURN_ON_NOTIFICATION_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("PROFILE_BUTTON", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH,10);
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
}
