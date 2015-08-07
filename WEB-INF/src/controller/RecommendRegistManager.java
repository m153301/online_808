
package controller;

/*****************************************************************************/
//		おすすめ登録をするManager
/*****************************************************************************/

import dao.RecommendDAO;
import beans.Recommend;

public class RecommendRegistManager {

	//おすすめをrecommendテーブルに格納する
	public int insertRecommend(Recommend recommend){
		
		int x;
		
		RecommendDAO recommendDAO = new RecommendDAO();
		boolean isAlreadyInserted = recommendDAO.selectRecommendByUserId(recommend.getUserId());
		
		System.out.println(isAlreadyInserted);
		
		//すでに当該店員によっておすすめが登録されていれば、更新する。されていなければ新規に登録する
		if(isAlreadyInserted)
		{
			x = recommendDAO.updateRecommendByUserId( recommend.getItemId(), recommend.getUserId(), recommend.getDate() );
		}
		else{
			x = recommendDAO.insertRecommend( recommend.getItemId(), recommend.getUserId(), recommend.getDate() );
		}
		
		return x;
	}
}