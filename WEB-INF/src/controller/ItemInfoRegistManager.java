
package controller;

/*****************************************************************************/
//		商品登録、発注ログを同時に格納するManager
/*****************************************************************************/

import java.util.ArrayList;
import java.util.List;

import dao.ItemDAO;
import dao.OrderHistoryDAO;

public class ItemInfoRegistManager {



	//Itemテーブルに発注した商品を格納
	//格納した商品のitem_idを検索し、返り値として返す
	public int insertItem(String itemName, int itemPrice, int itemStock){

		ItemDAO itemDAO = new ItemDAO();
		int itemId = itemDAO.insertItem(itemName, itemPrice, itemStock);

		return itemId;
	}


	//登録した商品を発注ログに格納する
	public void insertOrderHistory(String userId, int itemId, int orderQuantity, java.util.Date date) {

		OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAO();
		orderHistoryDAO.insertOrderHistory(userId, itemId, orderQuantity, date);

	}

	public List<String> validator(List<String> itemInfo) {

		List<String> error = new ArrayList<String>();

		if( itemInfo.get(0).length() > 50 || itemInfo.get(0).length() < 0 ){
			error.add("商品名は50文字以内でご入力下さい。");
		}

		if( !isNumber(itemInfo.get(1))){
			error.add("単価は半角数字でご入力下さい。");
		}
		else if(itemInfo.get(1).length() > 12 || itemInfo.get(1).length() < 0){
			error.add("単価は12桁以内でご入力下さい。");
		}

		if( !isNumber(itemInfo.get(2))){
			error.add("在庫は半角数字でご入力下さい。");
		}
		else if(itemInfo.get(2).length() > 3 || itemInfo.get(2).length() < 0){
			error.add("在庫は3桁以内でご入力下さい。");
		}

		return error;
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
