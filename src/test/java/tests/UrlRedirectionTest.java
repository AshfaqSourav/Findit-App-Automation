package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class UrlRedirectionTest extends BaseTest{
    @Test(priority = 1,groups = {"regression"})
    @Description("Verify login popup terms & condition ,privacy policy,EULA link redirection")
    public void testLoginPopupTermsAndConditionRedirection()  {
        urlRedirectionPage.loginPopupTermsAndCondition();
    }
    @Test(priority = 2,groups = {"regression"})
    @Description("Verify login popup terms & condition ,privacy policy,EULA link redirection")
    public void testLoginPopupPrivacyPolicyRedirection() {
        urlRedirectionPage.loginPopupPrivacyAndPolicy();
    }
    @Test(priority = 3,groups = {"regression"})
    @Description("Verify login popup terms & condition ,privacy policy,EULA link redirection")
    public void testLoginPopupEulaRedirection() {
        urlRedirectionPage.loginPopupEula();
    }
    @Test(priority = 4,groups = {"regression"})
    @Description("Verify Settings page terms & condition link redirection")
    public void testSettingsTermsAndConditionRedirection() throws Exception {
        loginPage.LoginWithEmail(sellerEmail);
        logoutPage.NavigateToSettings();
        urlRedirectionPage.settingsTermsAndCondition();
    }
    @Test(priority = 5,groups = {"regression"})
    @Description("Verify Settings page privacy policy link redirection")
    public void testSettingsPrivacyPolicyRedirection() throws Exception {
        loginPage.LoginWithEmail(sellerEmail);
        logoutPage.NavigateToSettings();
        urlRedirectionPage.settingsPrivacyAndPolicy();
    }
    @Test(priority = 6,groups = {"regression"})
    @Description("Verify Settings page about findit link redirection")
    public void testSettingsAboutFindItRedirection() throws Exception {
        loginPage.LoginWithEmail(sellerEmail);
        logoutPage.NavigateToSettings();
        urlRedirectionPage.settingsAboutFindit();
    }
    @Test(priority = 7,groups = {"regression"})
    @Description("Verify Settings page refund policy link redirection")
    public void testSettingsRefundPolicyRedirection() throws Exception {
        loginPage.LoginWithEmail(sellerEmail);
        logoutPage.NavigateToSettings();
        urlRedirectionPage.settingsRefundPolicy();
    }
    @Test(priority = 8,groups = {"regression"})
    @Description("Verify settings whatsapp link redirection with whatsapp number validation")
    public void testWhatsappUrlRedirection() throws Exception {
        loginPage.LoginWithEmail(sellerEmail);
        logoutPage.NavigateToSettings();
        urlRedirectionPage.whatsappLink();
    }
    @Test(priority = 13,groups = {"regression"})
    @Description("Verify no internet toast")
    public void testNoInternetToast()  {
        urlRedirectionPage.noInternetToast();
    }
    @Test(priority = 14,groups = {"regression"})
    @Description("Verify no internet page")
    public void testNoInternetOnAppStartup() throws Exception {
        urlRedirectionPage.noInternetPage();
    }
    @Test(priority = 9,groups = {"regression"})
    @Description("Verify sell it guide link redirection")
    public void testSellItGuideUrlRedirection()  {
        urlRedirectionPage.sellItGuide();
    }
    @Test(priority = 10,groups = {"regression"})
    @Description("Verify visit link redirection")
    public void testVisitUrlRedirection()  {
        urlRedirectionPage.visit();
    }
    @Test(priority = 11,groups = {"regression"})
    @Description("Verify prohibited product link redirection")
    public void testProhibitedProductUrlRedirection() throws Exception {
        loginPage.LoginWithEmail(buyerEmail);
        urlRedirectionPage.prohibitedProduct("prohibited_product.jpg");
    }
    @Test(priority = 12,groups = {"regression"})
    @Description("Verify warning product link redirection")
    public void testWarningProductUrlRedirection() throws Exception {
        loginPage.LoginWithEmail(buyerEmail);
        urlRedirectionPage.warningProduct("warning_product.jpg");
    }
}
