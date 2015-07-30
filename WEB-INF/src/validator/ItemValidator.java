
package validator;

public class ItemValidator {
	private final int maxLengthItemName = 50;
	private final int minLengthItemName = 1;
	private final int maxDigitItemPrice = 12;
	private final int minDigitItemPrice = 1;
	private final int maxDigitItemStock = 3;
	private final int minDigitItemStock = 1;
	private String errorItemName = "商品名は" + Integer.toString(minLengthItemName)+ "文字以上" +Integer.toString(maxLengthItemName) + "文字以内でご入力下さい。";
	private String errorItemPriceDigit = "単価は" + Integer.toString(minDigitItemPrice) + "桁以上" +Integer.toString(maxDigitItemPrice) + "桁以内でご入力下さい。";
	private String errorItemPriceNegativeNumber = "単価は自然数でご入力下さい";
	private String errorItemPriceNotNum = "単価は半角数字でご入力下さい。";
	private String errorItemStockDigit = "在庫数は" + Integer.toString(minDigitItemStock) + "桁以上" + Integer.toString(maxDigitItemStock) + "桁以内でご入力下さい。";
	private String errorItemStockNotNum = "在庫数は半角数字でご入力下さい。";
	private String errorItemStockNegativeNumber = "在庫数は自然数でご入力下さい";

	public ItemValidator(){}

	public String validateItemName(String itemName){
		if ( itemName.length() > maxLengthItemName || itemName.length() < minLengthItemName ) {
			return errorItemName;
			}
		return null;
	}

	public String validateItemPrice(String itemPrice){
		if( !isNumber(itemPrice)){
			return errorItemPriceNotNum;
		}
		else if(itemPrice.length() > maxDigitItemPrice || itemPrice.length() < minDigitItemPrice){
			return errorItemPriceDigit;
		}
		else if( Integer.parseInt(itemPrice) < 0){
			return errorItemPriceNegativeNumber;
		}
		return null;
	}

	public String validateItemStock(String itemStock){
		if( !isNumber(itemStock)){
			return errorItemStockNotNum;
		}
		else if(itemStock.length() > maxDigitItemStock || itemStock.length() < minDigitItemStock){
			return errorItemStockDigit;
		}
		else if( Integer.parseInt(itemStock) < 0){
			return errorItemStockNegativeNumber;
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
