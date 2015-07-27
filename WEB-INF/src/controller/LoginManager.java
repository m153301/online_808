package controller;

import java.sql.Connection;

import dao.IpHistoryDAO;
import dao.UserDAO;
import beans.User;
import beans.IpHistory;


public class LoginManager{
	private Connection connection = null;
	
	public LoginManager(){
	}
	
	public User certifyUser(String id, String pass){
		UserDAO dao = new UserDAO();
		
		this.connection = dao.createConnection();
		User user = dao.certifyUser(id, this.connection);
		
		dao.closeConnection(this.connection);
		
		this.connection = null;
		
		if(user==null)
			return null;
		
		else if(pass.equals(user.getPassword())){
			return user;
		}
		
		else
			return null;
		
	}
	
	//重複チェック
	public IpHistory checkOverlap(String ip){
		IpHistoryDAO check = new IpHistoryDAO();
		this.connection = check.createConnection();
		int count = check.overlap(ip, connection);
		check.closeConnection(this.connection);
		this.connection = null;
		//ipアドレスの登録があった場合
		if(count != 0){
			incrementCount(ip);
			
		}
		
		//ipアドレスの登録がない場合
		else{
			ipRegist(ip);
		}
		
		//最後に失敗回数を持って帰る
		IpHistory fail_count = getCount(ip);
		return fail_count;
		
	}
	
	private IpHistory getCount(String ip){
		IpHistoryDAO fail_count = new IpHistoryDAO();
		this.connection = fail_count.createConnection();
		IpHistory count = fail_count.getCount(ip, connection);
		this.connection = null;
		return count;
	}
	
	private void ipRegist(String ip){
		IpHistoryDAO regist = new IpHistoryDAO();
		this.connection = regist.createConnection();
		regist.ipRegist(ip, connection);
		regist.closeConnection(this.connection);
		this.connection = null;
	}
	

	public void incrementCount(String ip){
		IpHistoryDAO plus = new IpHistoryDAO();
		this.connection = plus.createConnection();
		plus.increment(ip,connection);
		plus.closeConnection(this.connection);
		this.connection = null;
	}
	
	public void resetCount(String ip){
		IpHistoryDAO reset = new IpHistoryDAO();
		this.connection = reset.createConnection();
		reset.reset(ip, connection);
		reset.closeConnection(this.connection);
		this.connection = null;
	}
}