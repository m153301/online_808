
package controller;

/*****************************************************************************/
//		商品登録、発注ログを同時に格納するManager
/*****************************************************************************/

import java.util.ArrayList;
import java.util.List;

import validator.ItemValidator;
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


	//入力した値のチェック。不正な値だったらエラーを返す
	public List<String> validator(List<String> itemInfo) {

		List<String> errors = new ArrayList<String>();
		ItemValidator itemValidator = new ItemValidator();

		errors.add(itemValidator.validateItemName(itemInfo.get(0)));
		errors.add(itemValidator.validateItemPrice(itemInfo.get(1)));
		errors.add(itemValidator.validateItemStock(itemInfo.get(2)));

		return errors;
	}

}
