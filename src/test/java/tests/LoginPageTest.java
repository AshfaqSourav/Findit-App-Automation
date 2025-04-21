package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.BasePage;


public class LoginPageTest extends BaseTest {
    @Test(priority =1,groups = {"smoke"})
    @Description("Verify login of a user")
    public void testLoginWithEmail() throws Exception {
    	loginPage.LoginWithEmail(this.buyerEmail);
        BasePage.quitDriver();
    }

    @Test(groups = {"regression"})
    @Description("Verify Email Input validation")
    public void testEmailInputValidations() throws Exception {
        loginPage.emailInputEmpty();
        BasePage.quitDriver();
    }
    @Test(groups = {"regression"})
    @Description("Verify Email Input validation")
    public void testEmailInvalidInput1() throws Exception {
        loginPage.emailInputInvalidText();
        BasePage.quitDriver();
    }
    @Test(groups = {"regression"})
    @Description("Verify Email Input validation with 'abc@gmail'")
    public void testEmailInvalidInput2() throws Exception {
        loginPage.emailInputInvalidText2();
        BasePage.quitDriver();
    }
    @Test(groups = {"regression"})
    @Description("Verify Email Input validation with ' '")
    public void testEmailInvalidInput3() throws Exception {
        loginPage.emailInputInvalidText3();
        BasePage.quitDriver();
    }
    @Test(groups = {"regression"})
    @Description("Verify OTP empty input")
    public void testOtpInputEmpty() throws Exception {
        loginPage.otpInputEmpty(this.sellerEmail);
        BasePage.quitDriver();
    }
    @Test(groups = {"regression"})
    @Description("Verify OTP empty input")
    public void testOtpInvalidInput() throws Exception {
        loginPage.otpInputInvalid(this.sellerEmail);
        BasePage.quitDriver();
    }
    @Test(groups = {"regression"})
    @Description("Verify OTP empty input")
    public void testOtpInvalidInput2() throws Exception {
        loginPage.otpInvalidInput2(this.sellerEmail);
        BasePage.quitDriver();
    }

}

