package tests;

import org.testng.annotations.Test;
public class ProductUploadTest extends BaseTest {
    @Test(enabled = false)
    public void testProductUploadWithCamera() {
        loginPage.LoginWithEmail(this.buyerEmail);
        productUploadPage.productUploadWithCamera(this.productName ,this.productPrice ,this.productLocation);
    }

    @Test(enabled = false)
    public void testProductUploadWithGallery(){
        loginPage.LoginWithEmail(this.buyerEmail);
        productUploadPage.productUploadWithGallery(this.productName ,this.productPrice ,this.productLocation);
    }


}
