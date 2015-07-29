package validator;

public class ItemValidator {

	private final int MAX_LENGTH_ITEM_NAME = 50;
	private final int MAX_DIGIT_ITEM_PRICE = 12; 
	private final int MAX_DIGIT_ITEM_STOCK = 3;  
	private String ERROR_ITEM_NAME_TOO_LONG = "商品名は" + Integer.toString(MAX_LENGTH_ITEM_NAME) + "以内でご入力下さい。";
	private String ERROR_ITEM_PRICE_TOO_MUCH = "単価は" + Integer.toString(MAX_DIGIT_ITEM_PRICE) + "桁以内でご入力下さい。";
	private String ERROR_ITEM_PRICE_NOT_NUM = "単価は半角数字でご入力下さい。";
	private String ERROR_ITEM_STOCK_TOO_MUCH = "在庫数は" + Integer.toString(MAX_DIGIT_ITEM_STOCK) + "桁以内でご入力下さい。";
	private String ERROR_ITEM_STOCK_NOT_NUM = "在庫数は半角数字でご入力下さい。";
	
	public ItemValidator(){}
	
	public String validateItemName(String itemName){
		return ( itemName.length() > MAX_LENGTH_ITEM_NAME || itemName.length() < 0 ) ? ERROR_ITEM_NAME_TOO_LONG : null;
	}

	public String validateItemPrice(String itemPrice){
		if( !isNumber(itemPrice)){
			return ERROR_ITEM_PRICE_NOT_NUM;
		}
		else if(itemPrice.length() > MAX_DIGIT_ITEM_PRICE || itemPrice.length() < 0){
			return ERROR_ITEM_PRICE_TOO_MUCH;
		}
		return null;
	}
	
	public String validateItemStock(String itemStock){
		if( !isNumber(itemStock)){
			return ERROR_ITEM_STOCK_TOO_MUCH;
		}
		else if(itemStock.length() > MAX_DIGIT_ITEM_STOCK || itemStock.length() < 0){
			return ERROR_ITEM_STOCK_NOT_NUM;
		}
		return null;
	}
	
	private boolean isNumber(String num){
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException nfex) {
			return false;
		}
	}
}
