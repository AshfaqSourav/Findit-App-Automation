package tests;

import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {
    @Test
    public void testLoginWithEmail() {
    	loginPage.LoginWithEmail(this.buyerEmail);
    }
}

