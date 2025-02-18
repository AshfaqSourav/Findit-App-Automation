package enums;

	public enum Credentials {
		

	    EMAIL_BUYER("login.emailBuyer"),
	    EMAIL_SELLER("login.emailSeller"),
		PRODUCT_NAME("product.name"),
		PRODUCT_PRICE("product.price"),
		PRODUCT_LOCATION("product.location");

	    private final String type;
	
		Credentials(String type) {
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
