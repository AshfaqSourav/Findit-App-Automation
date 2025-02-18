package tests;

import org.testng.annotations.Test;
import pages.BasePage;


public class LoginPageTest extends BaseTest {
    @Test
    public void testLoginWithEmail() throws Exception {
//        BasePage.restartFreshApp();
    	loginPage.LoginWithEmail(this.buyerEmail);
    }
}

