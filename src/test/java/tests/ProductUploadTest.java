package tests;

import org.testng.annotations.Test;
public class ProductUploadTest extends BaseTest {
    @Test
    public void testProductUploadWithCamera() {
        loginPage.LoginWithEmail(this.buyerEmail);
        productUploadPage.productUploadWithCamera(this.productName ,this.productPrice ,this.productLocation);
    }

    @Test
    public void testProductUploadWithGallery(){
        loginPage.LoginWithEmail(this.buyerEmail);
        productUploadPage.productUploadWithGallery(this.productName ,this.productPrice ,this.productLocation);
    }


}
