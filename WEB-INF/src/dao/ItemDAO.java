package dao;

/*****************************************************************************/
//商品を扱うDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utility.DriverAccessor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Item;

public class ItemDAO extends DriverAccessor{
	public List<Item> selectItemAll(){
		try{
			String sql = "select * from item;";
			Connection con = null;
			con = createConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			List<Item> items = new ArrayList<Item>();
			while(rs.next()){
				Item item = new Item( 
				rs.getInt( "item_id" ), 
				rs.getString( "item_name" ),
				rs.getInt( "item_price"  ), 
				rs.getInt( "item_stock"  ) );
				items.add( item );
			}
			
			stmt.close();
			con = null;

			return items;

		} catch(SQLException e){
			e.printStackTrace();
			return null;
		} finally {
		}
	}
}
