package pages;

import enums.LocatorClassName;
import enums.LocatorType;
import org.testng.Assert;


public class LanguageChangePage extends BasePage {
    public LanguageChangePage() {
        super();
    }

    public void FromLoginPopupLangChangeToID() {
        if(displayStatus("UPDATE_POPUP", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        if(displayStatus("TEXT_ENG", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("LANG_CHANGE_ENGLISH", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("LANG_CHANGE_ENGLISH", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            waitForVisibilityOfElement("LANG_CHANGE_BAHASA", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("LANG_CHANGE_BAHASA", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            Assert.assertTrue(displayStatus("TEXT_ID", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        }
        Assert.assertTrue(displayStatus("TEXT_ID", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
    public void FromLoginPopupLangChangeToENG() {
        if(displayStatus("UPDATE_POPUP", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("UPDATE_POPUP_LATER_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        if(displayStatus("TEXT_ID", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("LANG_CHANGE_BAHASA", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("LANG_CHANGE_BAHASA", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            waitForVisibilityOfElement("LANG_CHANGE_ENGLISH", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("LANG_CHANGE_ENGLISH", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            Assert.assertTrue(displayStatus("TEXT_ENG", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        }
        Assert.assertTrue(displayStatus("TEXT_ENG", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
    public void FromSettingsLangChangeToID() {
        if(displayStatus("SETTINGS_LANG_ENG", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("SETTINGS_LANG_ENG", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("SETTINGS_LANG_ENG", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            waitForVisibilityOfElement("ID_RADIO_BTN", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("ID_RADIO_BTN", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            this.clickButton("LANG_PAGE_BACK_BTN", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            waitForVisibilityOfElement("SETTINGS_TXT_ID", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            Assert.assertTrue(displayStatus("SETTINGS_TXT_ID", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        }
        Assert.assertTrue(displayStatus("SETTINGS_TXT_ID", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
    public void FromSettingsLangChangeToENG() {
        if(displayStatus("SETTINGS_LANG_ID", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,5)){
            waitForVisibilityOfElement("SETTINGS_LANG_ID", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("SETTINGS_LANG_ID", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            waitForVisibilityOfElement("ENG_RADIO_BTN", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("ENG_RADIO_BTN", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            this.clickButton("LANG_PAGE_BACK_BTN", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            waitForVisibilityOfElement("SETTINGS_TXT_ENG", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            Assert.assertTrue(displayStatus("SETTINGS_TXT_ENG", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        }
        Assert.assertTrue(displayStatus("SETTINGS_TXT_ENG", LocatorClassName.LANGUAGE_CHANGE_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
}
