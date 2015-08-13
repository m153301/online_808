
package servlet;

/*****************************************************************************/
//		おすすめされた商品のリストを返すservlet
/*****************************************************************************/

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RecommendManager;


public class RecommendItemNameGetServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException{


		request.setCharacterEncoding("UTF-8");

		List<String> recommendItemNameList = new ArrayList<String>();
		
		RecommendManager manager = new RecommendManager();
		recommendItemNameList = manager.selectRecommendItemName();
		
		request.setAttribute("RecommendItemNameList", recommendItemNameList );
		getServletContext().getRequestDispatcher("/jsp/customer/CustomerTop.jsp").forward(request, response);
	}
}
