
package controller;

/*****************************************************************************/
//		おすすめ登録をするManager
/*****************************************************************************/


import java.sql.Connection;

import dao.RecommendDAO;
import beans.Recommend;

public class RecommendRegistManager {

	private Connection connection = null;

	//おすすめをrecommendテーブルに格納する
	public void setRecommend(Recommend recommend){
		
		RecommendDAO recommendDAO = new RecommendDAO();
		
		this.connection = recommendDAO.createConnection();
		boolean isAlreadyInserted = recommendDAO.selectRecommendByUserId(recommend.getUserId(), connection);
		recommendDAO.closeConnection(this.connection);
		
		System.out.println(isAlreadyInserted);
		
		//すでに当該店員によっておすすめが登録されていれば、更新する。されていなければ新規に登録する
		if(isAlreadyInserted)
		{
			this.connection = recommendDAO.createConnection();
			recommendDAO.updateRecommendByUserId(recommend, connection);
			recommendDAO.closeConnection(this.connection);
		}
		else{
			this.connection = recommendDAO.createConnection();
			recommendDAO.insertRecommend(recommend, connection);
			recommendDAO.closeConnection(this.connection);
		}

		this.connection = null;
	}
}