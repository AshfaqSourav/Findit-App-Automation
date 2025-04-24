package pages;

import enums.LocatorClassName;
import enums.LocatorType;
import org.testng.Assert;


import java.io.File;
import java.io.IOException;


public class ProductUploadPage extends BasePage {
    public ProductUploadPage() {
        super();
    }

    public void productUploadWithCamera(String productName, String price, String location) throws IOException {
        waitForVisibilityOfElement("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("CAPTURE_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("CAPTURE_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        sleep(10000);
        this.clickButton("CAPTURE_TAP_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("CAPTURE_OK_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("CAPTURE_OK_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("PRODUCT_NAME_TEXT", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);

        //image add by camera using icon
        this.clickButton("UPLOAD_ADD_IMAGE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("UPLOAD_ADD_IMAGE_BOTTOM_SHEET", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("UPLOAD_ADD_IMAGE_CAPTURE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        sleep(4000);
        this.clickButton("CAPTURE_TAP_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("CAPTURE_OK_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("CAPTURE_OK_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("IMAGES_EXPAND", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("IMAGES_EXPAND", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("IMAGES_ONE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForVisibilityOfElement("IMAGES_TWO", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForVisibilityOfElement("IMAGES_ADD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("IMAGES_DELETE_ICON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("IMAGES_ONE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);

        //image add by camera from images expantion panel
        this.clickButton("IMAGES_TWO", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("UPLOAD_ADD_IMAGE_BOTTOM_SHEET", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("UPLOAD_ADD_IMAGE_CAPTURE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        sleep(4000);
        this.clickButton("CAPTURE_TAP_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("CAPTURE_OK_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("CAPTURE_OK_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("IMAGES_ONE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForVisibilityOfElement("IMAGES_TWO", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForVisibilityOfElement("IMAGES_ADD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("IMAGES_DELETE_ICON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("IMAGES_ONE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);

        //image add from gallery from images expantion panel
        ProductUploadPage.uploadImageToEmulator("gloves.jpg");
        this.sleep(2000);
        this.clickButton("IMAGES_TWO", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("UPLOAD_ADD_IMAGE_BOTTOM_SHEET", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("UPLOAD_ADD_IMAGE_UPLOAD_FROM_GALLERY", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("SELECT_IMAGE2", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.sleep(2000);
        this.clickButton("SELECT_IMAGE2", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("IMAGES_ONE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForVisibilityOfElement("IMAGES_TWO", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForVisibilityOfElement("IMAGES_ADD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("IMAGES_DELETE_ICON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("IMAGES_ONE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);

        //image add from gallery using icon
        ProductUploadPage.uploadImageToEmulator("gloves.jpg");
        this.sleep(2000);
        this.clickButton("IMAGES_EXPAND", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("UPLOAD_ADD_IMAGE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("UPLOAD_ADD_IMAGE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("UPLOAD_ADD_IMAGE_BOTTOM_SHEET", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("UPLOAD_ADD_IMAGE_UPLOAD_FROM_GALLERY", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("SELECT_IMAGE2", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.sleep(2000);
        this.clickButton("SELECT_IMAGE2", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("IMAGES_EXPAND", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("IMAGES_ONE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForVisibilityOfElement("IMAGES_TWO", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForVisibilityOfElement("IMAGES_ADD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("IMAGES_DELETE_ICON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("IMAGES_ONE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("IMAGES_EXPAND", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);









        this.clickButton("REGENERATE_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("REGENERATE_BUTTON_LOADING", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForInvisibilityOfElement("REGENERATE_BUTTON_LOADING", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        waitForVisibilityOfElement("REGENERATE_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);

        enterTextIfEmpty("PRODUCT_NAME_FIELD",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,productName);

//        this.writeTextField("PRODUCT_NAME_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, productName);
        this.clickButton("CATEGORY_FIELD_EMPTY", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.scrollHalfway();
        this.clickButton("SUB_CATEGORY_FIELD_EMPTY", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("SUB_CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("CONDITION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("CONDITION_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("NEXT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.writeTextField("PRICE_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, price);
        this.clickButton("PICKUP_LOCATION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, location);
        waitForVisibilityOfElement("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,10);
        this.clickButton("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("POST_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("VIEW_AD_PAGE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,30);
        Assert.assertTrue(displayStatus("VIEW_AD_PAGE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }

    public void productUploadWithGallery(String productName, String price, String location) throws IOException {
//        this.uploadImageToEmulator(gloves.jpg);
        this.clickButton("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("UPLOAD_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("SELECT_FOLDER",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("SELECT_IMAGE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("PRODUCT_NAME_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
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
        this.writeTextField("PRICE_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, price);
        this.writeTextField("PICKUP_LOCATION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, location);
        waitForVisibilityOfElement("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,30);
        this.clickButton("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("POST_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("VIEW_AD_PAGE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,30);
        Assert.assertTrue(displayStatus("VIEW_AD_PAGE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }
//public void buyProduct(String productName){
//        this.writeTextField("SEARCH", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, productName);
//}
//    public void uploadImagesToEmulator() {
//        String assetsFolderPath = System.getProperty("user.dir") + "/src/test/resources/assets/images";
//        File folder = new File(assetsFolderPath);
//
//        if (!folder.exists() || !folder.isDirectory()) {
//            throw new RuntimeException("Assets folder not found at: " + assetsFolderPath);
//        }
//
//        File[] imageFiles = folder.listFiles();
//        if (imageFiles == null || imageFiles.length == 0) {
//            throw new RuntimeException("No images found in assets folder.");
//        }
//
//        for (File imageFile : imageFiles) {
//            try {
//                if (imageFile.isFile() && (imageFile.getName().endsWith(".jpeg") || imageFile.getName().endsWith(".jpg") || imageFile.getName().endsWith(".png"))) {
//                    String command = String.format("adb push \"%s\" /sdcard/Download/", imageFile.getAbsolutePath());
//                    System.out.println("Executing command: " + command);
//
//                    Process process = Runtime.getRuntime().exec(command);
//                    process.waitFor();
//
//                    String mediaScanCommand = String.format(
//                            "adb shell am broadcast -a android.intent.action.MEDIA_SCANNER_SCAN_FILE -d file:///sdcard/Download/%s",
//                            imageFile.getName()
//                    );
//                    Process mediaScanProcess = Runtime.getRuntime().exec(mediaScanCommand);
//                    mediaScanProcess.waitFor();
//
//                    System.out.println("Uploaded to Downloads and scanned: " + imageFile.getName());
//                }
//            } catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//                throw new RuntimeException("Failed to upload image to Downloads: " + imageFile.getName());
//            }
//        }
//    }
public static void uploadImageToEmulator(String imageName) {
    String assetsFolderPath = System.getProperty("user.dir") + "/src/test/resources/assets/images";
    File imageFile = new File(assetsFolderPath, imageName);

    if (!imageFile.exists() || !imageFile.isFile()) {
        throw new RuntimeException("Image not found in assets: " + imageFile.getAbsolutePath());
    }

    try {
        // ✅ Clear Download folder on emulator
        String clearCommand = "adb shell rm -f /sdcard/Download/*";
        System.out.println("🧹 Clearing Download folder...");
        Process clearProcess = Runtime.getRuntime().exec(clearCommand);
        clearProcess.waitFor();

        // Push image to emulator
        String pushCommand = String.format("adb push \"%s\" /sdcard/Download/", imageFile.getAbsolutePath());
        System.out.println("📤 Executing command: " + pushCommand);
        Process pushProcess = Runtime.getRuntime().exec(pushCommand);
        pushProcess.waitFor();

        // Trigger media scan
        String scanCommand = String.format(
                "adb shell am broadcast -a android.intent.action.MEDIA_SCANNER_SCAN_FILE -d file:///sdcard/Download/%s",
                imageFile.getName()
        );
        Process scanProcess = Runtime.getRuntime().exec(scanCommand);
        scanProcess.waitFor();

        System.out.println("✅ Uploaded and scanned image: " + imageName);

    } catch (IOException | InterruptedException e) {
        throw new RuntimeException("❌ Failed to upload image: " + imageName, e);
    }
}

}

