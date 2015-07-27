
//　自分が格納されているフォルダ名
package dao;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.OrderHistory;
import utility.DriverAccessor;

public class OrderHistoryDAO extends DriverAccessor{

	//発注した商品を格納する
	public void insertOrderHistory(OrderHistory orderHistory, Connection connection){

		try{


			//  SQLコマンド
			String sql = "insert into order_history values(?, ?, ?, ?, ?)";

			//  SQLのコマンドを実行する
			PreparedStatement stmt = connection.prepareStatement(sql);

			java.util.Date d = new java.util.Date();
			java.sql.Date d2 = new java.sql.Date(d.getTime());

			/*
			System.out.println(ordered.getOrderId());
			System.out.println(ordered.getUserId());
			System.out.println(ordered.getItemId());
			System.out.println(ordered.getOrderQuantity());
			System.out.println(d2);
			*/

			stmt.setInt(1, orderHistory.getOrderId());
			stmt.setString(2, orderHistory.getUserId());
			stmt.setInt(3, orderHistory.getItemId());
			stmt.setDate(4, d2);
			stmt.setInt(5, orderHistory.getOrderQuantity());

			stmt.executeUpdate();

			//  終了処理
			stmt.close();

			}
			catch(SQLException e){

				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();

			}
			finally{}
	}
}