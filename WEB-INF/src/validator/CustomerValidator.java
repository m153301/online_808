package validator;

public class CustomerValidator{
	
	private static final int MAX_LENGTH_CUSTOMER_TEL = 11;
	
	private static final String ERROR_CUSTOMER_TEL_TOO_LONG = "電話番号は11桁以内です．";
	private static final String ERROR_CUSTOMER_TEL_IS_NOT_BYTE = "電話番号は半角数字でご入力下さい．";
	
	public CustomerValidator(){
		
	}
	
	public String validateCustomerTel(String customerTel){
		if(customerTel.length() > MAX_LENGTH_CUSTOMER_TEL || customerTel.length() < 0){
			return ERROR_CUSTOMER_TEL_TOO_LONG;
		}
		else if(!isNumber(customerTel)){
			return ERROR_CUSTOMER_TEL_IS_NOT_BYTE;
		}
		return null;
	}

	private boolean isNumber(String number) {
		try {
	        Integer.parseInt(number);
	        return true;
	        } catch (NumberFormatException e) {
	        return false;
	    }
	}
}