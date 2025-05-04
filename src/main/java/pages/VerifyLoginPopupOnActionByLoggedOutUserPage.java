package pages;

import enums.LocatorClassName;
import enums.LocatorType;
import org.testng.Assert;

public class VerifyLoginPopupOnActionByLoggedOutUserPage extends BasePage {
    public VerifyLoginPopupOnActionByLoggedOutUserPage() {
        super();
    }

    public void homepageFavIcon(){
        waitForVisibilityOfElement("SKIP_BUTTON", LocatorClassName.VERIFY_LOGIN_POPUP_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("SKIP_BUTTON", LocatorClassName.VERIFY_LOGIN_POPUP_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("ALL_CATEGORY_BTN", LocatorClassName.VERIFY_LOGIN_POPUP_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForVisibilityOfElement("HOMEPAGE_FAV_ICON", LocatorClassName.VERIFY_LOGIN_POPUP_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("HOMEPAGE_FAV_ICON", LocatorClassName.VERIFY_LOGIN_POPUP_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("LOGIN_POPUP_TEXT", LocatorClassName.VERIFY_LOGIN_POPUP_LOCATOR_CLASS.toString(), LocatorType.XPATH,20));
    }
}
