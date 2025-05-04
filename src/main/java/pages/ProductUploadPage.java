package pages;

import enums.LocatorClassName;
import enums.LocatorType;
import org.testng.Assert;
import utils.RandomWordUtils;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class ProductUploadPage extends BasePage {
    public ProductUploadPage() {
        super();
    }

    public void productUploadWithCamera(String productName, String price, String location) throws IOException, InterruptedException {
        uploadImageToEmulator("gloves.jpg");
        waitForVisibilityOfElement("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("SELL_IT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("CAPTURE_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("CAPTURE_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        sleep(10000);
        this.clickButton("CAPTURE_TAP_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("CAPTURE_OK_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("CAPTURE_OK_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        if(displayStatus("PROHIBITED_BOTTOM_SHEET", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,20)){
            this.clickButton("UPLOAD_NEW_PRODUCT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            waitForVisibilityOfElement("CAPTURE_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("CAPTURE_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            sleep(10000);
            this.clickButton("CAPTURE_TAP_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            waitForVisibilityOfElement("CAPTURE_OK_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
            this.clickButton("CAPTURE_OK_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
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


        //Error message check for mandatory fields(product name, category,sub category ,product condition
        this.clickButton("NEXT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("PRODUCT_NAME_ERROR_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("CATEGORY_ERROR_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.scrollHalfway();
        Assert.assertTrue(displayStatus("SUB_CATEGORY_ERROR_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("PRODUCT_CONDITION_ERROR_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.scrollUp();

        //Product name with space
        this.writeTextField("PRODUCT_NAME_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, " ");
        this.clickButton("NEXT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("PRODUCT_NAME_ERROR_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));

        //Regenerate button with 3 tries
        final int maxRetries = 3;
        int attempts = 0;
        boolean isFieldFilled = false;

        while (attempts < maxRetries && !isFieldFilled) {
            System.out.println("🌀 Attempt #" + (attempts + 1) + ": Clicking REGENERATE_BUTTON");
            clickButton("REGENERATE_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            waitForVisibilityOfElement("REGENERATE_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, 60);
            String fieldValue = getTextFromElement("PRODUCT_NAME_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            System.out.println("🔎 Retrieved field value: " + fieldValue);
            if (fieldValue != null && !fieldValue.trim().isEmpty()) {
                System.out.println("✅ Product name field is now filled.");
                isFieldFilled = true;
            } else {
                System.out.println("❌ PRODUCT_NAME_FIELD is still empty after attempt " + (attempts + 1));
            }
            attempts++;
        }
        if (!isFieldFilled) {
            System.out.println("⚠️ Field still empty after " + maxRetries + " attempts. Entering manually.");
            enterTextIfEmpty("PRODUCT_NAME_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, productName);
        }

        //Category search with space
        this.clickButton("CATEGORY_FIELD_EMPTY", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH," ");
        waitForVisibilityOfElement("SEARCH_SPACE_CROSS_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        Assert.assertTrue(displayStatus("SEARCH_SPACE_CROSS_BUTTON",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("SEARCH_SPACE_CROSS_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //Category search result empty
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"gggg");
        Assert.assertTrue(displayStatus("SEARCH_EMPTY_STATE_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("SEARCH_EMPTY_STATE_PICTURE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("SEARCH_GGGG_CROSS_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //Category search result found & selected
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"Sepat");
        Assert.assertTrue(displayStatus("CATEGORY_FIRST_OPTION",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("CATEGORY_FIELD_WOMENS_SHOE_SELECTED",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.scrollByPercentage(-0.50);

        //Sub Category search with space
        this.clickButton("SUB_CATEGORY_FIELD_EMPTY", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        if(displayStatus("SUB_CATEGORY_EMPTY_STATE_TEXT", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH)){
            this.clickButton("OUTSIDE_BOTTOM_SHEET_TAP", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
            this.clickButton("SUB_CATEGORY_FIELD_EMPTY", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        }
        this.scrollHalfway();
        waitForVisibilityOfElement("SUB_CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH," ");
        waitForVisibilityOfElement("SEARCH_SPACE_CROSS_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        Assert.assertTrue(displayStatus("SEARCH_SPACE_CROSS_BUTTON",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("SEARCH_SPACE_CROSS_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //Sub Category search result empty
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"gggg");
        waitForVisibilityOfElement("SEARCH_EMPTY_STATE_TEXT", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        Assert.assertTrue(displayStatus("SEARCH_EMPTY_STATE_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("SEARCH_EMPTY_STATE_PICTURE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("SEARCH_GGGG_CROSS_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //Sub Category search result found & selected
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"Other");
        waitForVisibilityOfElement("SUB_CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        Assert.assertTrue(displayStatus("SUB_CATEGORY_FIRST_OPTION",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("SUB_CATEGORY_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("SUB_CATEGORY_FIELD_OTHER_WOMENS_SHOE_SELECTED",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.scrollHalfway();

        //Brand search with space
        this.clickButton("BRAND_FIELD_EMPTY", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //Brand search result empty
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"gggg");
        Assert.assertTrue(displayStatus("SEARCH_EMPTY_STATE_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("SEARCH_EMPTY_STATE_PICTURE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("SEARCH_GGGG_CROSS_BUTTON_2", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //brand search result found & selected
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"Flor");
        waitForVisibilityOfElement("BRAND_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        Assert.assertTrue(displayStatus("BRAND_FIRST_OPTION",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("BRAND_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("BRAND_FLORENCE_SELECTED",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        //Add brand search result found & selected
        this.clickButton("BRAND_FLORENCE_SELECTED", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        String randomWord1 = RandomWordUtils.generateUniqueRandomWord(4);
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,randomWord1);
        waitForVisibilityOfElement("ADD_BRAND_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        Assert.assertTrue(displayStatus("ADD_BRAND_BUTTON",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("ADD_BRAND_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.scrollHalfway();

        //Model search with space
        this.clickButton("MODEL_FIELD_EMPTY", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //Model search result empty
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"gggg");
        Assert.assertTrue(displayStatus("SEARCH_EMPTY_STATE_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("SEARCH_EMPTY_STATE_PICTURE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.sleep(2000);
        this.clickButton("SEARCH_GGGG_CROSS_BUTTON_2", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.sleep(2000);
        String randomWord2 = RandomWordUtils.generateUniqueRandomWord(3);
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,randomWord2);
        Assert.assertTrue(displayStatus("ADD_MODEL_BUTTON",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("ADD_MODEL_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.scrollHalfway();

        //Product condition random option selected
        this.clickButton("CONDITION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("CONDITION_FIRST_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        List<String> randomOptions = Arrays.asList(
                "CONDITION_FIRST_OPTION",
                "CONDITION_SECOND_OPTION",
                "CONDITION_THIRD_OPTION",
                "CONDITION_FOURTH_OPTION",
                "CONDITION_FIFTH_OPTION"
        );
        this.clickRandomOption(randomOptions, LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.scrollHalfway();
        this.sleep(2000);
        //Dynamic field input
        this.scrollHalfway();
        this.sleep(2000);
        waitForVisibilityOfElement("DF_INPUT_SIZE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.writeTextField("DF_INPUT_SIZE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"48");

        //Dynamic field single select
        this.clickButton("DF_SHOE_TYPE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("DF_SHOE_TYPE_UK", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("DF_SHOE_TYPE_UK", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("DF_SINGLE_SELECT_CROSS_ICON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("DF_SINGLE_SELECT_CROSS_ICON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //Dynamic field single select search
        this.clickButton("DF_SHOE_TYPE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD_DF_2", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH," ");
        this.clickButton("SEARCH_SPACE_CROSS_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD_DF_2", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"gggg");
        this.clickButton("SEARCH_GGGG_CROSS_BUTTON_3", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //Dynamic field single select search uk and select
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD_DF_2", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"uk");
        waitForVisibilityOfElement("DF_SHOE_TYPE_UK", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("DF_SHOE_TYPE_UK", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("DF_SHOE_TYPE_UK_SELECTED",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));


        //Dynamic field multiple select & delete
        this.clickButton("DF_SELECT_MATERIAL", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("DF_SELECT_MATERIAL_CANVAS", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("DF_SELECT_MATERIAL_COTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("DF_SELECT_MATERIAL_LACE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("DF_MULTIPLE_SELECT_APPLY_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("DF_MATERIAL_SELECTED",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("DF_MATERIAL_SELECT_CROSS_ICON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //Dynamic field multiple select search space and delete
        this.clickButton("DF_SELECT_MATERIAL", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD_DF", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH," ");
        this.clickButton("SEARCH_SPACE_CROSS_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD_DF", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"gggg");
        this.clickButton("SEARCH_GGGG_CROSS_BUTTON_3", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //Dynamic field multiple select search Canvas and select
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD_DF", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"Canvas");
        waitForVisibilityOfElement("DF_SELECT_MATERIAL_CANVAS", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("DF_SELECT_MATERIAL_CANVAS", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("DF_MULTIPLE_SELECT_APPLY_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);

        //Dynamic field color select
        this.clickButton("DF_SELECT_COLOR", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("DF_SELECT_COLOR_BLACK", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("DF_SELECT_COLOR_BLUE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("DF_SELECT_MATERIAL_RED", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("DF_MULTIPLE_SELECT_APPLY_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("DF_COLOR_SELECTED",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.clickButton("DF_COLOR_SELECT_CROSS_ICON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //Dynamic field color select search
        this.clickButton("DF_SELECT_COLOR", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD_DF", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH," ");
        this.clickButton("SEARCH_SPACE_CROSS_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD_DF", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"gggg");
        this.clickButton("SEARCH_GGGG_CROSS_BUTTON_3", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //Dynamic field color select search Canvas and select
        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD_DF", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"red");
        this.sleep(2000);
        this.clickButton("DF_SELECT_MATERIAL_RED", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("DF_MULTIPLE_SELECT_APPLY_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);

        this.clickButton("NEXT_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("PRICE_FIELD_TITLE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,30);
        Assert.assertTrue(displayStatus("PRICE_FIELD_CONTEXT_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));

        this.clickButton("POST_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("PRICE_ERROR_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        Assert.assertTrue(displayStatus("LOCATION_ERROR_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));

        //price with space
        this.writeTextField("PRICE_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH," ");
        this.clickButton("POST_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("PRICE_SPACE_ERROR_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));

        //price below threshold value
        this.writeTextField("PRICE_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"10000");
        waitForVisibilityOfElement("FIXED_TAG", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,10);
        Assert.assertTrue(displayStatus("FIXED_TAG",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));

        //price above threshold value
        this.writeTextField("PRICE_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"60000");
        waitForVisibilityOfElement("NEGOTIATION_EXPIRY_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,10);
        Assert.assertTrue(displayStatus("NEGOTIATION_EXPIRY_FIELD",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));

        //Negotiation expiry date Check mandatory error message
        this.writeTextField("NEGOTIATION_EXPIRY_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"");
        this.clickButton("POST_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("NEGOTIATION_EXPIRY_ERROR_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));

        //Negotiation expiry date with space error message
        this.writeTextField("NEGOTIATION_EXPIRY_FIELD_EMPTY", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH," ");
        this.clickButton("POST_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        Assert.assertTrue(displayStatus("NEGOTIATION_EXPIRY_SPACE_ERROR_TEXT",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
        this.writeTextField("NEGOTIATION_EXPIRY_FIELD_SPACE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"30");

        //location field
        this.clickButton("PICKUP_LOCATION_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
//        this.clickButton("LOCATION_ICON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
//        this.sleep(10000);
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH, location);
        waitForVisibilityOfElement("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,10);
        this.clickButton("PICKUP_LOCATION_OPTION", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("PICKUP_LOCATION_FIELD_1_SELECTED", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,10);
        this.clickButton("PICKUP_LOCATION_FIELD_1_SELECTED", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);

        //Edit location
//        this.clickButton("PICKUP_LOCATION_FIELD_1_SELECTED", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
//        this.sleep(2000);
        this.writeTextField("SEARCH_FIELD", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,"ambon");
        waitForVisibilityOfElement("PICKUP_LOCATION_OPTION_2", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,10);
        this.clickButton("PICKUP_LOCATION_OPTION_2", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        //Address
        this.sleep(2000);
        String randomWord3 = RandomWordUtils.generateUniqueRandomWord(20);
        this.writeTextField("ADDRESS", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,randomWord3);

        //Special instruction
        this.sleep(2000);
        String randomWord4 = RandomWordUtils.generateUniqueRandomWord(10);
        this.writeTextField("SPECIAL_INSTRUCTIONS", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,randomWord4);
        this.scrollHalfway();
        //slot random select
        List<String> randomOptions2 = Arrays.asList(
                "SLOT_1",
                "SLOT_2",
                "SLOT_3",
                "SLOT_4",
                "SLOT_5",
                "SLOT_6",
                "SLOT_7",
                "SLOT_8"
        );
        this.clickRandomOption(randomOptions2, LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("POST_BUTTON", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("VIEW_AD_PAGE", LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH,30);
        Assert.assertTrue(displayStatus("VIEW_AD_PAGE",LocatorClassName.PRODUCT_UPLOAD_LOCATOR_CLASS.toString(), LocatorType.XPATH));
    }

    public void productUploadWithGallery(String productName, String price, String location) throws IOException, InterruptedException {
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

