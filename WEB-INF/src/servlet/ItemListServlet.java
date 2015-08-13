package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;

import utility.PasswordEncryption;

import beans.User;
import beans.Item;
import controller.ItemPurchaseManager;

public class ItemListServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

			request.setCharacterEncoding("UTF-8");
			
			//確認用
			System.out.println("hey");
			
			List<Item> itemList = new ArrayList<Item>();
			ItemPurchaseManager manager = new ItemPurchaseManager();
			itemList = manager.getItemInfo();
			
			//セッション取得
			HttpSession session = request.getSession(true);
			//User user = (User)session.getAttribute("customer");
			//System.out.println(user.getUserId());
			
			request.setAttribute("ItemList", itemList); 
			getServletContext().getRequestDispatcher("/jsp/customer/ItemList.jsp").forward(request, response); 

		}
}