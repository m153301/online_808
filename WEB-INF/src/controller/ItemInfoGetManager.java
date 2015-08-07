package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ItemDAO;
import beans.Item;


public class ItemInfoGetManager {
	
	public List<Item> getItemInfo(){
		
		List<Item> items = new ArrayList<Item>();
		
		ItemDAO itemDAO = new ItemDAO();
		items = itemDAO.selectItemAll();
		
		return items;
	}
  
}
