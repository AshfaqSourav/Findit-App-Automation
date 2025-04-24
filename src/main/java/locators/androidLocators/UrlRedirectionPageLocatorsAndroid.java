package locators.androidLocators;

public class UrlRedirectionPageLocatorsAndroid {
    public static final String LOGINPOPUP_TERMSANDCONDITION_LINK = "//android.view.View[@content-desc=\" Syarat dan ketentuan,\" or @content-desc=\" Terms & Condition,\"]";
    public static final String LOGINPOPUP_PRIVACYPOLICY_LINK = "//android.view.View[@content-desc=\" Kebijakan Privasi dan\" or @content-desc=\" Privacy Policy and\"]";
    public static final String LOGINPOPUP_EULA_LINK = "//android.view.View[@content-desc=\" EULA\"]";
    public static final String BACK_BUTTON ="//android.widget.ImageView";
    public static final String EULA_TEXT_TOPBAR ="//android.view.View[@content-desc=\"Perjanjian Pengguna Akhir\" or @content-desc=\"End User Agreement\"]";
    public static final String TERMSANDCONDITION_TEXT_TOPBAR ="//android.view.View[@content-desc=\"Syarat dan ketentuan\" or @content-desc=\"Terms & Condition\"]";
    public static final String PRIVACYPOLICY_TEXT_TOPBAR ="//android.view.View[@content-desc=\"Kebijakan Privasi\" or @content-desc=\"Privacy Policy\"]";
    public static final String REFUNDPOLICY_TEXT_TOPBAR ="//android.view.View[@content-desc=\"Kebijakan pengembalian\" or @content-desc=\"Refund Policy\"]";
    public static final String ABOUTFINDIT_TEXT_TOPBAR ="//android.view.View[@content-desc=\"Tentang Findit\" or @content-desc=\"About Findit\"]";
    public static final String EULA_TEXT_PAGEVIEW ="(//android.widget.TextView[@text=\"End User License Agreement\" or @text=\"Perjanjian Lisensi Pengguna Akhir\"])[2]";
    public static final String TERMSANDCONDITION_TEXT_PAGEVIEW ="//android.widget.TextView[@text=\"Syarat dan Ketentuan Layanan Findit\"]";
    public static final String PRIVACYPOLICY_TEXT_PAGEVIEW ="//android.widget.TextView[@text=\"Privasi & Kebijakan\"]";
    public static final String REFUNDPOLICY_TEXT_PAGEVIEW ="(//android.widget.TextView[@text=\"Kebijakan Pengembalian Dana\"])[2]";
    public static final String ABOUTFINDIT_TEXT_PAGEVIEW ="//android.widget.TextView[@text=\"Apa itu Findit?\"]";
    public static final String SETTINGS_PRIVACYPOLICY_LINK = "//android.widget.ImageView[@content-desc=\"Kebijakan Privasi\" or @content-desc=\"Privacy Policy\"]";
    public static final String SETTINGS_REFUNDPOLICY_LINK = "//android.widget.ImageView[@content-desc=\"Kebijakan pengembalian\" or @content-desc=\"Refund policy\"]";
    public static final String SETTINGS_TERMSANDCONDITION_LINK = "//android.widget.ImageView[@content-desc=\"Syarat dan ketentuan\" or @content-desc=\"Terms and Conditions\"]";
    public static final String SETTINGS_ABOUTFINDIT_LINK = "//android.widget.ImageView[@content-desc=\"Tentang Findit\" or @content-desc=\"About Findit\"]";
    public static final String NO_INTERNET_TOAST ="//android.widget.ImageView[@content-desc=\"Tidak ada koneksi internet\" or @content-desc=\"No internet connection\"]";
    public static final String RETRY_BUTTON ="//android.widget.Button[@content-desc=\"Coba Lagi\"]";
    public static final String HELP_CENTER_BUTTON ="//android.widget.Button[@content-desc=\"Hubungi Pusat Bantuan\"]";
    public static final String SKIP_BUTTON = "//android.view.View[@content-desc=\"Lewati\" or @content-desc=\"Skip\"]";
    public static final String DECLINE_COOKIE_BUTTON = "//android.widget.Button[@text=\"Tolak\"]";
    public static final String BLOG_NAVBAR = "//android.webkit.WebView[@text=\"Cara Jualan di Findit - Findit Blog\"]/android.view.View/android.view.View[1]/android.view.View/android.widget.TextView";
    public static final String COOKIE_CONSENT_TEXT = "//android.widget.TextView[@text=\"Izinkan cookie untuk meningkatkan pengalaman browsing/penelusuran Anda.\"]";
    public static final String PROHIBITED_TOPBAR = "//android.view.View[@content-desc=\"Lihat Pedoman Penjualan Indonesia\" or @content-desc=\"View Indonesian Selling Guidelines\"]";
    public static final String PROHIBITED_WARNING_PAGEVIEW = "//android.widget.TextView[@text=\"Apa Saja Produk yang Dilarang dan Diatur Untuk Dijual di Platform FindIt\" or @text=\"Understanding Prohibited and Regulated Products for Selling on Findit Platform - Findit Blog\"]";
    public static final String WARNING_TOPBAR = "//android.view.View[@content-desc=\"Lihat Ketentuan Pendaftaran Produk\" or @content-desc=\"View Product Listing Conditions\"]";
    public static final String WHATSAPP_LINK = "//android.widget.ImageView[@content-desc=\"Chat degan CS\" or @content-desc=\"Contact with your customer agent\"]";
    public static final String WHATSAPP_LINK_PAGEVIEW = "//android.view.View[@text=\"Chat on WhatsApp with +62 811-9001-3750\"]";
    public static final String WHATSAPP_LINK_TOPBAR = "//android.widget.TextView[@resource-id=\"com.android.chrome:id/url_bar\"]";
    public static final String CHROME = "//android.widget.Button[@resource-id=\"com.android.chrome:id/signin_fre_dismiss_button\"]";
}
