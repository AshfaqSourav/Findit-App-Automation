//package pages;
//
//import enums.LocatorClassName;
//import enums.LocatorType;
//import io.appium.java_client.MobileElement;
//
//import java.io.File;
//import java.io.IOException;
//
//public class ProductUploadPage extends BasePage {
//    public ProductUploadPage() {
//        super();
//    }
//
//
//    public void productUploadWithCamera(String productName, String price, String location) {
//        this.clickButton("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
//        logger.info("Clicked on SELL_IT_BUTTON");
//        this.clickButton("CAPTURE_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
//        this.clickButton("WHILE_USING_THE_APP_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
//        this.clickButton("CAPTURE_TAP_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
//        this.clickButton("CAPTURE_OK_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
//        this.sleep(15000);
//        this.clickTextField("PRODUCT_NAME_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR, productName);
//        this.clickButton("CATEGORY_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
//        this.clickButton("CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
//        this.clickButton("SUB_CATEGORY_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
//        this.clickButton("SUB_CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
//        scrollToEnd();
//        this.clickButton("CONDITION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
//        this.clickButton("CONDITION_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
//        this.clickButton("NEXT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
//        this.clickTextField("PRICE_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR, price);
//        this.clickTextField("PICKUP_LOCATION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR, location);
//        this.sleep(3000);
//        this.clickButton("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
//        this.clickButton("POST_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
//        this.sleep(10000);
//    }
//
//    public void productUploadWithGallery(String productName, String price, String location) {
//        this.uploadImagesToEmulator();
//        this.clickButton("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
//        logger.info("clicked1");
//        this.clickButton("UPLOAD_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
//        logger.info("clicked2");
//        this.clickButton("SELECT_FOLDER",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
//        logger.info("clicked3");
//        this.clickButton("SELECT_IMAGE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
//        logger.info("clicked4");
//        this.sleep(20000);
////        waitUntilElementIsVisible(LocatorType.UI_AUTOMATOR, "PRODUCT_NAME_FIELD");
//    }
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
//                    // Push the image to the "Downloads" folder
//                    String command = String.format(
//                            "adb push \"%s\" /sdcard/Download/",
//                            imageFile.getAbsolutePath()
//                    );
//                    System.out.println("Executing command: " + command);
//
//                    Process process = Runtime.getRuntime().exec(command);
//                    process.waitFor();
//
//                    // Trigger Media Scanner for the new file
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
//}
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
        this.clickButton("CAPTURE_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
        this.clickButton("WHILE_USING_THE_APP_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
        this.clickButton("CAPTURE_TAP_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
        this.clickButton("CAPTURE_OK_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
        waitForVisibilityOfElement("PRODUCT_NAME_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR,30);
        this.clickTextField("PRODUCT_NAME_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR, productName);
        this.clickButton("CATEGORY_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
        this.clickButton("CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("SUB_CATEGORY_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
        this.clickButton("SUB_CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.scrollHalfway();
        this.clickButton("CONDITION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
        this.clickButton("CONDITION_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("NEXT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickTextField("PRICE_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR, price);
        this.clickTextField("PICKUP_LOCATION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR, location);
        waitForVisibilityOfElement("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR,10);
        this.clickButton("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
        this.clickButton("POST_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
    }

    public void productUploadWithGallery(String productName, String price, String location) {
        this.uploadImagesToEmulator();
        this.clickButton("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("UPLOAD_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
        this.clickButton("SELECT_FOLDER",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
        this.clickButton("SELECT_IMAGE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
        waitForVisibilityOfElement("PRODUCT_NAME_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR,30);
        enterTextIfEmpty("PRODUCT_NAME_FIELD",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR,productName);
        this.scrollHalfway();
        if(displayStatus("CATEGORY_FIELD_EMPTY",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR)){
            this.clickButton("CATEGORY_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
            this.clickButton("CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        if(displayStatus("SUB_CATEGORY_FIELD_EMPTY",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH)){
            this.clickButton("SUB_CATEGORY_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
            this.clickButton("SUB_CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        this.clickButton("CONDITION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
        this.clickButton("CONDITION_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("NEXT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickTextField("PRICE_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR, price);
        this.clickTextField("PICKUP_LOCATION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR, location);
        waitForVisibilityOfElement("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR,30);
        this.clickButton("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.UI_AUTOMATOR);
        this.clickButton("POST_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
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

