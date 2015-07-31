
package controller;

/*****************************************************************************/
//		商品登録、発注ログを同時に格納するManager
/*****************************************************************************/

import java.util.ArrayList;

import dao.OrderHistoryDAO;

public class OrderHistoryBrowseManager {

	public ArrayList<String> selectOrderHistory(){

		OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAO();
		//発注履歴を検索してリストで取ってくる
		ArrayList<String> orderHistoryList = orderHistoryDAO.selectOrderHistory();

		return orderHistoryList;
	}
}
