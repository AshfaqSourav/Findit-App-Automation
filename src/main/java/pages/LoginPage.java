package pages;

import com.mailslurp.clients.ApiException;
import com.mailslurp.models.InboxDto;
import enums.LocatorClassName;
import config.DeviceConfig;
import enums.LocatorType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.MailSlurpHelper;

import java.io.IOException;


public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    public void LoginWithEmail(String email) throws IOException, InterruptedException {
        if(displayStatus("UPDATE_POPUP", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        System.out.println(BasePage.driver.getPageSource());
        waitForVisibilityOfElement("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        System.out.println("visible continue with email");
        this.clickButton("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("Clicked continue with email");
        waitForVisibilityOfElement("LOGIN_EMAIL_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        System.out.println("visible txt");
        this.writeTextField("LOGIN_EMAIL_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, email);
        System.out.println("Email Entered");
        this.clickButton("LOGIN_EMAIL_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("Next button clicked");
        this.enterOtp(
                DeviceConfig.properties.getProperty("login.password1"),
                DeviceConfig.properties.getProperty("login.password2"),
                DeviceConfig.properties.getProperty("login.password3"),
                DeviceConfig.properties.getProperty("login.password4"),
                DeviceConfig.properties.getProperty("login.password5"),
                DeviceConfig.properties.getProperty("login.password6")
        );
        this.clickButton("LOGIN_EMAIL_VERIFY_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("Verify button clicked");
        this.clickButton("TURN_ON_NOTIFICATION_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("ton button clicked");
        this.sleep(3000);
        waitForVisibilityOfElement("PROFILE_BUTTON", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        System.out.println("visible profile button");
    }

    // Example: OTP Handling
    public void enterOtp(String... otps) {
        for (int i = 0; i < otps.length; i++) {
            String locatorKey = "LOGIN_EMAIL_OTP_" + (i + 1); // Dynamically construct locator key
            String locator = (String) getLocator(locatorKey, LocatorClassName.LOGIN_LOCATOR_CLASS.toString());
            WebElement otpField = waitUntilElementIsVisible(LocatorType.XPATH, locator); // Use WebElement
            System.out.println("otp box visible");
            otpField.click();
            System.out.println("otp box clicked");
            otpField.clear();
            System.out.println("otp box cleared");
            otpField.sendKeys(otps[i]);
            System.out.println("otp box value entered"+otps[i]);
        }
        hideKeyboard();
    }
    public void signUpWithEmail() throws ApiException, IOException, InterruptedException {
        // ✅ Create inbox
        MailSlurpHelper mailSlurp = new MailSlurpHelper(DeviceConfig.properties.getProperty("apiKey"));
        InboxDto inbox = mailSlurp.generateInbox();
        String email = inbox.getEmailAddress();
        String inboxId = inbox.getId().toString();

        // ✅ UI: Email login flow
        if(displayStatus("UPDATE_POPUP", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        waitForVisibilityOfElement("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.clickButton("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.writeTextField("LOGIN_EMAIL_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, email);
        this.clickButton("LOGIN_EMAIL_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);

        // ✅ Wait for OTP in email
        String otp = mailSlurp.waitForOtpFromEmail(inboxId, 60000L);
        System.out.println("📩 OTP received from email: " + otp);

        // ✅ Split OTP digits and enter
        char[] otpDigits = otp.toCharArray();
        enterOtp(
                String.valueOf(otpDigits[0]),
                String.valueOf(otpDigits[1]),
                String.valueOf(otpDigits[2]),
                String.valueOf(otpDigits[3]),
                String.valueOf(otpDigits[4]),
                String.valueOf(otpDigits[5])
        );

        this.clickButton("LOGIN_EMAIL_VERIFY_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("✅ Verify button clicked with OTP");
        waitForVisibilityOfElement("SIGN_UP_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.writeTextField("SIGN_UP_NAME_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,"New Born");
        this.clickButton("SIGN_UP_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("TURN_ON_NOTIFICATION_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("TURN_ON_NOTIFICATION_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("ton button clicked");
        this.sleep(3000);
        waitForVisibilityOfElement("PROFILE_BUTTON", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        System.out.println("visible profile button");
    }
    public void nameInputEmpty() throws ApiException, IOException, InterruptedException {
        // ✅ Create inbox
        MailSlurpHelper mailSlurp = new MailSlurpHelper(DeviceConfig.properties.getProperty("apiKey"));
        InboxDto inbox = mailSlurp.generateInbox();
        String email = inbox.getEmailAddress();
        String inboxId = inbox.getId().toString();

        // ✅ UI: Email login flow
        waitForVisibilityOfElement("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.clickButton("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.writeTextField("LOGIN_EMAIL_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, email);
        this.clickButton("LOGIN_EMAIL_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);

        // ✅ Wait for OTP in email
        String otp = mailSlurp.waitForOtpFromEmail(inboxId, 30000);
        System.out.println("📩 OTP received from email: " + otp);

        // ✅ Split OTP digits and enter
        char[] otpDigits = otp.toCharArray();
        enterOtp(
                String.valueOf(otpDigits[0]),
                String.valueOf(otpDigits[1]),
                String.valueOf(otpDigits[2]),
                String.valueOf(otpDigits[3]),
                String.valueOf(otpDigits[4]),
                String.valueOf(otpDigits[5])
        );

        this.clickButton("LOGIN_EMAIL_VERIFY_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("✅ Verify button clicked with OTP");
        waitForVisibilityOfElement("SIGN_UP_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.clickButton("SIGN_UP_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("SIGN_UP_NAME_ERROR_MESSAGE", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
    public void nameInputWithSpace() throws ApiException, IOException, InterruptedException {
        // ✅ Create inbox
        MailSlurpHelper mailSlurp = new MailSlurpHelper(DeviceConfig.properties.getProperty("apiKey"));
        InboxDto inbox = mailSlurp.generateInbox();
        String email = inbox.getEmailAddress();
        String inboxId = inbox.getId().toString();

        // ✅ UI: Email login flow
        waitForVisibilityOfElement("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.clickButton("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.writeTextField("LOGIN_EMAIL_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, email);
        this.clickButton("LOGIN_EMAIL_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);

        // ✅ Wait for OTP in email
        String otp = mailSlurp.waitForOtpFromEmail(inboxId, 30000);
        System.out.println("📩 OTP received from email: " + otp);

        // ✅ Split OTP digits and enter
        char[] otpDigits = otp.toCharArray();
        enterOtp(
                String.valueOf(otpDigits[0]),
                String.valueOf(otpDigits[1]),
                String.valueOf(otpDigits[2]),
                String.valueOf(otpDigits[3]),
                String.valueOf(otpDigits[4]),
                String.valueOf(otpDigits[5])
        );

        this.clickButton("LOGIN_EMAIL_VERIFY_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("✅ Verify button clicked with OTP");
        waitForVisibilityOfElement("SIGN_UP_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.writeTextField("SIGN_UP_NAME_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH," ");
        this.clickButton("SIGN_UP_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("SIGN_UP_NAME_ERROR_MESSAGE", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
    public void emailInputEmpty (){
        if(displayStatus("UPDATE_POPUP", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        waitForVisibilityOfElement("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        System.out.println("visible continue with email");
        this.clickButton("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("Clicked continue with email");
        this.clickButton("LOGIN_EMAIL_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("EMAIL_EMPTY_INVALID_MESSAGE", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH));

    }
    public void emailInputInvalidText () throws IOException, InterruptedException {
        if(displayStatus("UPDATE_POPUP", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        waitForVisibilityOfElement("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        System.out.println("visible continue with email");
        this.clickButton("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("Clicked continue with email");
        this.writeTextField("LOGIN_EMAIL_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, "abc");
        System.out.println("Email Entered");
        this.clickButton("LOGIN_EMAIL_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("EMAIL_INVALID_INPUT_MESSAGE", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
    public void emailInputInvalidText2 () throws IOException, InterruptedException {
        if(displayStatus("UPDATE_POPUP", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        waitForVisibilityOfElement("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        System.out.println("visible continue with email");
        this.clickButton("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("Clicked continue with email");
        this.writeTextField("LOGIN_EMAIL_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, "abc@gmail");
        System.out.println("Email Entered");
        this.clickButton("LOGIN_EMAIL_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("EMAIL_INVALID_INPUT_MESSAGE2", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
    public void emailInputInvalidText3 () throws IOException, InterruptedException {
        if(displayStatus("UPDATE_POPUP", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        waitForVisibilityOfElement("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        System.out.println("visible continue with email");
        this.clickButton("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("Clicked continue with email");
        this.writeTextField("LOGIN_EMAIL_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, " ");
        System.out.println("Email Entered");
        this.clickButton("LOGIN_EMAIL_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("EMAIL_INVALID_INPUT_MESSAGE", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
    public void otpInputEmpty (String email) throws IOException, InterruptedException {
        if(displayStatus("UPDATE_POPUP", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        waitForVisibilityOfElement("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        System.out.println("visible continue with email");
        this.clickButton("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("Clicked continue with email");
        this.writeTextField("LOGIN_EMAIL_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,email);
        System.out.println("Email Entered");
        this.clickButton("LOGIN_EMAIL_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_EMAIL_VERIFY_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("LOGIN_EMAIL_VERIFY_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("Verify button clicked");
        Assert.assertTrue(displayStatus("OTP_INVALID_MESSAGE", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
    public void otpInputInvalid (String email) throws IOException, InterruptedException {
        if(displayStatus("UPDATE_POPUP", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        waitForVisibilityOfElement("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        System.out.println("visible continue with email");
        this.clickButton("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("Clicked continue with email");
        this.writeTextField("LOGIN_EMAIL_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,email);
        System.out.println("Email Entered");
        this.clickButton("LOGIN_EMAIL_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_EMAIL_VERIFY_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.enterOtp(
                DeviceConfig.properties.getProperty("login.password1"),
                DeviceConfig.properties.getProperty("login.password2"),
                DeviceConfig.properties.getProperty("login.password3")
        );
        this.clickButton("LOGIN_EMAIL_VERIFY_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("Verify button clicked");
        Assert.assertTrue(displayStatus("OTP_INVALID_MESSAGE", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
    public void otpInvalidInput2 (String email) throws IOException, InterruptedException {
        if(displayStatus("UPDATE_POPUP", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        waitForVisibilityOfElement("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("MORE_LOGIN_OPTIONS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        System.out.println("visible continue with email");
        this.clickButton("LOGIN_WITH_EMAIL_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("Clicked continue with email");
        this.writeTextField("LOGIN_EMAIL_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,email);
        System.out.println("Email Entered");
        this.clickButton("LOGIN_EMAIL_NEXT_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_EMAIL_VERIFY_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.enterOtp(
                DeviceConfig.properties.getProperty("login.password1"),
                DeviceConfig.properties.getProperty("login.password2"),
                DeviceConfig.properties.getProperty("login.password3"),
                DeviceConfig.properties.getProperty("login.password4"),
                DeviceConfig.properties.getProperty("login.password5"),
                DeviceConfig.properties.getProperty("login.password7")
        );
        this.clickButton("LOGIN_EMAIL_VERIFY_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        System.out.println("Verify button clicked");
        Assert.assertTrue(displayStatus("OTP_INVALID_MESSAGE2", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
}
