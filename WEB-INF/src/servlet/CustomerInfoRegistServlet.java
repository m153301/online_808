package servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

import beans.Creditcard;
import beans.Customer;
import beans.User;
import controller.CustomerInfoRegistManager;
import utility.PasswordEncryption;


public class CustomerInfoRegistServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

			request.setCharacterEncoding("UTF-8");
			
			String customerName = StringEscapeUtils.escapeHtml4(request.getParameter("customer_name"));
			String telNumber = StringEscapeUtils.escapeHtml4(request.getParameter("tel"));
			String creditcardNumber = StringEscapeUtils.escapeHtml4(request.getParameter("credit_number"));
			int creditTypeId =  Integer.parseInt(request.getParameter("credit_type_id"));
			String userId = StringEscapeUtils.escapeHtml4(request.getParameter("customer_id"));
			PasswordEncryption passenc = new PasswordEncryption();
			String password = passenc.getPassword_encryption(StringEscapeUtils.escapeHtml4(request.getParameter("customer_pass")));
			
			CustomerInfoRegistManager customerInfoRegistManager = new CustomerInfoRegistManager();
			
			//userオブジェクトの作成
			User user = new User(userId, password, customerName, "customer");
			
			//customerオブジェクトの作成
			Customer customer = new Customer(userId, telNumber, creditTypeId);
			
			//creditcardオブジェクトの作成
			Creditcard creditcard = new Creditcard(0, creditTypeId,creditcardNumber);
			
			//不正な値が入っていないかチェック
			List<String> errors = customerInfoRegistManager.validateCustomerInfoRegistForm(user,customer,creditcard);
			
			//顧客情報の重複のチェック
			int countId = customerInfoRegistManager.selectCountUserByUserId(userId);
			
			if(countId == 0){
				
				//顧客情報を登録
				customerInfoRegistManager.registCustomerInfo(user, customer, creditcard);
				//完了画面へ
				response.sendRedirect(response.encodeRedirectURL("./CustomerInfoRegistDone.jsp"));
				
			}
			
			else{
				request.setAttribute("error", "そのidはすでに登録があります．");
				getServletContext().getRequestDispatcher("/jsp/common/CustomerInfoRegist.jsp").forward(request, response);
			}
			
			
			
			
			
		}
}