
package controller;

/*****************************************************************************/
//		商品一覧を取得するするManager
/*****************************************************************************/


import java.sql.Connection;
import java.util.ArrayList;

import dao.PurchaseHistoryDAO;
import beans.PurchaseHistory;
import beans.User;

public class PurchaseHistoryManager {

	public ArrayList<PurchaseHistory> getPurchaseHistory(User user){

		ArrayList<PurchaseHistory> purchaseList = new ArrayList<PurchaseHistory>();
		
		PurchaseHistoryDAO historyDAO = new PurchaseHistoryDAO();
		
		purchaseList = historyDAO.getPurchaseHistory(user);

		return purchaseList;
	}
}
