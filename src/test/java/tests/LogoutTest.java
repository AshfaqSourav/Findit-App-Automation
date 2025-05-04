package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import utils.RetryAnalyzer;

import java.io.IOException;

public class LogoutTest extends BaseTest{
    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify logout of a user")
    public void testLogout() throws IOException, InterruptedException {
        loginPage.LoginWithEmail(this.buyerEmail);
        logoutPage.logout();
    }
}
