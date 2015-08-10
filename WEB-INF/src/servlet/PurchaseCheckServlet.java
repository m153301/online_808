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

public class PurchaseCheckServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

			request.setCharacterEncoding("UTF-8");
			int itemId = Integer.parseInt(request.getParameter("ItemID"));
			int itemStock = Integer.parseInt(request.getParameter("ItemSTOCK"));
			int purQuan = Integer.parseInt(request.getParameter("ItemNUM"));
			int price = Integer.parseInt(request.getParameter("ItemPRICE"));
			
			int itemLeft = itemStock - purQuan;

			//セッション取得
			HttpSession session = request.getSession(true);
			User user = (User)session.getAttribute("customer");
		
			System.out.println("Uid " + user.getUserId() + " Pid " + itemId + " Quan " + purQuan);
					
			//購入登録
			ItemPurchaseManager ipManage = new ItemPurchaseManager();
			ipManage.RegistPurchase(itemId, purQuan, user, price);
			
			ItemPurchaseManager ipManage2 = new ItemPurchaseManager();
			ipManage2.CalculateItem(itemId, itemLeft);
			
			getServletContext().getRequestDispatcher("/jsp/customer/ItemPurchaseDone.jsp").forward(request, response); 
			
		}
}