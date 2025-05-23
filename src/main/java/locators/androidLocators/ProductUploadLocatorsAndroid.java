package locators.androidLocators;

import org.openqa.selenium.Point;

public class ProductUploadLocatorsAndroid {
    public static final String SELL_IT_BUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]";
    public static final String CAPTURE_BUTTON = "//android.widget.ImageView[@content-desc=\"Rekam\" or @content-desc=\"Capture\"]";
    public static final String UPLOAD_BUTTON = "//android.widget.ImageView[@content-desc=\"Unggah\" or @content-desc=\"Upload\"]";
    public static final String SELECT_IMAGE = "//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"]";
    public static final String SELECT_IMAGE2 = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]/android.view.View[2]/android.view.View";
    public static final String SELECT_FOLDER = "//android.widget.RelativeLayout";
    public static final String SELECT_IMAGE_BELOW_ANDROID_10 = "(//android.widget.ImageView)[1]";
    public static final String WHILE_USING_THE_APP_BUTTON = "new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\")";
    public static final String ONLY_THIS_TIME_BUTTON = "com.android.permissioncontroller:id/permission_allow_one_time_button";
    public static final String DONT_ALLOW_BUTTON = "com.android.permissioncontroller:id/permission_deny_button";
    public static final String CAPTURE_TAP_BUTTON = "//android.widget.ImageView";
    public static final String CAPTURE_CROSS_BUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]";
    public static final String CAPTURE_OK_BUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]";
    public static final String BACK_BUTTON = "//android.widget.ImageView";
    public static final String TOP_BAR_TITLE = "//android.view.View[@content-desc=\"Tambahkan Produk\" or @content-desc=\"Add Product\"]";
    public static final String PRODUCT_NAME_TEXT = "//android.view.View[@content-desc=\"Nama produk *\" or @content-desc=\"Product Name *\"]";
    public static final String UPLOAD_ADD_IMAGE = "//android.widget.ScrollView/android.widget.Button[1]";
    public static final String UPLOAD_ADD_IMAGE_BOTTOM_SHEET = "//android.view.View[@content-desc=\"Unggah gambar dan biarkan AI melakukan keajaiban\n" + "Unggah foto dengan tampilan yang jelas untuk memastikan hasil yang lebih baik.\"]";
    public static final String UPLOAD_ADD_IMAGE_CAPTURE = "//android.widget.ImageView[@content-desc=\"Ambil foto\"or @content-desc=\"Take Picture\"]";
    public static final String UPLOAD_ADD_IMAGE_UPLOAD_FROM_GALLERY = "//android.widget.ImageView[@content-desc=\"Unggah dari galeri\" or @content-desc=\"Upload from gallery\"]";
    public static final String IMAGES_EXPAND = "//android.widget.Button[@bounds='[324,296][450,422]']";
    public static final String IMAGES_ONE = "//android.widget.ScrollView/android.view.View[2]/android.view.View/android.view.View/android.widget.ImageView[1]";
    public static final String IMAGES_TWO = "//android.widget.ScrollView/android.view.View[2]/android.view.View/android.view.View/android.widget.ImageView[2]";
    public static final String IMAGES_ADD = "//android.widget.ScrollView/android.view.View[2]/android.view.View/android.view.View/android.widget.ImageView[3]";
    public static final String IMAGES_DELETE_ICON = "//android.widget.ScrollView/android.view.View[2]/android.view.View/android.view.View/android.widget.ImageView[2]/android.widget.Button";
    public static final String LOADING_AI_STATE = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View";
    public static final String REGENERATE_BUTTON = "//android.widget.ImageView[@content-desc=\"Tampilkan ulang\" or @content-desc=\"Re generate\"]";
    public static final String REGENERATE_BUTTON_LOADING = "//android.widget.ScrollView/android.view.View[3]/android.widget.EditText[1]/android.widget.Button";
    public static final String PRODUCT_NAME_FIELD = "//android.widget.ScrollView/android.view.View[3]/android.widget.EditText[1]";
    public static final String CATEGORY_FIELD_EMPTY = "//android.view.View[@content-desc=\"Pilih kategori\" or @content-desc=\"Select category\"]";
    public static final String CATEGORY_FIELD_WOMENS_SHOE_SELECTED = "//android.widget.ImageView[@content-desc=\"Sepatu Wanita\" or @content-desc=\"Women's Shoes\"]";
    public static final String SEARCH_EMPTY_STATE_PICTURE = "//android.widget.ImageView";
    public static final String SEARCH_EMPTY_STATE_TEXT = "//android.view.View[@content-desc=\"Tidak ada hasil yang ditemukan!\" or @content-desc=\"No result found!\"]";
    public static final String CATEGORY_FIRST_OPTION = "//android.view.View[@content-desc=\"Sepatu Wanita\" or @content-desc=\"Women's Shoes\"]";
    public static final String SUB_CATEGORY_FIELD_EMPTY = "//android.view.View[@content-desc=\"Pilih sub-kategori\" or @content-desc=\"Select sub-category\"]";
    public static final String SUB_CATEGORY_FIELD_OTHER_WOMENS_SHOE_SELECTED = "//android.widget.ImageView[@content-desc=\"Other Women Shoes\" or @content-desc=\"Other Women Shoes\"]";
    public static final Point SEARCH_FIELD = new Point(129, 622);
    public static final String SEARCH_CROSS_BUTTON = "/android.view.View[1]";
    public static final String SEARCH_CROSS_BUTTON_DF = "/android.view.View[2]";
    public static final String SEARCH_SPACE_CROSS_BUTTON = "//android.widget.EditText[@text=\" \"]/android.view.View[2]";
    public static final String SEARCH_GGGG_CROSS_BUTTON = "//android.widget.EditText[@text=\"gggg\"]/android.view.View[2]";
    public static final String SEARCH_GGGG_CROSS_BUTTON_2 = "//android.widget.EditText[@text=\"gggg\"]/android.view.View[1]";
    public static final String SEARCH_GGGG_CROSS_BUTTON_3 = "//android.widget.ImageView[@text=\"gggg\"]/android.view.View[2]";

    public static final String SUB_CATEGORY_FIRST_OPTION = "//android.view.View[@content-desc=\"Other Women Shoes\" or @content-desc=\"Other Women Shoes\"]";
    public static final String CONDITION_FIELD = "//android.view.View[@content-desc=\"Pilih kondisi\" or @content-desc=\"Select condition\"]";
    public static final String CONDITION_FIRST_OPTION = "//android.view.View[@content-desc=\"Barang Baru!\n" + "Belum dipakai, masih ada box/label.\" or @content-desc=\"Brand new Unused, possibly with original packaging/tags.\"]";
    public static final String CONDITION_SECOND_OPTION = "//android.view.View[@content-desc=\"Seperti Baru!\n" +
            "Hampir tidak dipakai, terlihat seperti baru.\"]";
    public static final String CONDITION_THIRD_OPTION = "//android.view.View[@content-desc=\"Sedikit Digunakan\n" +
            "Sering dipakai ada sedikit kerusakan, terawat\"]";
    public static final String CONDITION_FOURTH_OPTION = "//android.view.View[@content-desc=\"Terawat\n" +
            "Jarang dipakai, ada sedikit kerusakan\"]";
    public static final String CONDITION_FIFTH_OPTION = "//android.view.View[@content-desc=\"Sering Digunakan\n" +
            "Bekas pakai, ada cacat / kerusakan yang terlihat jelas\"]";
    public static final String BRAND_FIELD_EMPTY = "//android.view.View[@content-desc=\"Pilih Merek\" or @content-desc=\"Select Brand\"]";
    public static final String MODEL_FIELD_EMPTY = "//android.view.View[@content-desc=\"Pilih Model\" or @content-desc=\"Select Model\"]";
    public static final String BRAND_FIRST_OPTION = "//android.view.View[@content-desc=\"Florence\"]";
    public static final String BRAND_FLORENCE_SELECTED= "//android.view.View[@content-desc=\"Florence\"]";
    public static final String MODEL_FIRST_OPTION = "//android.view.View[@content-desc=\"VOUGE\"]";
    public static final String MODEL_VOUGE_SELECTED= "//android.view.View[@content-desc=\"VOUGE\"]";
    public static final String NEXT_BUTTON = "//android.widget.Button[@content-desc=\"Lanjutkan\" or @content-desc=\"Next\"]";
    public static final String PRICE_FIELD = "//android.widget.ScrollView/android.view.View[4]/android.widget.EditText[1]";
    public static final String PRICE_FIELD_MARKET_PLACE_FEE = "//android.view.View[@content-desc=\"Biaya marketplace diterapkan\" or @content-desc=\"Marketplace fee Applied\"]";
    public static final String FIXED_TAG = "//android.widget.EditText[@hint='Tetap' or @hint='Fixed']\n";
    //android.widget.EditText[@text='1' and @bounds='[45,777][1041,903]']
    public static final String NEGOTIATION_EXPIRY_FIELD_SPACE = "//android.widget.EditText[@text=\" \"]";
    public static final String NEGOTIATION_EXPIRY_FIELD = "//android.widget.EditText[@text=\"30\"]";
    public static final String NEGOTIATION_EXPIRY_FIELD_EMPTY = "//android.widget.ScrollView/android.view.View[4]/android.widget.EditText[2]";
    public static final String PRICE_FIELD_CONTEXT_TEXT = "//android.view.View[@content-desc=\"Produk di bawah Rp 50.000 hanya untuk pembelian langsung.\" or @content-desc=\"Products under Rp 50.000 are for direct purchase only.\"]";
    public static final String PICKUP_LOCATION_FIELD = "//android.view.View[@content-desc=\"Lokasi\" or @content-desc=\"Location\"]";
    public static final String PICKUP_LOCATION_FIELD_1_SELECTED = "//android.view.View[@content-desc=\"Jakarta, Indonesia\"]";
    public static final String LOCATION_ICON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.widget.ImageView/android.widget.ImageView";
    public static final String PICKUP_LOCATION_OPTION = "//android.view.View[@content-desc=\"Jakarta, Indonesia\"]";
    public static final String PICKUP_LOCATION_OPTION_2 = "//android.view.View[@content-desc=\"Ambon City Center (ACC), Jalan Wolter Monginsidi, Passo, Kota Ambon, Maluku, Indonesia\"]";
    public static final String POST_BUTTON = "//android.widget.Button[@content-desc=\"Pasang Iklan Gratis\" or @content-desc=\"Post Free Ad\"]";
    public static final String VIEW_AD_PAGE = "//android.widget.Button[@content-desc=\"Lihat halaman iklan\" or @content-desc=\"View ad page\"]";
    public static final String SELL_ANOTHER_PRODUCT_BUTTON = "//android.widget.ImageView[@content-desc=\"Sell Another Product\"]";
    public static final String BOOST_BUTTON = "//android.view.View[@content-desc=\"Boost\"]";
    public static final String SHARE_BUTTON = "new UiSelector().className(\"android.widget.ImageView\").instance(2)";
    public static final String LINK_COPY = "android:id/content_preview_text";
    public static final String SEARCH = "(//android.widget.ImageView)[4]";
    public static final String VISIT_BUTTON = "//android.view.View[@content-desc=\"Kunjungi\" or @content-desc=\"Visit\"]";
    public static final String SELL_IT_GUIDE_TEXT = "//android.view.View[@content-desc=\"KitaPanduan MenjualLihat saran untuk menjual produk bekas Anda di Findit. Kamu juga bisa menonton video yang dibuat oleh tim kami untuk Kamu.\" or @content-desc=\"Our Sell It Guide has all the suggestions to sell your pre loved products on Findit. You can also watch a video created by our team for you.\"]";
    public static final String VISIT_TOPBAR_TEXT = "//android.view.View[@content-desc=\"Kunjungi\"]";
    public static final String GUIDELINE_TEXT_PAGEVIEW = "//android.widget.TextView[@text=\"Cara Jualan di Findit\"]";
    public static final String SELL_IT_GUIDE_TOPBAR_TEXT = "//android.view.View[@content-desc=\" Sell It Guide\" or @content-desc=\"Panduan Menjual\"]";
    public static final String PLAY_BUTTON = "//android.widget.Button[@text=\"play\"]";
    public static final String PROHIBITED_BOTTOM_SHEET = "//android.widget.ImageView[@content-desc=\"Terbatas untuk Listing\" or @content-desc=\"Listing Restricted\"]";
    public static final String PROHIBITED_BOTTOM_SHEET_TEXT_LINK ="//android.widget.ImageView[@content-desc=\"Terbatas untuk Listing\"]";
    public static final String UPLOAD_NEW_PRODUCT_BUTTON = "//android.widget.Button[@content-desc=\"Unggah produk baru\" or @content-desc=\"Upload a new product\"]";
    public static final String SELL_IT_PAGE = "//android.widget.ScrollView";
    public static final String WARNING_BOTTOM_SHEET = "//android.widget.ImageView[@content-desc=\"Tinjauan Diperlukan\" or @content-desc=\"Review Required\"]";
    public static final String WARNING_BOTTOM_SHEET_TEXT_LINK ="//android.widget.Button[@content-desc=\"Lihat Ketentuan Pendaftaran Produk\" or @content-desc=\"View Product Listing Conditions\"]";
    public static final String ACCEPT_BUTTON = "//android.widget.Button[@content-desc=\"Terima\" or @content-desc=\"Accept\"]";
    public static final String PRODUCT_NAME_ERROR_TEXT = "(//android.view.View[@content-desc=\"Harus diisi\" or @content-desc=\"Required field\"])[1]";
    public static final String CATEGORY_ERROR_TEXT = "(//android.view.View[@content-desc=\"Harus diisi\" or @content-desc=\"Required field\"])[2]";
    public static final String SUB_CATEGORY_ERROR_TEXT = "(//android.view.View[@content-desc=\"Harus diisi\" or @content-desc=\"Required field\"])[2]";
    public static final String PRODUCT_CONDITION_ERROR_TEXT = "(//android.view.View[@content-desc=\"Harus diisi\" or @content-desc=\"Required field\"])[2]";
    public static final String PRICE_ERROR_TEXT = "//android.view.View[@content-desc=\"Harus diisi\" or @content-desc=\"Required field\"]";
    public static final String NEGOTIATION_EXPIRY_ERROR_TEXT = "//android.view.View[@content-desc=\"Harus diisi\" or @content-desc=\"Required field\"]";
    public static final String LOCATION_ERROR_TEXT = "//android.view.View[@content-desc=\"Silakan pilih lokasi penjemputan yang tepat dari dropdown\" or @content-desc=\"Please select a precise pickup location from dropdown\"]";
    public static final String SUB_CATEGORY_EMPTY_STATE_TEXT = "//android.view.View[@content-desc=\"Select category to see sub category list\" or @content-desc=\"Pilih kategori untuk melihat daftar subkategori\"]";
    public static final String ADD_BRAND_BUTTON = "//android.view.View[@content-desc=\"Add Brand\" or @content-desc=\"Tambahkan Merek\"]";
    public static final String ADD_MODEL_BUTTON = "//android.view.View[@content-desc=\"Add Model\" or @content-desc=\"Tambahkan Model\"]";
    public static final String DF_SHOE_TYPE = "//android.view.View[@content-desc=\"Select Type\"]";
    public static final String DF_SHOE_TYPE_UK = "//android.view.View[@content-desc=\"UK\"]";
    public static final String DF_SHOE_TYPE_UK_SELECTED = "//android.view.View[@content-desc=\"UK\"]";
    public static final String DF_SINGLE_SELECT_CROSS_ICON = "//android.view.View[@content-desc=\"UK\"]/android.view.View";
    public static final String DF_INPUT_SIZE = "//android.widget.EditText";
    public static final String DF_SELECT_MATERIAL = "//android.view.View[@content-desc=\"Material\n" + "Select Material\"]";
    public static final String DF_SELECT_MATERIAL_CANVAS = "//android.widget.CheckBox[@content-desc=\"Canvas\"]";
    public static final String DF_SELECT_MATERIAL_COTTON = "//android.widget.CheckBox[@content-desc=\"Cotton\"]";
    public static final String DF_SELECT_MATERIAL_LACE = "//android.widget.CheckBox[@content-desc=\"Lace\"]";
    public static final String DF_MATERIAL_SELECTED = "//android.view.View[@content-desc=\"Material\n" +
            "Canvas, \n" +
            "Cotton\n" +
            "+1Lagi\"]";
    public static final String DF_MATERIAL_SELECT_CROSS_ICON = "//android.view.View[@content-desc=\"Material\n" +
            "Canvas, \n" +
            "Cotton\n" +
            "+1Lagi\"]/android.view.View";
    public static final String DF_MULTIPLE_SELECT_APPLY_BUTTON = "//android.widget.Button[@content-desc=\"Apply\" or @content-desc=\"Terapkan\"]";
    public static final String DF_SELECT_COLOR = "//android.view.View[@content-desc=\"Warna\n" + "Select Color\"]";
    public static final String DF_SELECT_COLOR_BLACK = "//android.widget.CheckBox[@content-desc=\"Black\"]";
    public static final String DF_SELECT_COLOR_BLUE = "//android.widget.CheckBox[@content-desc=\"Blue\"]";
    public static final String DF_SELECT_MATERIAL_RED = "//android.widget.CheckBox[@content-desc=\"Red\"]";
    public static final String DF_COLOR_SELECTED = "//android.view.View[@content-desc=\"Warna\n" +
            "Black, \n" +
            "Blue\n" +
            "+1Lagi\"]";
    public static final String DF_COLOR_SELECT_CROSS_ICON = "//android.view.View[@content-desc=\"Warna\n" +
            "Black, \n" +
            "Blue\n" +
            "+1Lagi\"]/android.view.View";
    public static final Point SEARCH_FIELD_DF = new Point(124, 525);
    public static final Point SEARCH_FIELD_DF_2 = new Point(106, 940);
    public static final Point OUTSIDE_BOTTOM_SHEET_TAP = new Point(483, 187);
    public static final String PRICE_SPACE_ERROR_TEXT = "//android.view.View[@content-desc=\"Enter number\" or @content-desc=\"Masukkan angka\"]";
    public static final String NEGOTIATION_EXPIRY_SPACE_ERROR_TEXT = "//android.view.View[@content-desc=\"Enter number\" or @content-desc=\"Masukkan angka\"]";
    public static final String PRICE_FIELD_TITLE = "//android.view.View[@content-desc=\"Asking price *\" or @content-desc=\"Harga yang diminta *\"]";
    public static final String LOCATION_FIELD_TITLE = "//android.view.View[@content-desc=\"Pickup Location *\" or @content-desc=\"Lokasi Pengambilan *\"]";
    public static final String DRAFT_BOTTOM_SHEET = "//android.widget.ImageView[@content-desc=\"Kamu yakin mau pergi? Anda bisa menyimpannya sebagai draf untuk sekarang dan mengeditnya nanti.\" or @content-desc=\"Are you sure you want to leave? You can save it as draft for now and edit later.\"]";
    public static final String DRAFT_SAVE_BUTTON = "//android.widget.Button[@content-desc=\"Save Draft\" or @content-desc=\"Simpan Draft\"]";
    public static final String DRAFT_CANCEL_BUTTON = "//android.widget.Button[@content-desc=\"Keep me here\" or @content-desc=\"Biarkan di sini\"]";
    public static final String SLOT_1 = "//android.view.View[@content-desc=\"12 AM - 3 AM\"]";
    public static final String SLOT_2 = "//android.view.View[@content-desc=\"3 AM - 6 AM\"]";
    public static final String SLOT_3 = "//android.view.View[@content-desc=\"6 AM - 9 AM\"]";
    public static final String SLOT_4 = "//android.view.View[@content-desc=\"9 AM - 12 PM\"]";
    public static final String SLOT_5 = "//android.view.View[@content-desc=\"12 PM - 3 PM\"]";
    public static final String SLOT_6 = "//android.view.View[@content-desc=\"3 PM - 6 PM\"]";
    public static final String SLOT_7 = "//android.view.View[@content-desc=\"6 PM - 9 PM\"]";
    public static final String SLOT_8= "//android.view.View[@content-desc=\"9 PM - 12 AM\"]";
    public static final String SPECIAL_INSTRUCTIONS= "//android.widget.ScrollView/android.view.View/android.widget.EditText[4]";
    public static final String ADDRESS= "//android.widget.ScrollView/android.view.View/android.widget.EditText[3]";
}
