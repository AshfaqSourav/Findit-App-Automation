package locators.iosLocators;

public class ProductUploadLocatorsIOS {
    public static final String SELL_IT_BUTTON = "//XCUIElementTypeApplication[@name=\"Findit\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[7]";
    public static final String CAPTURE_BUTTON = "//XCUIElementTypeImage[@name=\"Rekam\"]";
    public static final String UPLOAD_BUTTON = "//XCUIElementTypeImage[@name=\"Unggah\"]";
    public static final String SELECT_FOLDER = "new UiSelector().className(\"android.widget.RelativeLayout\").index(1)";
    public static final String SELECT_IMAGE = "new UiSelector().className(\"android.widget.ImageView\").index(1)";
    public static final String WHILE_USING_THE_APP_BUTTON = "new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\")";
    public static final String ONLY_THIS_TIME_BUTTON = "com.android.permissioncontroller:id/permission_allow_one_time_button";
    public static final String DONT_ALLOW_BUTTON = "com.android.permissioncontroller:id/permission_deny_button";
    public static final String CAPTURE_TAP_BUTTON = "//XCUIElementTypeImage";
    public static final String CAPTURE_CROSS_BUTTON = "new UiSelector().className(\"android.widget.ImageView\").instance(1)";
    public static final String CAPTURE_OK_BUTTON = "//XCUIElementTypeApplication[@name=\"Findit\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[3]";
    public static final String PRODUCT_NAME_FIELD = "//XCUIElementTypeApplication[@name=\"Findit\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]";
    public static final String CATEGORY_FIELD_EMPTY = "//XCUIElementTypeOther[@name=\"Pilih kategori\"]";
    public static final String CATEGORY_FIELD = "//XCUIElementTypeApplication[@name=\"Findit\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton";
    public static final String CATEGORY_FIRST_OPTION = "//XCUIElementTypeStaticText[@name=\"Elektronik\"]";
    public static final String SUB_CATEGORY_FIELD_EMPTY = "//XCUIElementTypeOther[@name=\"Pilih sub-kategori\"]";
    public static final String SUB_CATEGORY_FIELD = "//XCUIElementTypeApplication[@name=\"Findit\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeButton";
    public static final String SUB_CATEGORY_FIRST_OPTION = "//XCUIElementTypeStaticText[@name=\"Gaming Consoles\"]";
    public static final String CONDITION_FIELD = "//XCUIElementTypeOther[@name=\"Pilih kondisi\"]";
    public static final String CONDITION_FIRST_OPTION = "//XCUIElementTypeStaticText[@name=\"Barang Baru!\"]";
    public static final String NEXT_BUTTON = "//XCUIElementTypeButton[@name=\"Lanjutkan\"]";
    public static final String PRICE_FIELD = "//XCUIElementTypeButton[@name=\"Rp |\"]";
    public static final String PICKUP_LOCATION_FIELD = "//XCUIElementTypeTextField[@name=\"Lokasi\"]";
    public static final String PICKUP_LOCATION_OPTION = "//XCUIElementTypeStaticText[@name=\"Jakarta, Indonesia\"]";
    public static final String POST_BUTTON = "//XCUIElementTypeButton[@name=\"Pasang Iklan Gratis\"]";
    public static final String VIEW_AD_PAGE = "//XCUIElementTypeButton[@name=\"Lihat halaman iklan\"]";
    //XCUIElementTypeButton[@name="Jual Produk Lain"]
    public static final String SHARE_BUTTON = "new UiSelector().className(\"android.widget.ImageView\").instance(2)";
    public static final String LINK_COPY = "android:id/content_preview_text";
}
