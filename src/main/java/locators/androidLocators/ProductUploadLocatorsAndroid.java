package locators.androidLocators;

public class ProductUploadLocatorsAndroid {
    public static final String SELL_IT_BUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]";
    public static final String CAPTURE_BUTTON = "new UiSelector().className(\"android.widget.ImageView\").index(4)";
    public static final String UPLOAD_BUTTON = "new UiSelector().className(\"android.widget.ImageView\").index(5)";
    public static final String SELECT_FOLDER = "new UiSelector().className(\"android.widget.RelativeLayout\").index(1)";
    public static final String SELECT_IMAGE = "new UiSelector().className(\"android.widget.ImageView\").index(1)";
    public static final String WHILE_USING_THE_APP_BUTTON = "new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\")";
    public static final String ONLY_THIS_TIME_BUTTON = "com.android.permissioncontroller:id/permission_allow_one_time_button";
    public static final String DONT_ALLOW_BUTTON = "com.android.permissioncontroller:id/permission_deny_button";
    public static final String CAPTURE_TAP_BUTTON = "new UiSelector().className(\"android.widget.ImageView\").index(2)";
    public static final String CAPTURE_CROSS_BUTTON = "new UiSelector().className(\"android.widget.ImageView\").instance(1)";
    public static final String CAPTURE_OK_BUTTON = "new UiSelector().className(\"android.widget.ImageView\").instance(2)";
    public static final String PRODUCT_NAME_FIELD = "new UiSelector().className(\"android.widget.EditText\").index(2)";
    public static final String CATEGORY_FIELD_EMPTY = "new UiSelector().description(\"Pilih kategori\")";
    public static final String CATEGORY_FIELD = "new UiSelector().className(\"android.view.View\").index(6)";
    public static final String CATEGORY_FIRST_OPTION = "//android.view.View[contains(@content-desc, 'Ele')]";
    public static final String SUB_CATEGORY_FIELD_EMPTY = "//android.view.View[@content-desc=\"Pilih sub-kategori\"]";
    public static final String SUB_CATEGORY_FIELD = "new UiSelector().className(\"android.view.View\").index(8)";
    public static final String SUB_CATEGORY_FIRST_OPTION = "//android.view.View[contains(@content-desc, 'Gami')]";
    public static final String CONDITION_FIELD = "new UiSelector().className(\"android.view.View\").index(10)";
    public static final String CONDITION_FIRST_OPTION = "//android.view.View[contains(@content-desc, 'B')]";
    public static final String NEXT_BUTTON = "//android.widget.Button[@content-desc=\"Lanjutkan\" or @content-desc=\"Next\"]";
    public static final String PRICE_FIELD = "new UiSelector().className(\"android.widget.EditText\").instance(0)";
    public static final String PICKUP_LOCATION_FIELD = "new UiSelector().className(\"android.widget.EditText\").instance(2)";
    public static final String PICKUP_LOCATION_OPTION = "new UiSelector().description(\"Jakarta, Indonesia\")";
    public static final String POST_BUTTON = "//android.widget.Button[contains(@content-desc, 'P')]";
    public static final String VIEW_AD_PAGE = "new UiSelector().className(\"android.widget.Button\").index(6)";
    public static final String SHARE_BUTTON = "new UiSelector().className(\"android.widget.ImageView\").instance(2)";
    public static final String LINK_COPY = "android:id/content_preview_text";

}
