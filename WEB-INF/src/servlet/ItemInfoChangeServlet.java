package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import beans.Item;
import controller.ItemInfoChangeManager;

public class ItemInfoChangeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
			
			request.setCharacterEncoding("UTF-8");
			
			String itemId = StringEscapeUtils.escapeHtml4(request.getParameter("item_id"));
			String itemName = StringEscapeUtils.escapeHtml4(request.getParameter("item_name"));
			String itemPrice = StringEscapeUtils.escapeHtml4(request.getParameter("item_price"));
	
			List<String> errors = new ArrayList<String>();
			List<Item> items = new ArrayList<Item>();
			ItemInfoChangeManager itemInfoChangeManager = new ItemInfoChangeManager();
			items = itemInfoChangeManager.selectItemAll();
			errors = itemInfoChangeManager.validateItemInfoChangeForm(itemName, itemPrice);
			request.setAttribute("errors", errors);
			request.setAttribute("items", items);

			if(!errors.isEmpty()){
				getServletContext().getRequestDispatcher("/jsp/worker/ItemInfoChange.jsp").forward(request, response);
			}
			else{
				itemInfoChangeManager.updateItemById(Integer.parseInt(itemId), itemName, Integer.parseInt(itemPrice));
				getServletContext().getRequestDispatcher("/jsp/worker/ItemInfoChangeDone.jsp").forward(request, response);
			}
			
		}
}
