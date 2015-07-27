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
		
		String userId = request.getParameter("id");
		String password = request.getParameter("pass");
		
		InetAddress addr = InetAddress.getLocalHost();
		String ip = String.valueOf(addr.getHostAddress());
		
		
		//ipアドレスの重複チェック
		
		LoginManager loginManager = new LoginManager();
		//登録がない場合はインクリメントして失敗回数をもってくる
		int failCount = loginManager.checkOverlapCount(ip);

		
		PasswordEncryption passenc = new PasswordEncryption();
		password = passenc.getPassword_encryption(password);
		
		System.out.println(password);
		
		
		User user = loginManager.selectUserByIdandPass(userId, password);
		
		
		
		//もし10回以上パスワード間違った場合はシステムにはアクセスできなくなる
		if(failCount >= 10){
			request.setAttribute("error", "You don't access to this system.");
			getServletContext().getRequestDispatcher("/jsp/common/Login.jsp").forward(request, response);
		}
		
		else{
			//ユーザが持ってこれていない場合．
			if(user==null){
				request.setAttribute("error", "IDまたはパスワードが間違っています。");	
				//失敗してるからincrementする
				loginManager.incrementIpHistoryFailCountByIp(ip);
				getServletContext().getRequestDispatcher("/jsp/common/Login.jsp").forward(request, response);
			}
			else{
				//一回でもログインに成功したら失敗回数のリセット
				loginManager.resetIpHistoryFailCountByIp(ip);
				HttpSession session = request.getSession();
				
				//SingleAccessPointの概念に基づきログインページは1つ
				//user.roleに基づきそれぞれのtopページへ遷移
				if(user.getRole().equals("customer") ){
					//user.roleがcustomerの場合，customerというsessionを保持
					session.setAttribute("customer",user);
					
//					おすすめ情報をCustomerTopに渡す
//					ArrayList<Item> recommendedItemList = new ArrayList<Item>();
//					RecommendGetManager recommendGetManager = new RecommendGetManager();
//					recommendedItemList = recommendGetManager.getRecommendedItem();
//					request.setAttribute("RecommendedItemList", recommendedItemList);

					getServletContext().getRequestDispatcher("/jsp/customer/CustomerTop.jsp").forward(request, response);
				}
				
				else if(user.getRole().equals("worker")){
					//user/roleがworkerならworkerというsessionを保持
					session.setAttribute("worker", user);
					
					getServletContext().getRequestDispatcher("/jsp/worker/WorkerTop.jsp").forward(request, response);
				}
			}
		}
	}
}