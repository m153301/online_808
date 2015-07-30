
//　自分が格納されているフォルダ名
package dao;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.DriverAccessor;

public class OrderHistoryDAO extends DriverAccessor{

	//発注した商品を発注履歴に格納する
	public void insertOrderHistory(String userId, int itemId, int orderQuantity, java.util.Date date){

		Connection con = null;
		con = createConnection();

		try{

			//  SQLコマンド
			String sql = "insert into order_history(user_id, item_id, order_date, order_quantity) values(?, ?, ?, ?)";

			//  SQLのコマンドを実行する
			PreparedStatement stmt = con.prepareStatement(sql);

			java.sql.Date d2 = new java.sql.Date(date.getTime());

			stmt.setString(1, userId);
			stmt.setInt(2, itemId);
			stmt.setDate(3, d2);
			stmt.setInt(4, orderQuantity);

			stmt.executeUpdate();

			//  終了処理
			stmt.close();
			con = null;

			}
			catch(SQLException e){

				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();

			}
			finally{}
	}



	//発注履歴を検索する
	public static ArrayList<String> selectOrderHistory(){

		Connection con = null;
		con = createConnection();

		try{

			String sql="SELECT ordered.order_id, user.user_name, item.item_name, ordered.order_date, ordered.order_quantity FROM user INNER JOIN (item INNER JOIN ordered ON item.item_id = ordered.item_id) ON ordered.user_id = user.user_id ORDER BY ordered.order_id DESC;";

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			ArrayList<String> list = new ArrayList<String>();

			while(rs.next())
		    {
			list.add(rs.getString("ordered.order_id"));
			list.add(rs.getString("user.user_name"));
			list.add(rs.getString("item.item_name"));
			list.add(rs.getString("ordered.order_date"));
			list.add(rs.getString("ordered.order_quantity"));
			}

			stmt.close();
			rs.close();
			con = null;

			return list;

		}catch(SQLException e){

			e.printStackTrace();
			return null;

		} finally {

		}
	}

}