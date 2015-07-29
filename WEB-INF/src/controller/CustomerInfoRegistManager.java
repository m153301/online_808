package controller;

import beans.Creditcard;
import beans.Customer;
import beans.User;
import dao.CreditcardDAO;
import dao.CustomerDAO;
import dao.UserDAO;

public class CustomerInfoRegistManager {


	//user_idの重複のチェック
	public int selectCountCustomerByUserId(String userId) {
		UserDAO userDAO = new UserDAO();
		
		int count = userDAO.selectCountCustomerByUserId(userId);
		return count;
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

}
