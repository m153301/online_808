package controller;

import java.sql.Connection;

import dao.IpHistoryDAO;
import dao.UserDAO;
import beans.User;
import beans.IpHistory;

//とりあえず作ったからあとで直す
public class LoginManager{
	
	public LoginManager(){
	}
	
	public User selectUserByIdandPass(String id, String pass){
		UserDAO userDAO = new UserDAO();
	
		User user = userDAO.selectUserByIdandPass(id,pass);
		
		return user;
		
	}
	
	//重複チェック
	public IpHistory checkOverlapCount(String ip){
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		int count = ipHistoryDAO.selectIpHistoryCountByIp(ip);
		//ipアドレスの登録があった場合
		if(count != 0){
			incrementIpHistoryFailCountByIp(ip);
			
		}
		
		//ipアドレスの登録がない場合
		else{
			insertIpHistoryIp(ip);
		}
		
		//最後に失敗回数を持って帰る
		IpHistory failCount = selectIpHistoryFailCountByIp(ip);
		return failCount;
		
	}
	
	private IpHistory selectIpHistoryFailCountByIp(String ip){
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		IpHistory failCount = ipHistoryDAO.selectIpHistoryFailCountByIp(ip);
		return failCount;
	}
	
	private void insertIpHistoryIp(String ip){
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		ipHistoryDAO.insertIpHistoryIP(ip);
		
	}
	

	public void incrementIpHistoryFailCountByIp(String ip){
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		ipHistoryDAO.incrementIpHistoryFailCountByIp(ip);
	}
	
	public void resetIpHistoryFailCountByIp(String ip){
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		ipHistoryDAO.resetIpHistoryFailCountByIp(ip);
	}
}