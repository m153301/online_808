package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
import utility.DriverAccessor;

public class UserDAO extends DriverAccessor{

	public User certifyUser(String id, Connection connection) {
		// TODO Auto-generated method stub
try{
			
			String sql="select * from user where user_id = '"+id+"' ";
			
			//PreparedStatementの利用
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			rs.first();
			
			User user = new User();
			user.setUserId(rs.getString("user_id"));
			user.setUserName(rs.getString("user_name"));
			user.setPassword(rs.getString("password"));
			user.setRole(rs.getString("role"));
			
			stmt.close();
			rs.close();
			
			return user;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			
		}
		
	}
}