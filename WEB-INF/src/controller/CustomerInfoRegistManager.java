package controller;

import beans.Creditcard;
import beans.Customer;
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

	public void registCustomerInfo(Customer customer, Creditcard creditcard) {
		//まずはcustomerテーブルにinsertする
		insertCustomer(customer);
		//つぎにcreditcardテーブルにinsertする
		insertCreditcard(creditcard);
		
		
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
