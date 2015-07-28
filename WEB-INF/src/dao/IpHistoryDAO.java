package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.DriverAccessor;

public class IpHistoryDAO extends DriverAccessor{
	
	//ipアドレスを登録する
	public void insertIpHistoryIP(String ip){
		Connection con = null;
		con = createConnection();
		try{
			String sql="insert into ip_history(ip,fail_count) values (?, 0);";
		
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1,ip);
			stmt.executeUpdate();
			
			stmt.close();
			con = null;
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
		}
	}

	//ログイン失敗回数をとってくる
	public int selectIpHistoryFailCountByIp(String ip) {
		// TODO Auto-generated method stub
		Connection con = null;
		con = createConnection();
		try{
			String sql="select fail_count from ip_history where ip = ?;";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1,ip);
			
			ResultSet rs=stmt.executeQuery();
			
			rs.first();
			
			int failCount = rs.getInt("fail_count");
			
			stmt.close();
			rs.close();
			con = null;
			
			return failCount;
			
		}catch(SQLException e){
			e.printStackTrace();
			return 0;
		}finally{
			
		}
	}

	//失敗回数をincrementする
	public void incrementIpHistoryFailCountByIp(String ip) {
		// TODO Auto-generated method stub
		Connection con = null;
		con = createConnection();
		try{
			String sql = "update ip_history set fail_count = fail_count + 1 where ip =?;";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1,ip);
			stmt.executeUpdate();
			
			stmt.close();
			con = null;
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			
		}
	}
	
	public void resetIpHistoryFailCountByIp(String ip){
		Connection con = null;
		con = createConnection();
		try{
			String sql = "update ip_history set fail_count = 0 where ip = ?;";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1,ip);
			stmt.executeUpdate();
			
			stmt.close();
			con = null;
		}catch(SQLException e){
			
			e.printStackTrace();
		}finally{
			
		}
	}

	public int selectIpHistoryCountByIp(String ip) {
		Connection con = null;
		con = createConnection();
		// TODO Auto-generated method stub
		try{
			String sql = "select count(1) from ip_history where ip = ?;";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, ip);
			
			ResultSet rs=stmt.executeQuery();
			rs.first();
			
			int count = rs.getInt("count(1)");
			
			stmt.close();
			rs.close();
			con = null;
			return count;
		}catch(SQLException e){
			e.printStackTrace();
			return 0;
		}finally{
			
		}
	}

}