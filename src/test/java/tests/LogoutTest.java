package tests;

import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    @Test
    public void testLogout() {
        loginPage.LoginWithEmail(this.buyerEmail);
        logoutPage.logout();
    }
}
