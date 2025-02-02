package locators.iosLocators;

public class LoginPageLocatorsIOS {
    //XCUIElementTypeTextField
    //XCUIElementTypeImage[@name='Continue with Email' or @name='Lanjutkan dengan Email']
    public static final String LOGIN_WITH_EMAIL_BUTTON = "//XCUIElementTypeImage[@name='Continue with Email' or @name='Lanjutkan dengan Email']";
    public static final String LOGIN_EMAIL_TEXT = "//XCUIElementTypeTextField[@name=\"user@example.com\"]";
    public static final String LOGIN_EMAIL_NEXT_BUTTON = "//XCUIElementTypeButton[@name=\"Lanjutkan\"]";
    public static final String LOGIN_EMAIL_OTP_1 = "//XCUIElementTypeApplication[@name=\"Findit\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeTextField[1]";
    public static final String LOGIN_EMAIL_OTP_2 = "(//XCUIElementTypeOther[@name=\"-\"])[2]";
    public static final String LOGIN_EMAIL_OTP_3 = "(//XCUIElementTypeOther[@name=\"-\"])[3]";
    public static final String LOGIN_EMAIL_OTP_4 = "(//XCUIElementTypeOther[@name=\"-\"])[1]";
    public static final String LOGIN_EMAIL_OTP_5 = "(//XCUIElementTypeOther[@name=\"-\"])[1]";
    public static final String LOGIN_EMAIL_OTP_6 = "//XCUIElementTypeImage";
    public static final String LOGIN_EMAIL_VERIFY_BUTTON = "//XCUIElementTypeButton[@name=\"Verifikasi\"]";
    public static final String TURN_ON_NOTIFICATION_BUTTON= "//XCUIElementTypeButton[@name=\"Nyalakan notifikasi\"]";
    public static final String ALLOW_NOTIFICATION = "label == 'Allow'";
    public static final String DONT_ALLOW_NOTIFICATION = "com.android.permissioncontroller:id/permission_deny_button";
    public static final String MAYBE_LATER = "//XCUIElementTypeButton[@name=\"Mungkin Nanti\"])";
}

