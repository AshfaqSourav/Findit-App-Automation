package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import java.io.IOException;

public class LanguageChangeTest extends BaseTest {
    @Test(priority =1,groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify login popup language change to Bahasa")
    public void testLoginPopupLangChangeID() {
        languageChangePage.FromLoginPopupLangChangeToID();
    }
    @Test(priority =2,groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify login popup language change to English")
    public void testLoginPopupLangChangeENG() {
        languageChangePage.FromLoginPopupLangChangeToENG();
    }
    @Test(priority =3,groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify settings language change to Bahasa")
    public void testSettingsLangChangeID() throws IOException, InterruptedException {
        loginPage.LoginWithEmail(this.buyerEmail);
        logoutPage.NavigateToSettings();
        languageChangePage.FromSettingsLangChangeToID();
    }
    @Test(priority =4,groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify settings language change to English")
    public void testSettingsLangChangeENG() throws IOException, InterruptedException {
        loginPage.LoginWithEmail(this.buyerEmail);
        logoutPage.NavigateToSettings();
        languageChangePage.FromSettingsLangChangeToENG();
    }
}
