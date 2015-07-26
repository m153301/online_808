package servlet;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;

import utility.PasswordEncryption;
import beans.IpHistory;
import beans.User;
import controller.LoginManager;
import controller.RecommendGetManager;
import beans.Item;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		
		String user_id = request.getParameter("id");
		String password = request.getParameter("pass");
		
		InetAddress addr = InetAddress.getLocalHost();
		String ip = String.valueOf(addr.getHostAddress());
		
		
		//ipアドレスの重複チェック
		
		LoginManager check = new LoginManager();
		//登録がない場合はインクリメントして失敗回数をもってくる
		IpHistory count = check.checkOverlap(ip);

		
		PasswordEncryption passenc = new PasswordEncryption();
		password = passenc.getPassword_encryption(password);
		
		System.out.println(password);
		
		LoginManager manager = new LoginManager();
		
		User user = manager.certifyUser(user_id, password);
		
		
		
		//もし10回パスワード間違った場合は管理者に連絡するってことで
		if(count.getFail_count() >= 11){
			request.setAttribute("error", "もうはいれませーん");
			getServletContext().getRequestDispatcher("/jsp/common/Login.jsp").forward(request, response);
		}
		
		else{
			if(null==user){
				request.setAttribute("error", "IDまたはパスワードが間違っています。");	
				//失敗してるからincrementする
				manager.incrementCount(ip);
				getServletContext().getRequestDispatcher("/jsp/common/Login.jsp").forward(request, response);
			}
			
			else{
				//失敗回数のリセット
				manager.resetCount(ip);
				HttpSession session = request.getSession();
				
				if(user.getRole().equals("customer") ){
					session.setAttribute("customer",user);
					
//					おすすめ情報をCustomerTopに渡す
//					ArrayList<Item> recommendedItemList = new ArrayList<Item>();
//					RecommendGetManager recommendGetManager = new RecommendGetManager();
//					recommendedItemList = recommendGetManager.getRecommendedItem();
//					request.setAttribute("RecommendedItemList", recommendedItemList);

					getServletContext().getRequestDispatcher("/jsp/customer/CustomerTop.jsp").forward(request, response);
				}
				
				else if(user.getRole().equals("worker")){
					session.setAttribute("worker", user);
					
					getServletContext().getRequestDispatcher("/jsp/worker/WorkerTop.jsp").forward(request, response);
				}
			}
		}
	}
}