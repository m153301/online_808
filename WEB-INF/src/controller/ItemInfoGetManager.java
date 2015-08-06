package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ItemDAO;
import beans.Item;


public class ItemInfoGetManager {
	
	private Connection connection;
	
	public ArrayList<Item> getItemInfo(){
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		ItemDAO itemDAO = new ItemDAO();
		
		this.connection = itemDAO.createConnection();
		
		itemList = itemDAO.selectItemAll(connection);
		
		itemDAO.closeConnection(this.connection);
		
		this.connection = null;
		
		return itemList;
	}
  
}
