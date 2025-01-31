package locators.iosLocators;

public class LoginPageLocatorsIOS {
    public static final String FALLBACK_BUTTON = "new UiSelector().name(\"Fallback Button\")";
    public static final String LOGIN_WITH_EMAIL_BUTTON = "new UiSelector().description(\"Lanjutkan dengan Email\")";
    public static final String LOGIN_EMAIL_TEXT = "new UiSelector().className(\"android.widget.EditText\")";
    public static final String LOGIN_EMAIL_NEXT_BUTTON = "new UiSelector().description(\"Lanjutkan\")";
    public static final String LOGIN_EMAIL_OTP_1 = " //android.widget.ScrollView/android.widget.EditText[1]";
    public static final String LOGIN_EMAIL_OTP_2 = " //android.widget.ScrollView/android.widget.EditText[2]";
    public static final String LOGIN_EMAIL_OTP_3 = " //android.widget.ScrollView/android.widget.EditText[3]";
    public static final String LOGIN_EMAIL_OTP_4 = " //android.widget.ScrollView/android.widget.EditText[4]";
    public static final String LOGIN_EMAIL_OTP_5 = " //android.widget.ScrollView/android.widget.EditText[5]";
    public static final String LOGIN_EMAIL_OTP_6 = " //android.widget.ScrollView/android.widget.EditText[6]";
    public static final String LOGIN_EMAIL_VERIFY_BUTTON = "new UiSelector().description(\"Verifikasi\")";
    public static final String TURN_ON_NOTIFICATION = "new UiSelector().className(\"android.widget.Button\").index(3)";
    public static final String ALLOW_NOTIFICATION = "com.android.permissioncontroller:id/permission_allow_button";
    public static final String DONT_ALLOW_NOTIFICATION = "com.android.permissioncontroller:id/permission_deny_button";
    public static final String MAYBE_LATER = "new UiSelector().className(\"android.widget.Button\").index(4)";
}

