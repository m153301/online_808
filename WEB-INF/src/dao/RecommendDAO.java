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
import java.util.Date;

import utility.DriverAccessor;
import beans.Recommend;

public class RecommendDAO extends DriverAccessor{


	//おすすめを新たに登録する
	public int insertRecommend( int itemId, String userId, Date date ){
		
		int x;
		try{
			//引数のDateはjava.util.Dateなのでjava.sql.dateに変換
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			java.sql.Date d2 = new java.sql.Date(cal.getTimeInMillis());
			
			//sql文の実行
			String sql = "insert into recommend values(?,?,?)";
			
			Connection con = null;
			con = createConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt( 1, itemId );
			stmt.setString( 2, userId );
			stmt.setDate( 3, d2 );
			
			stmt.executeUpdate();
			stmt.close();
			con = null;
			
			x = 1;
		}
		catch(SQLException e){
			
			if( e.toString().contains("Duplicate entry") && e.toString().contains("for key 'item_id") )
			{
				x = 0;
			}
			else
			{
				e.printStackTrace();
				x = -1;
			}
		}
		finally {

		}
		return x;
	}
	
	//おすすめを上書き登録する
	public int updateRecommendByUserId( int itemId, String userId, Date date ){
		
		int x;
		try{
			//Recommendオブジェクトに入っているDateはjava.util.Dateなのでjava.sql.dateに変換
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			java.sql.Date d2 = new java.sql.Date(cal.getTimeInMillis());
			
			//sql文の実行
			String sql = 
					"update recommend set item_id = ?, recommend_date = ? where user_id ='" + 
					userId + "';";
			
			Connection con = null;
			con = createConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt( 1, itemId );
			stmt.setDate( 2, d2 );
			
			stmt.executeUpdate();
			stmt.close();
			con = null;
			
			x = 1;
		}
		catch(SQLException e){
			
			if( e.toString().contains("Duplicate entry") && e.toString().contains("for key 'item_id") )
			{
				x = 0;
			}
			else
			{
				e.printStackTrace();
				x = -1;
			}
			
		}
		finally {
			
		}
		return x;
	}
	
	//すでに当該店員がおすすめを登録していないか判定する
	public boolean selectRecommendByUserId(String userId){
		
		Boolean isAlreadyExists = false;
		try{
			String sql = "select * from recommend where user_id='" + userId + "';";
			
			Connection con = null;
			con = createConnection();
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if( rs.next() )
			{
				System.out.println("@selectRecommendByUserId-----");
				System.out.println( rs.getInt( "item_id" ) );
				System.out.println( rs.getString( "user_id" ) );
				System.out.println( rs.getDate( "recommend_date" ) );
				System.out.println("-----------------------------");
				isAlreadyExists = true;
			}
			else
			{
				System.out.println("@selectRecommendByUserId-----");
				System.out.println("検索結果なし");
				System.out.println("-----------------------------");
				isAlreadyExists = false;
			}
			stmt.close();
			rs.close();
			con = null;
		}
		catch(SQLException e){
			
			e.printStackTrace();
			isAlreadyExists = false;
		}
		finally {
			
		}
		return isAlreadyExists;
	}
	
	//おすすめ一覧を取得する
	public ArrayList<Recommend> selectRecommendAll(){
		
		ArrayList<Recommend> recommendList = new ArrayList<Recommend>();
		
		try{
			String sql = "select * from recommend;";
			
			Connection con = null;
			con = createConnection();
			
			Statement stmt = con.createStatement();
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
			con = null;
		}
		catch(SQLException e){
			
			e.printStackTrace();
				
		}
		finally {
			
		}
		return recommendList;
	}
}
