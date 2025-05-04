package enums;

	public enum LocatorClassName {
		

	    LOGIN_LOCATOR_CLASS("LoginPage"),
	    PRODUCT_UPLOAD_LOCATOR_CLASS("ProductUploadPage"),
		LOGOUT_LOCATOR_CLASS("LogoutPage"),
		URL_REDIRECTION_LOCATOR_CLASS("UrlRedirectionPage"),
		LANGUAGE_CHANGE_LOCATOR_CLASS("LanguageChangePage"),
		VERIFY_LOGIN_POPUP_LOCATOR_CLASS("VerifyLoginPopupOnActionByLoggedOutUserPage");

	    private final String type;

		LocatorClassName(String type) {
	        this.type = type;
	    }
	
	    public String getType() {
	        return type;
	    }
	    @Override
	    public String toString() {
	        return type;
	    }
	}
