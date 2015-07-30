
package validator;

public class ItemValidator {
	private final int MAX_LENGTH_ITEM_NAME = 50;
	private final int MIN_LENGTH_ITEM_NAME = 1;
	private final int MAX_DIGIT_ITEM_PRICE = 12;
	private final int MIN_DIGIT_ITEM_PRICE = 1;
	private final int MAX_DIGIT_ITEM_STOCK = 3;
	private final int MIN_DIGIT_ITEM_STOCK = 1;
	private String ERROR_ITEM_NAME = "商品名は" + Integer.toString(MIN_LENGTH_ITEM_NAME)+ "文字以上" +Integer.toString(MAX_LENGTH_ITEM_NAME) + "文字以内でご入力下さい。";
	private String ERROR_ITEM_PRICE_DIGIT = "単価は" + Integer.toString(MIN_DIGIT_ITEM_PRICE) + "桁以上" +Integer.toString(MAX_DIGIT_ITEM_PRICE) + "桁以内でご入力下さい。";
	private String ERROR_ITEM_PRICE_NEGATIVE_NUMBER = "単価は自然数でご入力下さい";
	private String ERROR_ITEM_PRICE_NOT_NUM = "単価は半角数字でご入力下さい。";
	private String ERROR_ITEM_STOCK_DIGIT = "在庫数は" + Integer.toString(MIN_DIGIT_ITEM_STOCK) + "桁以上" + Integer.toString(MAX_DIGIT_ITEM_STOCK) + "桁以内でご入力下さい。";
	private String ERROR_ITEM_STOCK_NOT_NUM = "在庫数は半角数字でご入力下さい。";
	private String ERROR_ITEM_STOCK_NEGATIVE_NUMBER = "在庫数は自然数でご入力下さい";

	public ItemValidator(){}

	public String validateItemName(String itemName){
		if ( itemName.length() > MAX_LENGTH_ITEM_NAME || itemName.length() < MIN_LENGTH_ITEM_NAME ) {
			return ERROR_ITEM_NAME;
			}
		return null;
	}

	public String validateItemPrice(String itemPrice){
		if( !isNumber(itemPrice)){
			return ERROR_ITEM_PRICE_NOT_NUM;
		}
		else if(itemPrice.length() > MAX_DIGIT_ITEM_PRICE || itemPrice.length() < MIN_DIGIT_ITEM_PRICE){
			return ERROR_ITEM_PRICE_DIGIT;
		}
		else if( Integer.parseInt(itemPrice) < 0){
			return ERROR_ITEM_PRICE_NEGATIVE_NUMBER;
		}
		return null;
	}

	public String validateItemStock(String itemStock){
		if( !isNumber(itemStock)){
			return ERROR_ITEM_STOCK_NOT_NUM;
		}
		else if(itemStock.length() > MAX_DIGIT_ITEM_STOCK || itemStock.length() < MIN_DIGIT_ITEM_STOCK){
			return ERROR_ITEM_STOCK_DIGIT;
		}
		else if( Integer.parseInt(itemStock) < 0){
			return ERROR_ITEM_STOCK_NEGATIVE_NUMBER;
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
