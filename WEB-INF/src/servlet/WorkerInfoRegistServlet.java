package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import beans.User;
import controller.LoginManager;
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
			String password = StringEscapeUtils.escapeHtml4(request.getParameter("worker_pass"));
			
			//userオブジェクトの作成
			User user = new User(userId, userName, password, "worker");
			
			WorkerInfoRegistManager workerInfoRegistManager = new WorkerInfoRegistManager();
			
			//不正な値が入っていないかチェック
			List<String> errors = workerInfoRegistManager.validateWorkerInfoRegistForm(user);
			request.setAttribute("errors", errors);
			
			if(errors.isEmpty()){
				PasswordEncryption passenc = new PasswordEncryption();
				String hashPassword = passenc.getPassword_encryption(StringEscapeUtils.escapeHtml4(request.getParameter("worker_pass")));
				
				//userオブジェクトのパスの更新
				user.setPassword(hashPassword);
				
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
			else{
				getServletContext().getRequestDispatcher("/jsp/worker/WorkerInfoRegist.jsp").forward(request, response);
			}
			
				
			
			
		}
}