
//　自分が格納されているフォルダ名
package dao;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utility.DriverAccessor;

public class OrderHistoryDAO extends DriverAccessor{

	//発注した商品を格納する
	public void insertOrderHistory(int orderId, String userId, int itemId, int orderQuantity, java.util.Date date){

		Connection con = null;
		con = createConnection();

		try{

			//  SQLコマンド
			String sql = "insert into order_history values(?, ?, ?, ?, ?)";

			//  SQLのコマンドを実行する
			PreparedStatement stmt = con.prepareStatement(sql);

			java.sql.Date d2 = new java.sql.Date(date.getTime());

			stmt.setInt(1, orderId);
			stmt.setString(2, userId);
			stmt.setInt(3, itemId);
			stmt.setDate(4, d2);
			stmt.setInt(5, orderQuantity);

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
}