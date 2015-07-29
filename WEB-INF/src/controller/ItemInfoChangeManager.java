package controller;

import java.util.ArrayList;
import java.util.List;

import validator.ItemValidator;

public class ItemInfoChangeManager {

	public List<String> validator(String itemName, String itemPrice){
		ItemValidator itemValidator = new ItemValidator();
		List<String> errors = new ArrayList<String>();

		String itemNameError = itemValidator.validateItemName(itemName);
		String itemPriceError = itemValidator.validateItemPrice(itemPrice);

		if(itemNameError != null ) errors.add(itemValidator.validateItemName(itemName));
		if(itemPriceError != null ) errors.add(itemValidator.validateItemName(itemName));

		return errors;
	}

}
