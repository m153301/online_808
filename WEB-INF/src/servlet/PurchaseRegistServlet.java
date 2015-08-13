package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;

import org.apache.commons.lang3.StringEscapeUtils;

import utility.PasswordEncryption;
import beans.User;
import beans.Item;
import controller.ItemPurchaseManager;

public class PurchaseRegistServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

			request.setCharacterEncoding("UTF-8");
			int itemId = Integer.parseInt(request.getParameter("ItemID"));
			String itemName = request.getParameter("ItemNAME");
			int itemPrice = Integer.parseInt(request.getParameter("ItemPRICE"));
			int purQuan = Integer.parseInt(request.getParameter("number"));
			int itemStock = Integer.parseInt(request.getParameter("ItemSTOCK"));
			int price = itemPrice * purQuan;

			if(purQuan == 0)
			{
				getServletContext().getRequestDispatcher("/jsp/customer/CustomerTop.jsp").forward(request, response);
			}
			else
			{
				//セッション取得
				HttpSession session = request.getSession(true);
				User user = (User)session.getAttribute("customer");
			
				System.out.println("Uid " + user.getUserId() + " Pid " + itemId + " Quan " + purQuan);
			
				//購入登録
				//ItemPurchaseManager ipManage = new ItemPurchaseManager();
				//ipManage.RegistPurchase(itemId, purQuan, user);
			
				request.setAttribute("ItemID", itemId);
				request.setAttribute("ItemNAME", itemName);
				request.setAttribute("ItemPRICE", itemPrice);
				request.setAttribute("ItemSTOCK", purQuan);
				request.setAttribute("ItemSTOCK2", itemStock);
				request.setAttribute("PRICE", price);
				getServletContext().getRequestDispatcher("/jsp/customer/ItemPurchaseCheck.jsp").forward(request, response); 
			}
		}
}