package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import controller.ItemInfoChangeManager;

public class ItemInfoChangeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
			
			request.setCharacterEncoding("UTF-8");
			
			int itemId = Integer.parseInt(request.getParameter("item_id"));
			String itemName = StringEscapeUtils.escapeHtml4(request.getParameter("item_name"));
			int itemPrice = Integer.parseInt(StringEscapeUtils.escapeHtml4(request.getParameter("item_price")));
	
			ItemInfoChangeManager itemInfoChangeManager = new ItemInfoChangeManager();
			itemInfoChangeManager.updateItemById(itemId, itemName, itemPrice);
			
			getServletContext().getRequestDispatcher("/jsp/worker/ItemInfoChangeDone.jsp").forward(request, response);
		}
}
