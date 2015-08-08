package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utility.DriverAccessor;

import java.sql.SQLException;

import beans.Customer;

public class CustomerDAO extends DriverAccessor{

	public void insertCustomer(Customer customer) {
		Connection con = null;
		con = createConnection();
		
		try{
			String sql = "insert into customer values (?,?,?);";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, customer.getUserId());
			stmt.setString(2, customer.getTel());
			stmt.setInt(3, customer.getCreditcardId());
			
			stmt.executeUpdate();
			stmt.close();
			con = null;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
		}
		
	}
}