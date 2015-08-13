
package controller;

/*****************************************************************************/
//		おすすめ機能に関するManager
/*****************************************************************************/

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dao.RecommendDAO;
import beans.Recommend;
import dao.ItemDAO;
import beans.Item;

public class RecommendManager {

	//おすすめをrecommendテーブルに格納する
	public String insertRecommend(Recommend recommend){
		
		String recommendRegistResult;
		
		//現在の店員がすでにおすすめを登録しているか確認する（結果はresultに格納）
		Recommend existingRecommend = new Recommend();
		RecommendDAO recommendDAO = new RecommendDAO();
		existingRecommend = recommendDAO.selectRecommendByUserId(recommend.getUserId());
		
		//RecommendオブジェクトのDateはjava.util.Dateなのでjava.sql.dateに変換
		Calendar cal = Calendar.getInstance();
		cal.setTime( recommend.getDate() );
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
		
		//すでに当該店員によっておすすめが登録されていれば、更新する。されていなければ新規に登録する
		if(existingRecommend != null)
		{
			System.out.println("Update.");
			recommendRegistResult = recommendDAO.updateRecommendByUserId( recommend.getItemId(), recommend.getUserId(), sqlDate );
		}
		else
		{
			System.out.println("Insert.");
			recommendRegistResult = recommendDAO.insertRecommend( recommend.getItemId(), recommend.getUserId(), sqlDate );
		}
		
		return recommendRegistResult;
	}
	
	//おすすめをrecommendテーブルから取得し、おすすめされている商品一覧を返す
	public List<String> selectRecommendItemName(){
		
		List<String> itemNameList = new ArrayList<String>();
		
		//おすすめテーブルから一覧を取得
		RecommendDAO recommendDAO = new RecommendDAO();
		itemNameList = recommendDAO.selectRecommendItemName();
		
		return itemNameList;
	}
	
	//おすすめを登録するために商品一覧を取得する
	public List<Item> selectItemAll(){
		
		List<Item> items = new ArrayList<Item>();
		
		//おすすめテーブルから一覧を取得
		ItemDAO itemDAO = new ItemDAO();
		items = itemDAO.selectItemAll();
		
		return items;
	}
}