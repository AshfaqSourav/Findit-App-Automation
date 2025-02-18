package pages;

import enums.LocatorClassName;
import enums.LocatorType;


import java.io.File;
import java.io.IOException;


public class ProductUploadPage extends BasePage {
    public ProductUploadPage() {
        super();
    }

    public void productUploadWithCamera(String productName, String price, String location) {
        this.clickButton("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("CAPTURE_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("CAPTURE_TAP_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("CAPTURE_OK_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("PRODUCT_NAME_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,30);
        this.clickTextField("PRODUCT_NAME_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, productName);
        this.clickButton("CATEGORY_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.scrollHalfway();
        this.clickButton("SUB_CATEGORY_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("SUB_CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("CONDITION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("CONDITION_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("NEXT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickTextField("PRICE_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, price);
        this.clickTextField("PICKUP_LOCATION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, location);
        waitForVisibilityOfElement("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,10);
        this.clickButton("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("POST_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
    }

    public void productUploadWithGallery(String productName, String price, String location) {
        this.uploadImagesToEmulator();
        this.clickButton("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("UPLOAD_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("SELECT_FOLDER",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("SELECT_IMAGE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("PRODUCT_NAME_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,30);
        enterTextIfEmpty("PRODUCT_NAME_FIELD",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,productName);
        if(displayStatus("CATEGORY_FIELD_EMPTY",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH)){
            this.clickButton("CATEGORY_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            this.clickButton("CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        this.scrollHalfway();
        if(displayStatus("SUB_CATEGORY_FIELD_EMPTY",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH)){
            this.clickButton("SUB_CATEGORY_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            this.clickButton("SUB_CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        this.clickButton("CONDITION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("CONDITION_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("NEXT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickTextField("PRICE_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, price);
        this.clickTextField("PICKUP_LOCATION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, location);
        waitForVisibilityOfElement("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,30);
        this.clickButton("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("POST_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
    }
public void buyProduct(String productName){
        this.clickTextField("SEARCH", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, productName);
}
    public void uploadImagesToEmulator() {
        String assetsFolderPath = System.getProperty("user.dir") + "/src/test/resources/assets/images";
        File folder = new File(assetsFolderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            throw new RuntimeException("Assets folder not found at: " + assetsFolderPath);
        }

        File[] imageFiles = folder.listFiles();
        if (imageFiles == null || imageFiles.length == 0) {
            throw new RuntimeException("No images found in assets folder.");
        }

        for (File imageFile : imageFiles) {
            try {
                if (imageFile.isFile() && (imageFile.getName().endsWith(".jpeg") || imageFile.getName().endsWith(".jpg") || imageFile.getName().endsWith(".png"))) {
                    String command = String.format("adb push \"%s\" /sdcard/Download/", imageFile.getAbsolutePath());
                    System.out.println("Executing command: " + command);

                    Process process = Runtime.getRuntime().exec(command);
                    process.waitFor();

                    String mediaScanCommand = String.format(
                            "adb shell am broadcast -a android.intent.action.MEDIA_SCANNER_SCAN_FILE -d file:///sdcard/Download/%s",
                            imageFile.getName()
                    );
                    Process mediaScanProcess = Runtime.getRuntime().exec(mediaScanCommand);
                    mediaScanProcess.waitFor();

                    System.out.println("Uploaded to Downloads and scanned: " + imageFile.getName());
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to upload image to Downloads: " + imageFile.getName());
            }
        }
    }
}

