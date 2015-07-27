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
	
	public User selectUser(String id, String pass){
		UserDAO select = new UserDAO();
	
		User user = select.selectUserById(id);
		
		
		if(user==null)
			return null;
		
		else if(pass.equals(user.getPassword())){
			return user;
		}
		
		else
			return null;
		
	}
	
	//重複チェック
	public IpHistory selectIpHistoryCount(String ip){
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		int count = ipHistoryDAO.selectIpHistoryCountByIp(ip);
		//ipアドレスの登録があった場合
		if(count != 0){
			incrementIpHistoryFailCount(ip);
			
		}
		
		//ipアドレスの登録がない場合
		else{
			insertIpHistoryIp(ip);
		}
		
		//最後に失敗回数を持って帰る
		IpHistory failCount = selectIpHistoryFailCount(ip);
		return failCount;
		
	}
	
	private IpHistory selectIpHistoryFailCount(String ip){
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		IpHistory failCount = ipHistoryDAO.selectIpHistoryFailCountByIp(ip);
		return failCount;
	}
	
	private void insertIpHistoryIp(String ip){
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		ipHistoryDAO.insertIpHistoryIP(ip);
		
	}
	

	public void incrementIpHistoryFailCount(String ip){
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		ipHistoryDAO.incrementIpHistoryFailCountByIp(ip);
	}
	
	public void resetIpHistoryFailCount(String ip){
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		ipHistoryDAO.resetIpHistoryFailCountByIp(ip);
	}
}