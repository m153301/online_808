package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utility.DriverAccessor;

import java.sql.SQLException;

import beans.Creditcard;

public class CreditcardDAO extends DriverAccessor{

	public void insertCreditcard(Creditcard creditcard) {
		Connection con = null;
		con = createConnection();
		
		try{
			String sql = "insert into creditcard values (0,?,?);";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, creditcard.getCreditcardType());
			stmt.setString(2, creditcard.getCreditcardNumber());
			
			stmt.executeUpdate();
			stmt.close();
			con = null;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
		}
		
	}
}
