package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
import utility.DriverAccessor;

public class UserDAO extends DriverAccessor{

	public User selectUserByIdPass(String id, String pass) {
		// TODO Auto-generated method stub
		Connection con = null;
		con = createConnection();
		try{
			
			String sql="select * from user where user_id = (?) and password = (?) ";
			
			//PreparedStatementの利用
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,id);
			stmt.setString(2,pass);
			ResultSet rs = stmt.executeQuery();
			
			rs.first();
			
			User user = new User();
			user.setUserId(rs.getString("user_id"));
			user.setUserName(rs.getString("user_name"));
			user.setPassword(rs.getString("password"));
			user.setRole(rs.getString("role"));
			
			stmt.close();
			rs.close();
			con = null;
			
			return user;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			
		}
		
	}

	public int selectCountCustomerByUserId(String userId) {
		Connection con = null;
		con = createConnection();
		try{
			String sql = "select count(1) from user where user_id = (?);";
			
			//PreparedStatementの利用
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,userId);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.first();
			
			int count = rs.getInt("count(1)");
			
			stmt.close();
			rs.close();
			con = null;
			
			return count;
		}catch(SQLException e){
			e.printStackTrace();
			//ここでretrun ０だと結果として重複なしとなってしまうため，2を返す
			return 2;
		}finally{
			
		}
		
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		Connection con = null;
		con = createConnection();
		
		try{
			String sql = "insert into user values (?,?,?,?);";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getUserName());
			stmt.setString(4, "customer");
			
			stmt.executeUpdate();
			stmt.close();
			con = null;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
		}
	}
}