
package controller;

/*****************************************************************************/
//		おすすめ機能に関するManager
/*****************************************************************************/

import java.util.ArrayList;
import java.util.List;

import dao.ItemDAO;
import dao.RecommendDAO;
import beans.Item;
import beans.Recommend;

public class RecommendManager {

	//おすすめをrecommendテーブルに格納する
	public String insertRecommend(Recommend recommend){
		
		String recommendRegistResult;
		
		//現在の店員がすでにおすすめを登録しているか確認する（結果はresultに格納）
		Recommend existingRecommend = new Recommend();
		RecommendDAO recommendDAO = new RecommendDAO();
		existingRecommend = recommendDAO.selectRecommendByUserId(recommend.getUserId());
		
		//すでに当該店員によっておすすめが登録されていれば、更新する。されていなければ新規に登録する
		if(existingRecommend != null)
		{
			System.out.println("Update.");
			recommendRegistResult = recommendDAO.updateRecommendByUserId( recommend.getItemId(), recommend.getUserId(), recommend.getDate() );
		}
		else
		{
			System.out.println("Insert.");
			recommendRegistResult = recommendDAO.insertRecommend( recommend.getItemId(), recommend.getUserId(), recommend.getDate() );
		}
		
		return recommendRegistResult;
	}
	
	//おすすめをrecommendテーブルから取得し、おすすめされている商品一覧を返す
	public List<String> getRecommendedItemName(){
		
		List<String> itemNameList = new ArrayList<String>();
		
		//おすすめテーブルから一覧を取得
		RecommendDAO recommendDAO = new RecommendDAO();
		itemNameList = recommendDAO.selectRecommendItemName();
		
		return itemNameList;
	}
	
	//商品一覧の取得
	public List<Item> getItemInfo(){
		
		List<Item> items = new ArrayList<Item>();
		
		ItemDAO itemDAO = new ItemDAO();
		items = itemDAO.selectItemAll();
		
		return items;
	}
}