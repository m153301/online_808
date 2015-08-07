package controller;

import java.util.ArrayList;
import java.util.List;

import dao.IpHistoryDAO;
import dao.RecommendDAO;
import dao.UserDAO;
import beans.User;


//とりあえず作ったからあとで直す
public class LoginManager{
	
	public LoginManager(){
	}
	
	public User selectUserByIdPass(String id, String pass){
		UserDAO userDAO = new UserDAO();
	
		User user = userDAO.selectUserByIdPass(id,pass);
		
		return user;
		
	}
	
	//重複チェック
	public int checkOverlapCount(String ip){
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		int count = ipHistoryDAO.selectIpHistoryCountByIp(ip);
		
		//ipアドレスの登録がなかった場合
		if(count ==0){
			insertIpHistoryIp(ip);
		}
		//登録があった場合は何もしない
		
		//最後に失敗回数を確認し，その値を返す．
		int failCount = selectIpHistoryFailCountByIp(ip);
		return failCount;
		
	}
	
	private int selectIpHistoryFailCountByIp(String ip){
		IpHistoryDAO ipHistoryDAO = new IpHistoryDAO();
		int failCount = ipHistoryDAO.selectIpHistoryFailCountByIp(ip);
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

	//おすすめをrecommendテーブルから取得し、おすすめされている商品一覧を返す
	public List<String> getRecommendedItemName(){
		
		List<String> itemNameList = new ArrayList<String>();
		
		//おすすめテーブルから一覧を取得
		RecommendDAO recommendDAO = new RecommendDAO();
		itemNameList = recommendDAO.selectRecommendAll();
		
		return itemNameList;
	}
}