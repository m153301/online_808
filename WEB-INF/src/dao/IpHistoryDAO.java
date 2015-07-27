package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.IpHistory;
import utility.DriverAccessor;

public class IpHistoryDAO extends DriverAccessor{
	
	public void ipRegist(String ip, Connection connection){
		
		try{
			String sql="insert into ip_history(ip,fail_count) values (?, 0);";
		
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,ip);
			stmt.executeUpdate();
			
			stmt.close();
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
		}
	}

	//ログイン失敗回数をとってくる
	public IpHistory getCount(String ip, Connection connection) {
		// TODO Auto-generated method stub
		try{
			String sql="select fail_count from ip_histrory where ip = ?;";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,ip);
			
			ResultSet rs=stmt.executeQuery();
			
			rs.first();
			
			IpHistory count = new IpHistory();
			count.setFail_count(rs.getInt("fail_count"));
			
			stmt.close();
			rs.close();
			
			return count;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			
		}
	}

	public void increment(String ip, Connection connection) {
		// TODO Auto-generated method stub
		try{
			String sql = "update ip_history set fail_count = fail_count + 1 where ip =?;";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,ip);
			stmt.executeUpdate();
			
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public void reset(String ip, Connection conneciton){
		try{
			String sql = "update ip_history set fail_count = 0 where ip = ?;";
			
			PreparedStatement stmt = conneciton.prepareStatement(sql);
			
			stmt.setString(1,ip);
			stmt.executeUpdate();
			
			stmt.close();
		}catch(SQLException e){
			
			e.printStackTrace();
		}finally{
			
		}
	}

	public int overlap(String ip, Connection connection) {
		// TODO Auto-generated method stub
		try{
			String sql = "select count(1) from ip_history where ip = ?;";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, ip);
			
			ResultSet rs=stmt.executeQuery();
			rs.first();
			
			int count = rs.getInt("count(1)");
			
			stmt.close();
			rs.close();
			
			return count;
		}catch(SQLException e){
			e.printStackTrace();
			return 0;
		}finally{
			
		}
	}

}