package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import java.io.IOException;

public class VerifyLoginPopupOnActionByLoggedOutUserTest extends BaseTest{
    @Test(priority =1,groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify logged out user homepage Fav button")
    public void testHomepageFavBtnAction() {
        verifyLoginPopupOnActionByLoggedOutUserPage.homepageFavIcon();
    }
}
