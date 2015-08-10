
package controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.ItemDAO;
import dao.PurchaseDAO;
import beans.Item;
import beans.User;

public class ItemPurchaseManager {

	private Connection connection = null;
	
    //引数をもたないコンストラクタ
	public ItemPurchaseManager(){
	}

	//商品一覧の取得
	public List<Item> getItemInfo(){
		
		List<Item> items = new ArrayList<Item>();
		
		PurchaseDAO purchaseDAO = new PurchaseDAO();
		items = purchaseDAO.selectItemAll();
		
		return items;
	}
	
	public void RegistPurchase(int item_id,int quant,User user,int price){
	
		PurchaseDAO purchaseDAO = new PurchaseDAO();
		
		purchaseDAO.RegistPurchase(item_id,quant,user,price);
		purchaseDAO.closeConnection(this.connection);

		this.connection = null;
		
	}
	
	public void CalculateItem(int item_id,int quant){
		
		PurchaseDAO purchaseDAO = new PurchaseDAO();
		
		this.connection = purchaseDAO.createConnection();
		purchaseDAO.CalculateItem(item_id,quant,connection);
		purchaseDAO.closeConnection(this.connection);

		this.connection = null;
		
	}
}
