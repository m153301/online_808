package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Item;
import controller.ItemInfoChangeManager;

public class ItemInfoChangeCheckServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String token = request.getParameter("token");

		if(token == null || !token.equals(session.getId())){

			getServletContext().getRequestDispatcher("/jsp/common/CSRF.jsp").forward(request, response);
		}
		else {
			String itemId = request.getParameter("item_id");
			List<String> errors = new ArrayList<String>();
			List<Item> items = new ArrayList<Item>();
			ItemInfoChangeManager itemInfoChangeManager = new ItemInfoChangeManager();
			items = itemInfoChangeManager.selectItemAll();
			errors = itemInfoChangeManager.validateItemInfoChangeListForm(itemId);

			request.setAttribute("errors", errors);
			request.setAttribute("items", items);

			if(!errors.isEmpty()){
				getServletContext().getRequestDispatcher("/jsp/worker/ItemInfoChangeList.jsp").forward(request, response);
			}
			else{
				getServletContext().getRequestDispatcher("/jsp/worker/ItemInfoChange.jsp").forward(request, response);
			}
		}
	}
}
