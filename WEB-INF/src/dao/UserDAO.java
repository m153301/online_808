package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
import utility.DriverAccessor;

public class UserDAO extends DriverAccessor{

	public User selectUserById(String id) {
		// TODO Auto-generated method stub
		Connection con = null;
		con = createConnection();
		try{
			
			String sql="select * from user where user_id = '"+id+"' ";
			
			//PreparedStatementの利用
			PreparedStatement stmt = con.prepareStatement(sql);
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
}