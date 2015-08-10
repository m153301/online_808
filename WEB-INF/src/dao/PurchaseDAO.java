package dao;

/*****************************************************************************/
//商品を扱うDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utility.DriverAccessor;
import beans.PurchaseHistory;
import beans.User;
import beans.Item;

import java.util.Calendar;

public class PurchaseDAO extends DriverAccessor{
	
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

	public void RegistPurchase(int item_id,int quant,User user,int price){

		try{
			Connection con = null;
			con = createConnection();
			
			//Recommendオブジェクトに入っているDateはjava.util.Dateなのでjava.sql.dateに変換 
			Date date = new Date();
 			Calendar cal = Calendar.getInstance(); 
 			cal.setTime(date); 
 			cal.set(Calendar.HOUR_OF_DAY, 0); 
 			cal.set(Calendar.MINUTE, 0); 
 			cal.set(Calendar.SECOND, 0); 
 			cal.set(Calendar.MILLISECOND, 0); 
 			java.sql.Date d2 = new java.sql.Date(cal.getTimeInMillis()); 

			System.out.println("Uid " + user.getUserId() + " Pid " + item_id + " Quan " + quant + " User " + user.getUserId() + " date " + date);
			//  SQLコマンド
			String sql = "insert into purchase_history (item_id,buy_date,purchase_quantity,user_id,item_price) values (?,?,?,?,?)";

			//  SQLコマンドの実行
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, item_id); 
			stmt.setDate(2, d2); 
			stmt.setInt(3, quant); 
			stmt.setString(4, user.getUserId());
			stmt.setInt(5, price);


		//  SQLコマンドのクエッションマークに値を、1番目から代入する

			//	データの登録を実行
			stmt.executeUpdate();

			//  終了処理
			stmt.close();

		}catch(SQLException e){

			//	エラーが発生した場合、原因を出力する
			e.printStackTrace();

		} finally {
		}
	}
	
	public void CalculateItem(int item_id,int num,Connection connection){
		try{

			String sql = "update item set item_stock = " + num + " where item_id = " + item_id;

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.executeUpdate();

			stmt.close();
		}catch(SQLException e){

			e.printStackTrace();

		} finally {

		}
	}
}
