package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utility.DriverAccessor;

public class WorkerDAO extends DriverAccessor{

	public void insertWorker(String userId) {
		// TODO Auto-generated method stub
		Connection con = null;
		con = createConnection();
		
		try{
			String sql = "insert into customer values (?);";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, userId);
			
			
			stmt.executeUpdate();
			stmt.close();
			con = null;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
		}
	}
}