package pages;
import org.testng.Assert;
import enums.LocatorClassName;
import enums.LocatorType;

public class LogoutPage extends BasePage{
    public LogoutPage() {
        super();
    }

    public void logout(){
        waitForVisibilityOfElement("PROFILE_BUTTON", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("PROFILE_BUTTON", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("SETTINGS_BUTTON1", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("SETTINGS_BUTTON", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.scrollByPercentage(-1.0);
        this.clickButton("LOGOUT_BUTTON", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_POPUP", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        Assert.assertTrue(displayStatus("LOGIN_POPUP", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
    public void NavigateToSettings(){
        waitForVisibilityOfElement("PROFILE_BUTTON", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("PROFILE_BUTTON", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("SETTINGS_BUTTON1", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("SETTINGS_BUTTON", LocatorClassName.LOGOUT_LOCATOR_CLASS.toString(), LocatorType.XPATH);
    }
}
