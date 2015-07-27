package dao;

/*****************************************************************************/
//商品を扱うDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import utility.DriverAccessor;

import java.sql.SQLException;


public class ItemDAO extends DriverAccessor{

	//商品を格納する
	public void insertItem(int itemId, String itemName, int itemPrice, int itemStock){
		Connection con = null;
		con = createConnection();

		try{

			String sql = "insert into item values(?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, itemId);
			stmt.setString(2, itemName);
			stmt.setInt(3, itemPrice);
			stmt.setInt(4, itemStock);

			stmt.executeUpdate();
			stmt.close();
			con = null;

		}catch(SQLException e){

			e.printStackTrace();

		} finally {

		}
	}

	//格納した商品の商品IDを検索する
	public int selectItemIdByItemName(String item_name){

		Connection con = null;
		con = createConnection();

		int item_id=0;
		try{

			String sql = "select item_id from item where item_name = '"+ item_name +"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			rs.next();
			item_id = rs.getInt("item_id");

			stmt.close();
			rs.close();
			con = null;

		}catch(SQLException e){

			e.printStackTrace();

		} finally {

		}
		return item_id;
	}

}
