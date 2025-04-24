package config;

import locators.androidLocators.LoginPageLocatorsAndroid;
import locators.androidLocators.LogoutPageLocatorsAndroid;
import locators.androidLocators.ProductUploadLocatorsAndroid;
import locators.androidLocators.UrlRedirectionPageLocatorsAndroid;
import locators.iosLocators.LoginPageLocatorsIOS;
import locators.iosLocators.LogoutPageLocatorsIOS;
import locators.iosLocators.ProductUploadLocatorsIOS;
import locators.iosLocators.UrlRedirectionPageLocatorsIOS;

import java.util.HashMap;
import java.util.Map;

public class LocatorClassConfig {
    public static final Map<String, Class<?>> androidLocators = new HashMap<>();
    public static final Map<String, Class<?>> iosLocators = new HashMap<>();

    static {
        // Add Android locator classes
        androidLocators.put("LoginPage", LoginPageLocatorsAndroid.class);
        androidLocators.put("ProductUploadPage", ProductUploadLocatorsAndroid.class);
        androidLocators.put("LogoutPage", LogoutPageLocatorsAndroid.class);
        androidLocators.put("UrlRedirectionPage", UrlRedirectionPageLocatorsAndroid.class);

        // Add iOS locator classes
        iosLocators.put("LoginPage", LoginPageLocatorsIOS.class);
        iosLocators.put("ProductUploadPage", ProductUploadLocatorsIOS.class);
        iosLocators.put("LogoutPage", LogoutPageLocatorsIOS.class);
        iosLocators.put("UrlRedirectionPage", UrlRedirectionPageLocatorsIOS.class);
    }

}
