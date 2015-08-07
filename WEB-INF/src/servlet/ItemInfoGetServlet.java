
package servlet;

/*****************************************************************************/
//		商品一覧を取得するservlet
/*****************************************************************************/

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import beans.Item;
import controller.RecommendManager;


public class ItemInfoGetServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException{


		request.setCharacterEncoding("UTF-8");

		List<Item> items = new ArrayList<Item>();

		RecommendManager manager = new RecommendManager();
		items = manager.getItemInfo();
		
		request.setAttribute("items", items);
		getServletContext().getRequestDispatcher("/jsp/worker/RecommendRegist.jsp").forward(request, response);
	}

}
