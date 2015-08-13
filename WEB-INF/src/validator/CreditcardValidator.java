package validator;

public class CreditcardValidator {

	private static final int MAX_LENGTH_CARD_NUMBER = 16;
	
	private static final String ERROR_CARD_NUMBER_TOO_LONG = "カード番号は" + Integer.toString(MAX_LENGTH_CARD_NUMBER) + "以内でご入力下さい．";
	private static final String ERROR_CARD_NUMBER_NOT_NUMBER = "カード番号は半角数字でご入力下さい．";
	
	public CreditcardValidator(){
		
	}
	
	public String validateCreditcardNumber(String cardNumber){
		if(cardNumber.length() > MAX_LENGTH_CARD_NUMBER || cardNumber.length() < 0){
			return ERROR_CARD_NUMBER_TOO_LONG;
		}
		else if(!isNumber(cardNumber)){
			return ERROR_CARD_NUMBER_NOT_NUMBER;
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
