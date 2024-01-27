package shoppingCart;

import java.util.ArrayList;
import java.util.Arrays;

import exceptions.CatalogItem_NotValidException;
import exceptions.CostNotValidException;
import exceptions.CustomerIDNotValidException;
import exceptions.NameNotValidException;
import exceptions.QuantityNotValidException;

public class Main {
	
	public static void main(String[] args) throws CustomerIDNotValidException, CatalogItem_NotValidException, NameNotValidException, CostNotValidException, QuantityNotValidException {
		String customerID = "aaa11111bb-A";
    	CustomerIDType customer = new CustomerIDType(customerID);
    	
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType item_Catalog = new Item_CatalogType(itemList);
		
		ShoppingCart cart = new ShoppingCart(customer, item_Catalog);
		cart.addCartItem("item1", 3, 10);
		cart.addCartItem("item2", 5, 5);
		cart.addCartItem("item3", 1, 100);
		
		System.out.println("Inventory: " + cart.getCart_Inventory());
		System.out.println("Cart total: " + cart.getCartPriceTotal());
	}
}
