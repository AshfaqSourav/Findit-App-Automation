package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

public class LogoutTest extends BaseTest{
    @Test(groups = {"regression"})
    @Description("Verify logout of a user")
    public void testLogout() throws Exception {
//        BasePage.restartFreshApp();
        loginPage.LoginWithEmail(this.buyerEmail);
        Assert.fail("This test is intentionally failed.");
        BasePage.quitDriver();
        logoutPage.logout();
    }
}
