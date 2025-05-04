package locators.androidLocators;

public class VerifyLoginPopupOnActionByLoggedOutUserLocatorsAndroid {
    public static final String SKIP_BUTTON = "//android.view.View[@content-desc=\"Lewati\" or @content-desc=\"Skip\"]";
    public static final String LOGIN_POPUP = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View";
    public static final String HOMEPAGE_FAV_ICON = "//android.view.View/android.widget.ImageView[2]";
    public static final String HOMEPAGE_STAR_SELLER_CARD_FAV_ICON = "//android.view.View/android.widget.ImageView[2]";
    public static final String ALL_CATEGORY_BTN = "//android.widget.ImageView[@content-desc=\"Semua Kategori\"]";
    public static final String LOGIN_POPUP_TEXT= "//android.view.View[@content-desc=\"Data pribadi kamu aman bersama kami\" or @content-desc=\"All your personal details are safe with us.\"]";
}
