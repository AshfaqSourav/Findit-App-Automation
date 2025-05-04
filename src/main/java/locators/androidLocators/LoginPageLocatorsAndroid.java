package locators.androidLocators;

public class LoginPageLocatorsAndroid {
    public static final String MORE_LOGIN_OPTIONS_TEXT = "//android.widget.Button[@content-desc=\"Opsi login lainnya\" or @content-desc=\"More login options\"]";
    public static final String LOGIN_WITH_EMAIL_BUTTON = "//android.widget.ImageView[@content-desc=\"Continue with Email\" or @content-desc=\"Lanjutkan dengan Email\"]";
    public static final String LOGIN_EMAIL_TEXT = "//android.widget.EditText";
    public static final String LOGIN_EMAIL_NEXT_BUTTON = "//android.widget.Button[@content-desc=\"Lanjutkan\" or @content-desc=\"Next\"]";
    public static final String LOGIN_EMAIL_OTP_1 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText[1]";
    public static final String LOGIN_EMAIL_OTP_2 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText[2]";
    public static final String LOGIN_EMAIL_OTP_3 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText[3]";
    public static final String LOGIN_EMAIL_OTP_4 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText[4]";
    public static final String LOGIN_EMAIL_OTP_5 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText[5]";
    public static final String LOGIN_EMAIL_OTP_6 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText[6]";
    public static final String LOGIN_EMAIL_VERIFY_BUTTON = "//android.widget.Button[@content-desc=\"Verifikasi\" or @content-desc=\"Verify\"]";
    public static final String SIGN_UP_NAME_TEXT = "//android.widget.EditText";
    public static final String SIGN_UP_NEXT_BUTTON = "//android.widget.Button[@content-desc=\"Lanjutkan\" or @content-desc=\"Next\"]";
    public static final String SIGN_UP_NAME_ERROR_MESSAGE = "(//android.view.View[@content-desc=\"Masukkan nama lengkap Anda\" or @content-desc=\"Enter your full name\"])[2]";
    public static final String TURN_ON_NOTIFICATION_BUTTON = "//android.widget.Button[@content-desc=\"Nyalakan notifikasi\" or @content-desc=\"Turn on notifications\"]";
    public static final String ALLOW_NOTIFICATION = "com.android.permissioncontroller:id/permission_allow_button";
    public static final String DONT_ALLOW_NOTIFICATION = "com.android.permissioncontroller:id/permission_deny_button";
    public static final String MAYBE_LATER = "//android.widget.Button[@content-desc=\"Mungkin Nanti\" or @content-desc=\"Maybe Later\"]";
    public static final String EMAIL_EMPTY_INVALID_MESSAGE = "(//android.view.View[@content-desc=\"Masukkan email Anda\" or @content-desc=\"Enter your email\"])[2]";
    public static final String EMAIL_INVALID_INPUT_MESSAGE = "//android.view.View[@content-desc=\"Masukkan email yang valid\" or @content-desc=\"Enter a valid email\"]";
    public static final String EMAIL_INVALID_INPUT_MESSAGE2 = "//android.view.View[@content-desc=\"email: Masukkan alamat email dengan format yang benar.\" or @content-desc=\"email: Enter a valid email address.\"]";
    public static final String OTP_INVALID_MESSAGE = "(//android.view.View[@content-desc=\"Masukkan 6 digit OTP\" or @content-desc=\"Enter 6 digit OTP\"])[2]";
    public static final String OTP_INVALID_MESSAGE2 = "//android.view.View[@content-desc=\"Kode OTP salah atau kedaluwarsa\" or @content-desc=\"OTP code is wrong or expired\"]";
    public static final String UPDATE_POPUP = "//android.view.View[@content-desc=\"Pembaruan Aplikasi\"]";
    public static final String UPDATE_POPUP_LATER_BUTTON = "//android.widget.Button[@content-desc=\"Lewati\"]";
}

