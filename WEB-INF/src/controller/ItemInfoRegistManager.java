
package controller;

/*****************************************************************************/
//		商品登録、発注ログを同時に格納するManager
/*****************************************************************************/

import dao.ItemDAO;
import dao.OrderHistoryDAO;
import beans.Item;
import beans.OrderHistory;

public class ItemInfoRegistManager {



	//Itemテーブルに発注した商品を格納
	//格納した商品のitem_idを検索し、返り値として返す
	public int registItemInfo(Item item){

		ItemDAO itemDAO = new ItemDAO();
		itemDAO.insertItem(item.getItemId(), item.getItemName(), item.getItemPrice(), item.getItemStock());
		int item_id = itemDAO.selectItemIdByItemName(item.getItemName());

		return item_id;
	}


	//登録した商品を発注ログに格納する
	public void registItemLog(OrderHistory orderHistory) {

		OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAO();
		orderHistoryDAO.insertOrderHistory(orderHistory.getOrderId(), orderHistory.getUserId(), orderHistory.getItemId(), orderHistory.getOrderQuantity(), orderHistory.getOrderDate());;

	}
}
