
package controller;

/*****************************************************************************/
//		売上確認をするManager
/*****************************************************************************/

import java.util.ArrayList;

import dao.PurchaseHistoryDAO;

public class SaleBrowseManager {

	public ArrayList<String> selectPurchaseHistory(){

		PurchaseHistoryDAO saleHistoryDAO = new PurchaseHistoryDAO();

		//購入履歴をとってくる
		ArrayList<String> saleHistoryList = saleHistoryDAO.selectPurchaseHistoryAll();

		return saleHistoryList;
	}
}
