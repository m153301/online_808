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

import beans.Item;

public class ItemDAO extends DriverAccessor{

	//商品を登録する
	public void insertItem(Item item, Connection connection){
		try{

			String sql = "insert into item values(?,?,?,?)";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, item.getItemId());
			stmt.setString(2, item.getItemName());
			stmt.setInt(3, item.getItemPrice());
			stmt.setInt(4, item.getItemStock());

			stmt.executeUpdate();

			stmt.close();
		}catch(SQLException e){

			e.printStackTrace();

		} finally {

		}
	}

	//登録した商品の商品IDを検索する
	public int selectItemIdByItemName(String item_name, Connection connection){

		int item_id=0;
		try{

			String sql = "select item_id from item where item_name = '"+ item_name +"'";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			rs.next();
			item_id = rs.getInt("item_id");

			stmt.close();
			rs.close();
		}catch(SQLException e){

			e.printStackTrace();

		} finally {

		}
		return item_id;
	}

}
