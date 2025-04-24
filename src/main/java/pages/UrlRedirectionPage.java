package pages;

import com.google.common.collect.ImmutableMap;
import config.DeviceConfig;
import enums.LocatorClassName;
import enums.LocatorType;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class UrlRedirectionPage extends BasePage{
    public UrlRedirectionPage() {
        super();
    }

    public void loginPopupTermsAndCondition() {
        waitForVisibilityOfElement("LOGIN_POPUP", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForVisibilityOfElement("LOGINPOPUP_TERMSANDCONDITION_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.clickButton("LOGINPOPUP_TERMSANDCONDITION_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("TERMSANDCONDITION_TEXT_PAGEVIEW", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.sleep(5000);
        Assert.assertTrue(displayStatus("TERMSANDCONDITION_TEXT_TOPBAR",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("TERMSANDCONDITION_TEXT_PAGEVIEW",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("DECLINE_COOKIE_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("COOKIE_CONSENT_TEXT",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("BACK_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
    }
    public void loginPopupPrivacyAndPolicy() {
        waitForVisibilityOfElement("LOGINPOPUP_PRIVACYPOLICY_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.clickButton("LOGINPOPUP_PRIVACYPOLICY_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("PRIVACYPOLICY_TEXT_PAGEVIEW", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.sleep(5000);
        Assert.assertTrue(displayStatus("PRIVACYPOLICY_TEXT_TOPBAR",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("PRIVACYPOLICY_TEXT_PAGEVIEW",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("DECLINE_COOKIE_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("COOKIE_CONSENT_TEXT",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("BACK_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
    }
    public void loginPopupEula() {
        waitForVisibilityOfElement("LOGINPOPUP_EULA_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.clickButton("LOGINPOPUP_EULA_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("EULA_TEXT_PAGEVIEW", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.sleep(5000);
        Assert.assertTrue(displayStatus("EULA_TEXT_TOPBAR",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("EULA_TEXT_PAGEVIEW",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("DECLINE_COOKIE_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("COOKIE_CONSENT_TEXT",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("BACK_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("LOGIN_POPUP", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
    public void settingsTermsAndCondition() {
        waitForVisibilityOfElement("SETTINGS_TERMSANDCONDITION_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.clickButton("SETTINGS_TERMSANDCONDITION_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("TERMSANDCONDITION_TEXT_PAGEVIEW", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.sleep(5000);
        Assert.assertTrue(displayStatus("TERMSANDCONDITION_TEXT_TOPBAR",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("TERMSANDCONDITION_TEXT_PAGEVIEW",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("DECLINE_COOKIE_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("COOKIE_CONSENT_TEXT",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("BACK_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
    }
    public void settingsPrivacyAndPolicy() {
        waitForVisibilityOfElement("SETTINGS_PRIVACYPOLICY_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.clickButton("SETTINGS_PRIVACYPOLICY_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("PRIVACYPOLICY_TEXT_PAGEVIEW", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.sleep(5000);
        Assert.assertTrue(displayStatus("PRIVACYPOLICY_TEXT_TOPBAR",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("PRIVACYPOLICY_TEXT_PAGEVIEW",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("DECLINE_COOKIE_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("COOKIE_CONSENT_TEXT",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("BACK_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
    }
    public void settingsAboutFindit() {
        waitForVisibilityOfElement("SETTINGS_ABOUTFINDIT_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.clickButton("SETTINGS_ABOUTFINDIT_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("ABOUTFINDIT_TEXT_PAGEVIEW", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.sleep(5000);
        Assert.assertTrue(displayStatus("ABOUTFINDIT_TEXT_TOPBAR",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("ABOUTFINDIT_TEXT_PAGEVIEW",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("DECLINE_COOKIE_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("COOKIE_CONSENT_TEXT",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("BACK_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
    }
    public void settingsRefundPolicy() {
        waitForVisibilityOfElement("SETTINGS_REFUNDPOLICY_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.clickButton("SETTINGS_REFUNDPOLICY_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("REFUNDPOLICY_TEXT_PAGEVIEW", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.sleep(5000);
        Assert.assertTrue(displayStatus("REFUNDPOLICY_TEXT_TOPBAR",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("REFUNDPOLICY_TEXT_PAGEVIEW",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("DECLINE_COOKIE_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("COOKIE_CONSENT_TEXT",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("BACK_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
    }
    public void whatsappLink(){
        waitForVisibilityOfElement("WHATSAPP_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        this.clickButton("WHATSAPP_LINK", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
//        try {
//            // Wait for the Chrome first-run screen
//            waitForVisibilityOfElement("CHROME", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
//            this.clickButton("CHROME", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
//            System.out.println("Clicked 'Use without an account' to bypass Chrome sign-in.");
//            this.sleep(3000); // Wait for Chrome to proceed
//        } catch (Exception e) {
//            System.out.println("Chrome sign-in screen not found, continuing execution.");
//        }
        waitForVisibilityOfElement("WHATSAPP_LINK_PAGEVIEW", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
        Assert.assertTrue(displayStatus("WHATSAPP_LINK_TOPBAR",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("WHATSAPP_LINK_PAGEVIEW",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        validateWhatsAppNumber(DeviceConfig.properties.getProperty("whatsappNumber"));
    }
    public static final String WHATSAPP_LINK_PAGEVIEW = "//android.view.View[@text=\"Chat on WhatsApp with +62 811-9001-3750\"]";

    public static void validateWhatsAppNumber(String configuredNumber) {
        // Define regex to extract the WhatsApp number
        String regex = "\\+\\d+[\\s\\d-]*";  // Supports spaces and hyphens inside the number
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(WHATSAPP_LINK_PAGEVIEW);

        if (matcher.find()) {
            // Extract the number from the XPath text
            String extractedNumber = matcher.group().trim();
            System.out.println("Extracted Number from XPath: " + extractedNumber);

            // Normalize numbers by removing spaces and hyphens for an accurate comparison
            String normalizedExtractedNumber = extractedNumber.replaceAll("[^\\d+]", "");
            String normalizedConfiguredNumber = configuredNumber.replaceAll("[^\\d+]", "");

            System.out.println("Normalized Extracted Number: " + normalizedExtractedNumber);
            System.out.println("Normalized Configured Number: " + normalizedConfiguredNumber);

            // Assert that the extracted number matches the configured number
            Assert.assertEquals(normalizedExtractedNumber, normalizedConfiguredNumber,
                    "Configured WhatsApp number does not match the number in WHATSAPP_LINK_PAGEVIEW!");
        } else {
            Assert.fail("No valid WhatsApp number found in WHATSAPP_LINK_PAGEVIEW!");
        }
    }
    public void noInternetToast(){
        waitForVisibilityOfElement("LOGIN_POPUP", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        BasePage.forceOffline();
        waitForVisibilityOfElement("NO_INTERNET_TOAST", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        Assert.assertTrue(displayStatus("NO_INTERNET_TOAST",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        BasePage.forceOnline();
        waitForInvisibilityOfElement("NO_INTERNET_TOAST", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.sleep(4000);
    }
    public void noInternetPage() throws Exception {
        BasePage.forceOffline();
        BasePage.restartFreshApp();
        waitForVisibilityOfElement("NO_INTERNET_TOAST", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        BasePage.forceOnline();
        waitForInvisibilityOfElement("NO_INTERNET_TOAST", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        Assert.assertTrue(displayStatus("RETRY_BUTTON",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.sleep(4000);
    }
    public void sellItGuide(){
        waitForVisibilityOfElement("LOGIN_POPUP", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("SKIP_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("SELL_IT_GUIDE_TEXT", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("SELL_IT_GUIDE_TEXT", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("GUIDELINE_TEXT_PAGEVIEW", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForInvisibilityOfElement("BLOG_NAVBAR", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        Assert.assertTrue(displayStatus("GUIDELINE_TEXT_PAGEVIEW",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("SELL_IT_GUIDE_TOPBAR_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("PLAY_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("BACK_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
    }
    public void visit(){
        waitForVisibilityOfElement("LOGIN_POPUP", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("SKIP_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("VISIT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("VISIT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("GUIDELINE_TEXT_PAGEVIEW", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForInvisibilityOfElement("BLOG_NAVBAR", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        Assert.assertTrue(displayStatus("GUIDELINE_TEXT_PAGEVIEW",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("VISIT_TOPBAR_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("PLAY_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("BACK_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
    }
    public void prohibitedProduct(String imageName){
        ProductUploadPage.uploadImageToEmulator(imageName);
        waitForVisibilityOfElement("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("UPLOAD_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("UPLOAD_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.sleep(4000);
        waitForVisibilityOfElement("SELECT_IMAGE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("SELECT_IMAGE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.sleep(30000);
        waitForVisibilityOfElement("PROHIBITED_BOTTOM_SHEET", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("PROHIBITED_BOTTOM_SHEET_TEXT_LINK",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("PROHIBITED_WARNING_PAGEVIEW", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForInvisibilityOfElement("BLOG_NAVBAR", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        Assert.assertTrue(displayStatus("PROHIBITED_TOPBAR",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("PROHIBITED_WARNING_PAGEVIEW",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("BACK_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("UPLOAD_NEW_PRODUCT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("SELL_IT_PAGE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
    public void warningProduct(String imageName){
        ProductUploadPage.uploadImageToEmulator(imageName);
        this.clickButton("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("UPLOAD_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("UPLOAD_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.sleep(5000);
        waitForVisibilityOfElement("SELECT_IMAGE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("SELECT_IMAGE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.sleep(20000);
        waitForVisibilityOfElement("WARNING_BOTTOM_SHEET_TEXT_LINK", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("WARNING_BOTTOM_SHEET_TEXT_LINK",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("PROHIBITED_WARNING_PAGEVIEW", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForInvisibilityOfElement("BLOG_NAVBAR", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        Assert.assertTrue(displayStatus("WARNING_TOPBAR",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("PROHIBITED_WARNING_PAGEVIEW",LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("BACK_BUTTON", LocatorClassName.URL_REDIRECTION_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("ACCEPT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("PRODUCT_NAME_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
}
