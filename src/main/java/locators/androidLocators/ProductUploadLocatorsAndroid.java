package locators.androidLocators;

public class ProductUploadLocatorsAndroid {
    public static final String SELL_IT_BUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]";
    public static final String CAPTURE_BUTTON = "//android.widget.ImageView[@content-desc=\"Rekam\" or @content-desc=\"Capture\"]";
    public static final String UPLOAD_BUTTON = "//android.widget.ImageView[@content-desc=\"Unggah\" or @content-desc=\"Upload\"]";
    public static final String SELECT_FOLDER = "//android.widget.RelativeLayout";
    public static final String SELECT_IMAGE = "(//android.widget.ImageView)[1]";
    public static final String WHILE_USING_THE_APP_BUTTON = "new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\")";
    public static final String ONLY_THIS_TIME_BUTTON = "com.android.permissioncontroller:id/permission_allow_one_time_button";
    public static final String DONT_ALLOW_BUTTON = "com.android.permissioncontroller:id/permission_deny_button";
    public static final String CAPTURE_TAP_BUTTON = "//android.widget.ImageView";
    public static final String CAPTURE_CROSS_BUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]";
    public static final String CAPTURE_OK_BUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]";
    public static final String PRODUCT_NAME_FIELD = "//android.widget.ScrollView/android.view.View[3]/android.widget.EditText[1]";
    public static final String CATEGORY_FIELD_EMPTY = "//android.view.View[@content-desc=\"Pilih kategori\" or @content-desc=\"Select category\"]";
    public static final String CATEGORY_FIELD = "(//android.widget.Button)[5]";
    public static final String CATEGORY_FIRST_OPTION = "//android.view.View[contains(@content-desc, 'Ele')]";
    public static final String SUB_CATEGORY_FIELD_EMPTY = "//android.view.View[@content-desc=\"Pilih sub-kategori\" or @content-desc=\"Select sub category\"]";
    public static final String SUB_CATEGORY_FIELD = "(//android.widget.Button)[3]";
    public static final String SUB_CATEGORY_FIRST_OPTION = "//android.view.View[contains(@content-desc, 'Gam')]";
    public static final String CONDITION_FIELD = "//android.view.View[@content-desc=\"Pilih kondisi\" or @content-desc=\"Select condition\"]";
    public static final String CONDITION_FIRST_OPTION = "//android.view.View[contains(@content-desc, 'B')]";
    public static final String NEXT_BUTTON = "//android.widget.Button[@content-desc=\"Lanjutkan\" or @content-desc=\"Next\"]";
    public static final String PRICE_FIELD = "//android.widget.ScrollView/android.view.View[4]/android.widget.EditText[1]";
    public static final String PICKUP_LOCATION_FIELD = "//android.widget.ScrollView/android.view.View[4]/android.widget.EditText[3]";
    public static final String PICKUP_LOCATION_OPTION = "//android.view.View[@content-desc=\"Jakarta, Indonesia\"]";
    public static final String POST_BUTTON = "//android.widget.Button[contains(@content-desc, 'P')]";
    public static final String VIEW_AD_PAGE = "//android.widget.Button[@content-desc=\"Lihat halaman iklan\"]";
    public static final String SHARE_BUTTON = "new UiSelector().className(\"android.widget.ImageView\").instance(2)";
    public static final String LINK_COPY = "android:id/content_preview_text";
    public static final String SEARCH = "(//android.widget.ImageView)[4]";
}
