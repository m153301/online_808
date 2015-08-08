package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import beans.User;
import controller.WorkerInfoRegistManager;
import utility.PasswordEncryption;


public class WorkerInfoRegistServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

			request.setCharacterEncoding("UTF-8");
			
			String userName = StringEscapeUtils.escapeHtml4(request.getParameter("worker_name"));
			String userId = StringEscapeUtils.escapeHtml4(request.getParameter("worker_id"));
			PasswordEncryption passenc = new PasswordEncryption();
			String password = passenc.getPassword_encryption(StringEscapeUtils.escapeHtml4(request.getParameter("worker_pass")));
			
			
			//店員情報登録へ
			WorkerInfoRegistManager workerInfoRegistManager = new WorkerInfoRegistManager();
			
			//userオブジェクトの作成
			User user = new User(userId, password, userName, "worker");
			//idに重複がないかチェック
			int countId = workerInfoRegistManager.selectCountUserByUserId(userId);
			
			if(countId == 0){
				
				//店員情報を登録
				workerInfoRegistManager.registWorkerInfo(user);
				//完了画面へ
				response.sendRedirect(response.encodeRedirectURL("./WorkerInfoRegistDone.jsp"));
			}
				
			
			else{
				
				request.setAttribute("error", "そのidはすでに登録があります．");
				getServletContext().getRequestDispatcher("/jsp/worker/WorkerInfoRegist.jsp").forward(request, response);
			}
				
			
			
		}
}