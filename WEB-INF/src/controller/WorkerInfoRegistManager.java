package controller;

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

}
