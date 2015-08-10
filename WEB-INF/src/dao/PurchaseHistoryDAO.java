package dao;

/*****************************************************************************/
//購入履歴を扱うDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.PurchaseHistory;
import beans.User;
import utility.DriverAccessor;

public class PurchaseHistoryDAO extends DriverAccessor{

	//売上を出すために商品名、購入日付、購入数、値段を検索する
	public ArrayList<String> selectPurchaseHistoryAll(){

		Connection con = null;
		con = createConnection();

		try{

			String sql="SELECT * from purchase_history LEFT JOIN item using  (item_id) LEFT JOIN user using (user_id) ORDER BY purchase_history.purchase_id;";

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			ArrayList<String> saleHistorylist = new ArrayList<String>();

			while(rs.next())
		    {

			saleHistorylist.add(rs.getString("purchase_history.buy_date"));
			saleHistorylist.add(rs.getString("item.item_name"));
			saleHistorylist.add(rs.getString("purchase_history.purchase_quantity"));
			saleHistorylist.add(rs.getString("purchase_history.item_price"));

			}

			stmt.close();
			rs.close();

			return saleHistorylist;

		}catch(SQLException e){

			e.printStackTrace();
			return null;

		} finally {

		}
	}
	
	//購入履歴を表示するためDBから取り出す
	public ArrayList<PurchaseHistory> getPurchaseHistory(User user){

		Connection con = null;
		con = createConnection();

		ArrayList<PurchaseHistory> purchaseList = new ArrayList<PurchaseHistory>();
		
		try{
			String sql = "select * from purchase_history INNER JOIN item on purchase_history.item_id = item.item_id WHERE purchase_history.user_id='" + user.getUserId() + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while( rs.next() )
			{

				PurchaseHistory purchase = new PurchaseHistory( 
						rs.getInt( "purchase_id" ),
						rs.getInt( "item_id" ),
						rs.getString( "item_name" ),
						rs.getDate( "buy_date" ),
						rs.getInt( "purchase_quantity"  ), 
						rs.getString( "user_id"  ) );
				purchaseList.add( purchase );
			}

			stmt.close();
			rs.close();

			return purchaseList;
			
		}
		catch(SQLException e){
				e.printStackTrace();
				return null;
		}
		finally {
			
		}
	}

}
