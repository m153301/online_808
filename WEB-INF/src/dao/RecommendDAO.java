package dao;

/*****************************************************************************/
//おすすめを扱うDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import utility.DriverAccessor;
import beans.Recommend;

public class RecommendDAO extends DriverAccessor{


	//おすすめを新たに登録する
	public String insertRecommend( int itemId, String userId, Date date ){
		
		String recommendRegistResult;
		try{
			
			//sql文の実行
			String sql = "insert into recommend values(?,?,?)";
			
			Connection con = null;
			con = createConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt( 1, itemId );
			stmt.setString( 2, userId );
			stmt.setDate( 3, date );
			
			stmt.executeUpdate();
			stmt.close();
			con = null;
			
			recommendRegistResult = "登録が完了しました！";
		}
		catch(SQLException e){
			
			if( e.toString().contains("Duplicate entry") && e.toString().contains("for key 'item_id") )
			{
				recommendRegistResult = "その商品はすでに別の店員によって登録されていますm(_ _)m";
			}
			else
			{
				e.printStackTrace();
				recommendRegistResult = "おすすめ登録に失敗しましたm(_ _)m";
			}
		}
		finally {

		}
		return recommendRegistResult;
	}
	
	//おすすめを上書き登録する
	public String updateRecommendByUserId( int itemId, String userId, Date date ){
		
		String recommendRegistResult;
		try{
			//sql文の実行
			String sql = 
					"update recommend set item_id = ?, recommend_date = ? where user_id ='" + 
					userId + "';";
			
			Connection con = null;
			con = createConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt( 1, itemId );
			stmt.setDate( 2, date );
			
			stmt.executeUpdate();
			stmt.close();
			con = null;
			
			recommendRegistResult = "登録が完了しました！";
		}
		catch(SQLException e){
			
			if( e.toString().contains("Duplicate entry") && e.toString().contains("for key 'item_id") )
			{
				recommendRegistResult = "その商品はすでに別の店員によって登録されていますm(_ _)m";
			}
			else
			{
				e.printStackTrace();
				recommendRegistResult = "おすすめ登録に失敗しましたm(_ _)m";
			}
			
		}
		finally {
			
		}
		return recommendRegistResult;
	}
	
	//UserIdからおすすめを取得する
	public Recommend selectRecommendByUserId(String userId){
		
		Recommend recommend = new Recommend();
		try{
			String sql = "select * from recommend where user_id='" + userId + "';";
			
			Connection con = null;
			con = createConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			if( rs.next() )
			{
				System.out.println("@selectRecommendByUserId-----");
				System.out.println( rs.getInt( "item_id" ) );
				System.out.println( rs.getString( "user_id" ) );
				System.out.println( rs.getDate( "recommend_date" ) );
				System.out.println("-----------------------------");
				
				recommend.setItemId( rs.getInt( "item_id" ) );
				recommend.setUserId( rs.getString( "user_id" ) );
				recommend.setDate( rs.getDate( "recommend_date" ) );
				
			}
			else
			{
				System.out.println("@selectRecommendByUserId-----");
				System.out.println("検索結果なし");
				System.out.println("-----------------------------");
				recommend = null;
			}
			stmt.close();
			rs.close();
			con = null;
		}
		catch(SQLException e){
			
			e.printStackTrace();
			recommend = null;
			
		}
		finally {
			
		}
		return recommend;
	}
	
	//おすすめされた商品名一覧を取得する
	public List<String> selectRecommendItemName(){
		
		List<String> itemNameList = new ArrayList<String>();
		
		try{
			String sql = "SELECT * FROM recommend LEFT JOIN item using (item_id);";
			
			Connection con = null;
			con = createConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while( rs.next() )
			{
				itemNameList.add( rs.getString( "item.item_name" ) );
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
		return itemNameList;
	}
}
