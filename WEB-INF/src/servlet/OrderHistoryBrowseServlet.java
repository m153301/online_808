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

import controller.OrderHistoryBrowseManager;



public class OrderHistoryBrowseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException{


		request.setCharacterEncoding("UTF-8");

		OrderHistoryBrowseManager selectOrderHistory = new OrderHistoryBrowseManager();
		ArrayList<String> orderHistoryList = selectOrderHistory.selectOrderHistory();

		request.setAttribute("OrderHistoryList", orderHistoryList);
		getServletContext().getRequestDispatcher("/jsp/worker/OrderedBrowse.jsp").forward(request, response);
	}

}
