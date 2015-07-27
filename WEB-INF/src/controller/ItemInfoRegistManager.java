
package controller;

/*****************************************************************************/
//		商品登録、発注ログを同時に格納するManager
/*****************************************************************************/


import java.sql.Connection;

import dao.ItemDAO;
import dao.OrderHistoryDAO;
import beans.Item;
import beans.OrderHistory;

public class ItemInfoRegistManager {

	private Connection connection = null;


	//Itemテーブルに発注した商品を格納
	//格納した商品のitem_idを検索し、返り値として返す
	public int registItemInfo(Item item){
		ItemDAO itemDAO = new ItemDAO();
		this.connection = itemDAO.createConnection();

		itemDAO.registItemInfoDAO(item, connection);
		int item_id = itemDAO.selectItemIdDAO(item.getItemName(),connection);
		itemDAO.closeConnection(this.connection);

		this.connection = null;

		return item_id;
	}


	//登録した商品を発注ログに格納する
	public void registItemLog(OrderHistory orderHistory) {
		OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAO();
		this.connection = orderHistoryDAO.createConnection();

		orderHistoryDAO.registItemLog(orderHistory, connection);
		orderHistoryDAO.closeConnection(this.connection);

		this.connection = null;

	}

}
