package controller;




import java.util.ArrayList;
import java.util.List;

import validator.UserValidator;
import beans.Creditcard;
import beans.Customer;
import beans.User;
import dao.CreditcardDAO;
import dao.CustomerDAO;
import dao.UserDAO;

public class CustomerInfoRegistManager {


	//user_idの重複のチェック
	public int selectCountUserByUserId(String userId) {
		UserDAO userDAO = new UserDAO();
		
		int countId = userDAO.selectCountCustomerByUserId(userId);
		return countId;
	}

	public void registCustomerInfo(User user, Customer customer, Creditcard creditcard) {
		//userテーブルにinsertする
		insertUser(user);
		//customerテーブルにinsertする
		insertCustomer(customer);
		//reditcardテーブルにinsertする
		insertCreditcard(creditcard);
		
		
	}

	private void insertUser(User user) {
		UserDAO userDAO = new UserDAO();
		
		userDAO.insertUser(user);
		
	}

	private void insertCreditcard(Creditcard creditcard) {
		CreditcardDAO creditcardDAO = new CreditcardDAO();
		
		creditcardDAO.insertCreditcard(creditcard);
		
	}

	private void insertCustomer(Customer customer) {
		CustomerDAO customerDAO = new CustomerDAO();
		
		customerDAO.insertCustomer(customer);
		
	}

	//例外の重複チェック
	public List<String> validator(User user, Customer customer,
			Creditcard creditcard) {
		// TODO Auto-generated method stub
		List<String> errors = new ArrayList<String>();
		UserValidator userValidator = new UserValidator();
		
		String userIdError = userValidator.validateUserId(user.getUserId());
		String userPasswordError = userValidator.validateUserPassword(user.getPassword());
		String userNameError = userValidator.validateUserName(user.getUserName());
		return null;
	}
	
	
	
	

}
