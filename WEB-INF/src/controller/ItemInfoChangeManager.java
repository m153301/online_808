package controller;

import java.util.ArrayList;
import java.util.List;

import validator.ItemValidator;

public class ItemInfoChangeManager {
	
	public List<String> validator(String itemName, String itemPrice){
		ItemValidator itemValidator = new ItemValidator();
		List<String> errors = new ArrayList<String>();

		errors.add(itemValidator.validateItemName(itemName));
		errors.add(itemValidator.validateItemPrice(itemPrice));
		
		return errors;
	}

}
