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
import beans.User;
import controller.LoginManager;
import controller.RecommendManager;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = StringEscapeUtils.escapeHtml4( request.getParameter("id"));
		String password = StringEscapeUtils.escapeHtml4(request.getParameter("pass"));
		
		//不正な値が入っていないかチェック
		List<String> errors = LoginManager.validateLoginForm(userId,password);
		request.setAttribute("errors",errors);
		
		if(errors.isEmpty()){
		
			InetAddress addr = InetAddress.getLocalHost();
			String ip = String.valueOf(addr.getHostAddress());
			
			
			//ipアドレスの重複チェック
			
			LoginManager loginManager = new LoginManager();
			//チェックしたら失敗回数をもってくる
			int failCount = loginManager.checkOverlapCount(ip);
	
			
			PasswordEncryption passenc = new PasswordEncryption();
			password = passenc.getPassword_encryption(password);
			
			
			
			User user = loginManager.selectUserByIdPass(userId, password);
			
			
			
			//もし10回以上パスワード間違った場合はシステムにはアクセスできなくなる
			if(failCount >= 10){
				request.setAttribute("error", "You don't access to this system.");
				getServletContext().getRequestDispatcher("/jsp/common/Login.jsp").forward(request, response);
			}
			
			else{
				//userがもってこれている．
				if(user!=null){
					//一回でもログインに成功したら失敗回数のリセット
					loginManager.resetIpHistoryFailCountByIp(ip);
					HttpSession session = request.getSession();
					
					//SingleAccessPointの概念に基づきログインページは1つ
					//user.roleに基づきそれぞれのtopページへ遷移
					if(user.getRole().equals("customer") ){
						//user.roleがcustomerの場合，customerというsessionを保持
						session.setAttribute("customer",user);
						
						//おすすめ情報をCustomerTopに渡す
						List<String> itemNameList = new ArrayList<String>();
						RecommendManager recommendManager = new RecommendManager();
						itemNameList = recommendManager.selectRecommendItemName();
						request.setAttribute("RecommendItemNameList", itemNameList);
	
						getServletContext().getRequestDispatcher("/jsp/customer/CustomerTop.jsp").forward(request, response);
					}
					
					else if(user.getRole().equals("worker")){
						//user/roleがworkerならworkerというsessionを保持
						session.setAttribute("worker", user);
						
						getServletContext().getRequestDispatcher("/jsp/worker/WorkerTop.jsp").forward(request, response);
					}
				}
				//ログイン失敗
				else{
					request.setAttribute("error", "IDまたはパスワードが間違っています。");	
					//失敗してるからincrementする
					loginManager.incrementIpHistoryFailCountByIp(ip);
					getServletContext().getRequestDispatcher("/jsp/common/Login.jsp").forward(request, response);
				}
					
			}
		}
		else{
			getServletContext().getRequestDispatcher("/jsp/common/Login.jsp").forward(request, response);
		}
	}
}