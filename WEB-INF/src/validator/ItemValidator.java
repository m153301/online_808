
package validator;

public class ItemValidator {
	private static final int MAX_LENGTH_ITEM_NAME = 50;
	private static final int MAX_DIGIT_ITEM_PRICE = 10; 
	private static final int MAX_DIGIT_ITEM_STOCK = 3;  
	private static final int MIN_LENGTH_ITEM_NAME = 1;
	private static final int MIN_DIGIT_ITEM_PRICE = 1; 
	private static final int MIN_DIGIT_ITEM_STOCK = 1;  

	private static final String ERROR_ITEM_ID_NULL = "商品を選択して下さい。";
	private static final String ERROR_ITEM_NAME_TOO_LONG ="商品名は" + Integer.toString(MIN_LENGTH_ITEM_NAME)+ "文字以上" +Integer.toString(MAX_LENGTH_ITEM_NAME) + "文字以内でご入力下さい。";
	private static final String ERROR_ITEM_PRICE_TOO_MUCH = "単価は" + Integer.toString(MIN_DIGIT_ITEM_PRICE) + "桁以上" +  Integer.toString(MAX_DIGIT_ITEM_PRICE) + "桁以内でご入力下さい。";
	private static final String ERROR_ITEM_PRICE_NOT_NUM = "単価は半角数字でご入力下さい。";
	private static final String ERROR_ITEM_PRICE_NEGATIVE_NUM = "単価はで自然数ご入力下さい。";
	private static final String ERROR_ITEM_STOCK_TOO_MUCH = "在庫数は" + Integer.toString(MIN_DIGIT_ITEM_STOCK) + "桁以上" + Integer.toString(MAX_DIGIT_ITEM_STOCK) + "桁以内でご入力下さい。";
	private static final String ERROR_ITEM_STOCK_NOT_NUM = "在庫数は半角数字でご入力下さい。";
	private static final String ERROR_ITEM_STOCK_NEGATIVE_NUM = "在庫数は自然数でご入力下さい。";
	
	public ItemValidator(){}
	
	public String validateItemId(String itemId){
		return (itemId == null) ? ERROR_ITEM_ID_NULL : null;
	}

	public String validateItemName(String itemName){
		return (itemName.length() > MAX_LENGTH_ITEM_NAME || itemName.length() < MIN_LENGTH_ITEM_NAME) ? ERROR_ITEM_NAME_TOO_LONG : null;
	}

	public String validateItemPrice(String itemPrice){
		if(itemPrice.length() > MAX_DIGIT_ITEM_PRICE || itemPrice.length() < MIN_DIGIT_ITEM_PRICE){
			return ERROR_ITEM_PRICE_TOO_MUCH;
		}
		else if(!isNumber(itemPrice)){
			return ERROR_ITEM_PRICE_NOT_NUM;
		}
		else if(Integer.parseInt(itemPrice) < 0){
			return ERROR_ITEM_PRICE_NEGATIVE_NUM;
		}
		
		return null;
	}
	
	public String validateItemStock(String itemStock){
		if(itemStock.length() > MAX_DIGIT_ITEM_STOCK || itemStock.length() < MIN_DIGIT_ITEM_STOCK){
			return ERROR_ITEM_STOCK_NOT_NUM;
		}
		else if( !isNumber(itemStock)){
			return ERROR_ITEM_STOCK_TOO_MUCH;
		}
		else if(Integer.parseInt(itemStock) < 0){
			return ERROR_ITEM_STOCK_NEGATIVE_NUM;
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
