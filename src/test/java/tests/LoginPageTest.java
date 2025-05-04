package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.BasePage;
import utils.RetryAnalyzer;


public class LoginPageTest extends BaseTest {
    @Test(priority =1,groups = {"smoke"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify login of a user")
    public void testLoginWithEmail() throws Exception {
    	loginPage.LoginWithEmail(this.buyerEmail);
    }
    @Test(priority =2,groups = {"smoke"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify signup of a user")
    public void testSignUpWithEmailNewUser() throws Exception {
        loginPage.signUpWithEmail();
    }
    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify Email Input validation")
    public void testEmailInputValidations() throws Exception {
        loginPage.emailInputEmpty();
    }
    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify Email Input validation")
    public void testEmailInvalidInput1() throws Exception {
        loginPage.emailInputInvalidText();
    }
    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify Email Input validation with 'abc@gmail'")
    public void testEmailInvalidInput2() throws Exception {
        loginPage.emailInputInvalidText2();
    }
    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify Email Input validation with ' '")
    public void testEmailInvalidInput3() throws Exception {
        loginPage.emailInputInvalidText3();
    }
    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify OTP empty input")
    public void testOtpInputEmpty() throws Exception {
        loginPage.otpInputEmpty(this.sellerEmail);
    }
    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify OTP empty input")
    public void testOtpInvalidInput() throws Exception {
        loginPage.otpInputInvalid(this.sellerEmail);
    }
    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify OTP empty input")
    public void testOtpInvalidInput2() throws Exception {
        loginPage.otpInvalidInput2(this.sellerEmail);
    }

}

