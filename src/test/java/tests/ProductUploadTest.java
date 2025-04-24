package tests;

import org.testng.annotations.Test;

import java.io.IOException;

public class ProductUploadTest extends BaseTest {
    @Test
    public void testProductUploadWithCamera() throws IOException {
        loginPage.LoginWithEmail(this.buyerEmail);
        productUploadPage.productUploadWithCamera(this.productName ,this.productPrice ,this.productLocation);
    }

    @Test(enabled = false)
    public void testProductUploadWithGallery() throws IOException {
        loginPage.LoginWithEmail(this.buyerEmail);
        productUploadPage.productUploadWithGallery(this.productName ,this.productPrice ,this.productLocation);
    }


}
