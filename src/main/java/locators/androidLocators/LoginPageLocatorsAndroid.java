package locators.androidLocators;

public class LoginPageLocatorsAndroid {
    public static final String FALLBACK_BUTTON = "new UiSelector().className(\"android.widget.Button\").index(0)";
    public static final String LOGIN_WITH_EMAIL_BUTTON = "new UiSelector().className(\"android.widget.ImageView\").index(4)";
    public static final String LOGIN_EMAIL_TEXT = "new UiSelector().className(\"android.widget.EditText\")";
    public static final String LOGIN_EMAIL_NEXT_BUTTON = "//android.widget.Button[@content-desc=\"Lanjutkan\" or @content-desc=\"Next\"]";
    public static final String LOGIN_EMAIL_OTP_2 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText[2]";
    public static final String LOGIN_EMAIL_OTP_3 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText[3]";
    public static final String LOGIN_EMAIL_OTP_4 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText[4]";
    public static final String LOGIN_EMAIL_OTP_5 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText[5]";
    public static final String LOGIN_EMAIL_OTP_1 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText[1]";
    public static final String LOGIN_EMAIL_OTP_6 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText[6]";
    public static final String LOGIN_EMAIL_VERIFY_BUTTON = "new UiSelector().className(\"android.widget.Button\").index(5)";
    public static final String TURN_ON_NOTIFICATION_BUTTON = "new UiSelector().className(\"android.widget.Button\").index(3)";
    public static final String ALLOW_NOTIFICATION = "com.android.permissioncontroller:id/permission_allow_button";
    public static final String DONT_ALLOW_NOTIFICATION = "com.android.permissioncontroller:id/permission_deny_button";
    public static final String MAYBE_LATER = "new UiSelector().className(\"android.widget.Button\").index(4)";

}

