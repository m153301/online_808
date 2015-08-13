package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import org.apache.commons.lang3.StringEscapeUtils;

import utility.PasswordEncryption;
import beans.User;
import beans.Item;
import controller.ItemPurchaseManager;

public class ItemPurchaseServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

			request.setCharacterEncoding("UTF-8");
			int itemId = Integer.parseInt(request.getParameter("itemID"));
			String itemName = request.getParameter("itemNAME");
			int itemPrice = Integer.parseInt(request.getParameter("itemPRICE"));
			int itemStock = Integer.parseInt(request.getParameter("itemSTOCK"));
			
			System.out.println("id " + itemId + " name " + itemName + " itemPrice " + itemPrice);
			//セッション取得
			HttpSession session = request.getSession(true);
			
			request.setAttribute("ItemID", itemId);
			request.setAttribute("ItemNAME", itemName);
			request.setAttribute("ItemPRICE", itemPrice); 
			request.setAttribute("ItemSTOCK", itemStock); 
			getServletContext().getRequestDispatcher("/jsp/customer/ItemPurchase.jsp").forward(request, response); 

		}
}