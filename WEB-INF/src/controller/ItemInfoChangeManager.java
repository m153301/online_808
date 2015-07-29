package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ItemDAO;
import beans.Item;

public class ItemInfoChangeManager {

	public ItemInfoChangeManager(){}
	
	public List<Item> selectItemAll(){
		ItemDAO itemDAO = new ItemDAO();
		List<Item> items = new ArrayList<Item>();
		items = itemDAO.selectItemAll();
		return items;
	}
	
	public void updateItemById(int itemId, String itemName, int itemPrice){
		ItemDAO itemDAO = new ItemDAO();
		itemDAO.updateItemById(itemId, itemName, itemPrice);
	}

}
