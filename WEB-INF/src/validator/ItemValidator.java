package validator;

public class ItemValidator {

	public final int MAX_LENGTH_ITEM_NAME = 50;
	public final int MAX_DIGIT_ITEM_PRICE = 12; 
	public final int MAX_DIGIT_ITEM_STOCK = 3;  
	
	ItemValidator(){}
	
	public String validateItemName(String itemName){
		return ( itemName.length() > MAX_LENGTH_ITEM_NAME || itemName.length() < 0 ) ? "商品名は50文字以内でご入力下さい。" : null;
	}

	public String validateItemPrice(String itemPrice){
		if( !isNumber(itemPrice)){
			return"単価は半角数字でご入力下さい。";
		}
		else if(itemPrice.length() > MAX_DIGIT_ITEM_PRICE || itemPrice.length() < 0){
			return "単価は12桁以内でご入力下さい。";
		}
		return null;
	}
	
	public String validateItemStock(String itemStock){
		if( !isNumber(itemStock)){
			return "在庫は半角数字でご入力下さい。";
		}
		else if(itemStock.length() > MAX_DIGIT_ITEM_STOCK || itemStock.length() < 0){
			return "在庫は3桁以内でご入力下さい。";
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
