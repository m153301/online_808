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
import java.util.ArrayList;
import java.util.List;

import beans.Item;
import beans.Recommend;


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

	public void updateItemById(int itemId, String itemName, int itemPrice){
		try{
			String sql = "update item set item_name = ?, item_price = ? where item_id = ?;";

			Connection con = null;
			con = createConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, itemName);
			stmt.setInt(2, itemPrice);
			stmt.setInt(3, itemId);

			stmt.executeUpdate();
			stmt.close();
			con = null;
		}
		catch(SQLException e){
				e.printStackTrace();
		}
		finally {
		}
	}

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
	
	//商品一覧を取得する
	public ArrayList<Item> selectItemAll(Connection connection){
		ArrayList<Item> itemList = new ArrayList<Item>();
		try{
			String sql = "select * from item;";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while( rs.next() )
			{
				
				Item item = new Item( 
						rs.getInt( "item_id" ), 
						rs.getString( "item_name" ),
						rs.getInt( "item_price"  ), 
						rs.getInt( "item_stock"  ) );
				itemList.add( item );
			}
			
			stmt.close();
			rs.close();
		}
		catch(SQLException e){
				e.printStackTrace();
		}
		finally {
			
		}
		return itemList;
	}
	
	//商品IDのリストから商品名のリストを取得する
	public List<String> selectItemNameByItemId(List<Integer> itemIdList, Connection connection){
		
		List<String> itemNameList = new ArrayList<String>();
		
		for ( int i=0; i < itemIdList.size(); i++ ) {
			try{
				int itemId = itemIdList.get(i);
				
				String sql = "select item_name from item where item_id = " + itemId + ";";
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				rs.next();
				
				itemNameList.add( rs.getString( "item_name" ) );
				System.out.println(rs.getString( "item_name" ));
				
				stmt.close();
				rs.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally {
				
			}
		}
		return itemNameList;
	}
}
