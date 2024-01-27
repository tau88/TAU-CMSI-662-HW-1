package shoppingCart;

import java.util.ArrayList;

import exceptions.CatalogItem_NotValidException;

public class Item_CatalogType {
	private static final int ITEMNAME_MAXLENGTH = 24;
	private static final int ITEMNAME_MINLENGTH = 3;
	
	private final ArrayList<String> item_Catalog;
	
	public Item_CatalogType(ArrayList<String> itemsToAdd) throws CatalogItem_NotValidException {
		ArrayList<String> tempItem_Catalog = new ArrayList<String>();
		
		for (int i = 0; i < itemsToAdd.size(); ++i) {
			String checkingName = itemsToAdd.get(i);
			String name_Valid = itemNameCheckValid(checkingName);
			
			if (!name_Valid.isEmpty())
				throw new CatalogItem_NotValidException(name_Valid);
			else if (isInArrayList(checkingName, tempItem_Catalog))
				throw new CatalogItem_NotValidException(checkingName + " is already in the catalog. Ensure there are no duplicates in the catalog.");				
			else
				tempItem_Catalog.add(checkingName);
		}
		
		this.item_Catalog = tempItem_Catalog;
	}
	
	private String itemNameCheckValid(String checkingName) {
		if (checkingName.length() < ITEMNAME_MINLENGTH)
			return "The name " + checkingName + " is too short. Minimum length allowed is " + ITEMNAME_MINLENGTH + " characters.";
		if (checkingName.length() > ITEMNAME_MAXLENGTH)
			return "The name " + checkingName + " is too long. Maximum length allowed is " + ITEMNAME_MAXLENGTH + " characters.";
			
		if (!checkingName.matches("^[a-zA-Z0-9][a-zA-Z0-9 ]*[a-zA-Z0-9]$"))
			return "The name " + checkingName + " contains invalid characters. Ensure there are only numbers, letters, and spaces, along with no leading or trailing spaces.";
		
		return "";
	}
	
		//Uses defensive copying
	public ArrayList<String> getItem_Catalog() {
		return new ArrayList<String>(item_Catalog);
	}
	
	private boolean isInArrayList(String checkingName, ArrayList<String> checkingList) {
		for (int i = 0; i < checkingList.size(); ++i) {
			if (checkingList.get(i).compareTo(checkingName) == 0)
				return true;
		}
		
		return false;
	}
	
	public boolean isInItem_Catalog(String checkingName) {
		return isInArrayList(checkingName, item_Catalog);
	}
	
	public String toString() {
		if (item_Catalog.size() == 0)
			return "Item Catalog is Empty!";

		String tempString = "Item Catalog: ";
		for (int i = 0; i < item_Catalog.size() - 1; ++i)
			tempString += item_Catalog.get(i) + ", ";
		tempString += "" + item_Catalog.get(item_Catalog.size() - 1);	//Append the last item without the separating comma (because it is the last item)
		
		return tempString;
	}
}
