package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import java.io.IOException;

public class ProductUploadTest extends BaseTest {
    @Test(enabled = false,priority = 1,groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    @Description("Verify upload with camera and all field validation in upload page")
    public void testProductUploadWithCamera() throws IOException, InterruptedException {
        loginPage.LoginWithEmail(this.buyerEmail);
        productUploadPage.productUploadWithCamera(this.productName ,this.productPrice ,this.productLocation);
    }

    @Test(enabled = false)
    public void testProductUploadWithGallery() throws IOException, InterruptedException {
        loginPage.LoginWithEmail(this.buyerEmail);
        productUploadPage.productUploadWithGallery(this.productName ,this.productPrice ,this.productLocation);
    }


}
