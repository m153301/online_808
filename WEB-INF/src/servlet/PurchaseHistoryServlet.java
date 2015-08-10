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
import beans.PurchaseHistory;
import controller.PurchaseHistoryManager;

public class PurchaseHistoryServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

			request.setCharacterEncoding("UTF-8");			
			
			//セッション取得
			HttpSession session = request.getSession(true);
			User user = (User)session.getAttribute("customer");
			//System.out.println(user.getUserId());
			
			ArrayList<PurchaseHistory> purchaseList = new ArrayList<PurchaseHistory>();
			PurchaseHistoryManager manager = new PurchaseHistoryManager();
			purchaseList = manager.getPurchaseHistory(user);
			
			request.setAttribute("PurchaseList", purchaseList); 
			getServletContext().getRequestDispatcher("/jsp/customer/PurchaseHistory.jsp").forward(request, response); 

		}
}