package shoppingCart;

import java.util.ArrayList;
import java.util.Arrays;

import exceptions.CatalogItem_NotValidException;
import exceptions.CustomerIDNotValidException;

public class Main {
	
	public static void main(String[] args) throws CustomerIDNotValidException, CatalogItem_NotValidException {
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType test_Catalog = new Item_CatalogType(itemList);
		
		System.out.print(test_Catalog.toString());
	}
}
