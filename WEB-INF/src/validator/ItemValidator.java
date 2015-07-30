
package validator;

public class ItemValidator {
	private final int MAX_LENGTH_ITEM_NAME = 50;
	private final int MAX_DIGIT_ITEM_PRICE = 12; 
	private final int MAX_DIGIT_ITEM_STOCK = 3;  
	private String errorItemNameTooLong = "商品名は" + Integer.toString(MAX_LENGTH_ITEM_NAME) + "以内でご入力下さい。";
	private String errorItemPriceTooMuch = "単価は" + Integer.toString(MAX_DIGIT_ITEM_PRICE) + "桁以内でご入力下さい。";
	private String errorItemPriceNotNum = "単価は半角数字でご入力下さい。";
	private String errorItemStockTooMuch = "在庫数は" + Integer.toString(MAX_DIGIT_ITEM_STOCK) + "桁以内でご入力下さい。";
	private String errorItemStockNotNum = "在庫数は半角数字でご入力下さい。";
	
	public ItemValidator(){}
	
	public String validateItemName(String itemName){
		System.out.println(itemName.length());
		return ( itemName.length() > MAX_LENGTH_ITEM_NAME || itemName.length() < 0 ) ? errorItemNameTooLong : null;
	}

	public String validateItemPrice(String itemPrice){
		if( !isNumber(itemPrice)){
			return errorItemPriceNotNum;
		}
		else if(itemPrice.length() > MAX_DIGIT_ITEM_PRICE || itemPrice.length() < 0){
			return errorItemPriceTooMuch;
		}
		return null;
	}
	
	public String validateItemStock(String itemStock){
		if( !isNumber(itemStock)){
			return errorItemStockTooMuch;
		}
		else if(itemStock.length() > MAX_DIGIT_ITEM_STOCK || itemStock.length() < 0){
			return errorItemStockNotNum;
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
