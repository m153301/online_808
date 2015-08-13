package controller;

import java.util.ArrayList;
import java.util.List;

import validator.UserValidator;
import beans.User;
import dao.UserDAO;
import dao.WorkerDAO;

public class WorkerInfoRegistManager {

	public int selectCountUserByUserId(String userId) {
		UserDAO userDAO = new UserDAO();
		
		int countId = userDAO.selectCountCustomerByUserId(userId);
		return countId;
	}

	public void registWorkerInfo(User user) {
		//userテーブルにinsertする
		insertUser(user);
		insertWorker(user.getUserId());
		
	}

	private void insertWorker(String userId) {
		// TODO Auto-generated method stub
		WorkerDAO workerDAO = new WorkerDAO();
		
		workerDAO.insertWorker(userId);
	}

	private void insertUser(User user) {
		UserDAO userDAO = new UserDAO();
		
		userDAO.insertUser(user);
		
	}

	//入力した値のチェック，不正な値だったらerrorsを返す
	public List<String> validateWorkerInfoRegistForm(User user) {
		List<String> errors = new ArrayList<String>();
		UserValidator userValidator = new UserValidator();
		
		//userテーブルに関する入力チェック
		String userIdError = userValidator.validateUserId(user.getUserId());
		String userPasswordError = userValidator.validateUserPassword(user.getPassword());
		String userNameError = userValidator.validateUserName(user.getUserName());
		
		if(userIdError != null) errors.add(userIdError);
		if(userPasswordError != null) errors.add(userPasswordError);
		if(userNameError != null) errors.add(userNameError);
		
		return errors;
	}

}
