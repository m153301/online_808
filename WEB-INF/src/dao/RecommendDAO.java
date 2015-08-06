package dao;

/*****************************************************************************/
//おすすめを扱うDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import utility.DriverAccessor;
import beans.Recommend;

public class RecommendDAO extends DriverAccessor{


	//おすすめを新たに登録する
	public void insertRecommend(Recommend recommend, Connection connection){
		try{

			//Recommendオブジェクトに入っているDateはjava.util.Dateなのでjava.sql.dateに変換
			java.util.Date d = recommend.getDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			java.sql.Date d2 = new java.sql.Date(cal.getTimeInMillis());
			
			//sql文の実行
			String sql = "insert into recommend values(?,?,?)";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, recommend.getItemId());
			stmt.setString(2, recommend.getUserId());
			stmt.setDate(3, d2);

			stmt.executeUpdate();

			stmt.close();
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		finally {

		}
	}
	
	//おすすめを上書き登録する
	public void updateRecommendByUserId(Recommend recommend, Connection connection){
		try{
			
			//Recommendオブジェクトに入っているDateはjava.util.Dateなのでjava.sql.dateに変換
			java.util.Date d = recommend.getDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			java.sql.Date d2 = new java.sql.Date(cal.getTimeInMillis());
			
			//sql文の実行
			String sql = 
					"update recommend set item_id = ?, recommend_date = ? where user_id ='" + 
					recommend.getUserId() + "';";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, recommend.getItemId());
			stmt.setDate(2, d2);
			
			stmt.executeUpdate();
			stmt.close();
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		finally {
			
		}
	}
	
	//すでに当該店員がおすすめを登録していないか判定する
	public boolean selectRecommendByUserId(String userId, Connection connection){
		
		try{
			String sql = "select * from recommend where user_id='" + userId + "';";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.next();
			
			System.out.println("@selectRecommendByUserId-----");
			System.out.println( rs.getInt( "item_id" ) );
			System.out.println( rs.getString( "user_id" ) );
			System.out.println( rs.getDate( "recommend_date" ) );
			System.out.println("-----------------------------");
			
			stmt.close();
			rs.close();
		}
		catch(SQLException e){
			
				e.printStackTrace();
				return false;
		}
		finally {
			
		}
		return true;
	}
	
	//おすすめ一覧を取得する
	public ArrayList<Recommend> selectRecommendAll(Connection connection){
		
		ArrayList<Recommend> recommendList = new ArrayList<Recommend>();
		
		try{
			String sql = "select * from recommend;";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while( rs.next() )
			{

				Recommend recommend = new Recommend( 
						rs.getInt( "item_id" ), 
						rs.getString( "user_id" ),
						rs.getDate( "recommend_date" ) );
				recommendList.add( recommend );
			}

			stmt.close();
			rs.close();
		}
		catch(SQLException e){
			
				e.printStackTrace();
				
		}
		finally {
			
		}
		return recommendList;
	}
}
