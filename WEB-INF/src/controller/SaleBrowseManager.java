
package controller;

/*****************************************************************************/
//		商品登録、発注ログを同時に格納するManager
/*****************************************************************************/

import java.util.ArrayList;

import dao.PurchaseHistoryDAO;

public class SaleBrowseManager {

	public ArrayList<String> selectPurchaseHistory(){

		PurchaseHistoryDAO saleHistoryDAO = new PurchaseHistoryDAO();

		//全ての購入履歴をとってくる
		ArrayList<String> saleHistoryList = saleHistoryDAO.selectPurchaseHistoryByAll();

		return saleHistoryList;
	}
}
