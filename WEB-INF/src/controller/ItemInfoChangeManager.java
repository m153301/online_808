package controller;

import java.util.ArrayList;
import java.util.List;

import validator.ItemValidator;
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
	
	public List<String> validateItemInfoChangeListForm(String itemId){
		List<String> errors = new ArrayList<String>();
		ItemValidator itemValidator = new ItemValidator();
		String itemIdError = itemValidator.validateItemId(itemId);
		
		if(itemIdError != null) errors.add(itemIdError);

		return errors;
	}
	
	public List<String> validateItemInfoChangeForm(String itemName, String itemPrice){
		ItemValidator itemValidator = new ItemValidator();
		List<String> errors = new ArrayList<String>();

		String itemNameError = itemValidator.validateItemName(itemName);
		String itemPriceError = itemValidator.validateItemPrice(itemPrice);

		if(itemNameError != null ) errors.add(itemNameError);
		if(itemPriceError != null ) errors.add(itemPriceError);

		return errors;	
	}

}
