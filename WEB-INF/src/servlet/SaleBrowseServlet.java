package servlet;

/*****************************************************************************/
//		売上確認をするServlet
/*****************************************************************************/

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SaleBrowseManager;

public class SaleBrowseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException{


		request.setCharacterEncoding("UTF-8");

		//購入履歴を検索する
		SaleBrowseManager saleBrowseManager = new SaleBrowseManager();
		ArrayList<String> saleHistoryList = saleBrowseManager.selectPurchaseHistory();

		request.setAttribute("SaleHistoryList", saleHistoryList);
		getServletContext().getRequestDispatcher("/jsp/worker/SaleHistoryBrowse.jsp").forward(request, response);
	}
}
