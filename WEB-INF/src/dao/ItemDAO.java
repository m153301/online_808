package dao;

/*****************************************************************************/
//商品を扱うDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utility.DriverAccessor;

import java.sql.SQLException;


public class ItemDAO extends DriverAccessor{

	//商品を格納し、商品IDを返す
	public int insertItem(String itemName, int itemPrice, int itemStock){
		PreparedStatement stmt = null;
		Connection con = null;
		con = createConnection();
		ResultSet rs = null;
		int autoIncKey = -1;

		try{

			String sql = "insert into item(item_name, item_price, item_stock) values(?,?,?)";

			stmt = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, itemName);
			stmt.setInt(2, itemPrice);
			stmt.setInt(3, itemStock);

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}

			stmt.close();
			con = null;

		}catch(SQLException e){

			e.printStackTrace();

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return autoIncKey;
	}
}
