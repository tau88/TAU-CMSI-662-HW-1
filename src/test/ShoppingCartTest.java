package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import exceptions.CatalogItem_NotValidException;
import exceptions.CostNotValidException;
import exceptions.CustomerIDNotValidException;
import exceptions.ItemNotInCartException;
import exceptions.NameNotValidException;
import exceptions.QuantityNotValidException;
import shoppingCart.CustomerIDType;
import shoppingCart.Item_CatalogType;
import shoppingCart.ShoppingCart;

public class ShoppingCartTest {

	@Test
    public void testGetOwnerID() throws CustomerIDNotValidException, CatalogItem_NotValidException {
		String customerID = "aaa11111bb-A";
    	CustomerIDType customer = new CustomerIDType(customerID);
    	
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType item_Catalog = new Item_CatalogType(itemList);
		
		ShoppingCart testCart = new ShoppingCart(customer, item_Catalog);
		
		assertEquals(testCart.getOwner_ID(), customerID);
    }

	@Test
    public void testAddToCartValid() throws CustomerIDNotValidException, CatalogItem_NotValidException, NameNotValidException, CostNotValidException, QuantityNotValidException {
		String customerID = "aaa11111bb-A";
    	CustomerIDType customer = new CustomerIDType(customerID);
    	
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType item_Catalog = new Item_CatalogType(itemList);
		
		ShoppingCart testCart = new ShoppingCart(customer, item_Catalog);
		testCart.addCartItem("item1", 3, 10);
		
		assertTrue(testCart.cartItemExists("item1") != -1);
    }

	@Test
    public void testAddToCartNotValidName() throws CustomerIDNotValidException, CatalogItem_NotValidException, NameNotValidException, CostNotValidException, QuantityNotValidException {
		String customerID = "aaa11111bb-A";
    	CustomerIDType customer = new CustomerIDType(customerID);
    	
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType item_Catalog = new Item_CatalogType(itemList);
		
		ShoppingCart testCart = new ShoppingCart(customer, item_Catalog);
		
		Exception exception = assertThrows(CatalogItem_NotValidException.class, () -> {
			testCart.addCartItem("it", 3, 10);
        });
    	
    	String expectedMessage = " is not in the Catalog. Ensure ";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testAddToCartNotValidQuan() throws CustomerIDNotValidException, CatalogItem_NotValidException, NameNotValidException, CostNotValidException, QuantityNotValidException {
		String customerID = "aaa11111bb-A";
    	CustomerIDType customer = new CustomerIDType(customerID);
    	
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType item_Catalog = new Item_CatalogType(itemList);
		
		ShoppingCart testCart = new ShoppingCart(customer, item_Catalog);
		
		Exception exception = assertThrows(QuantityNotValidException.class, () -> {
			testCart.addCartItem("item1", -1, 10);
        });
    	
    	String expectedMessage = "is too low, the minimum qu";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testAddToCartNotValidPrice() throws CustomerIDNotValidException, CatalogItem_NotValidException, NameNotValidException, CostNotValidException, QuantityNotValidException {
		String customerID = "aaa11111bb-A";
    	CustomerIDType customer = new CustomerIDType(customerID);
    	
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType item_Catalog = new Item_CatalogType(itemList);
		
		ShoppingCart testCart = new ShoppingCart(customer, item_Catalog);
		
		Exception exception = assertThrows(CostNotValidException.class, () -> {
			testCart.addCartItem("item1", 1, -10);
        });
    	
    	String expectedMessage = "is too low, the minimum co";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testCheckItemInCartNo() throws CustomerIDNotValidException, CatalogItem_NotValidException, NameNotValidException, CostNotValidException, QuantityNotValidException {
		String customerID = "aaa11111bb-A";
    	CustomerIDType customer = new CustomerIDType(customerID);
    	
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType item_Catalog = new Item_CatalogType(itemList);
		
		ShoppingCart testCart = new ShoppingCart(customer, item_Catalog);
		testCart.addCartItem("item1", 3, 10);
		
		assertTrue(testCart.cartItemExists("item99") == -1);
    }

	@Test
    public void testRemoveFromCartExists() throws CustomerIDNotValidException, CatalogItem_NotValidException, NameNotValidException, CostNotValidException, QuantityNotValidException, ItemNotInCartException {
		String customerID = "aaa11111bb-A";
    	CustomerIDType customer = new CustomerIDType(customerID);
    	
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType item_Catalog = new Item_CatalogType(itemList);
		
		ShoppingCart testCart = new ShoppingCart(customer, item_Catalog);
		testCart.addCartItem("item1", 3, 10);
		
		testCart.removeCartItem("item1");
		assertTrue(testCart.cartItemExists("item1") == -1);
    }

	@Test
    public void testRemoveFromCartNotExists() throws CustomerIDNotValidException, CatalogItem_NotValidException, NameNotValidException, CostNotValidException, QuantityNotValidException, ItemNotInCartException {
		String customerID = "aaa11111bb-A";
    	CustomerIDType customer = new CustomerIDType(customerID);
    	
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType item_Catalog = new Item_CatalogType(itemList);
		
		ShoppingCart testCart = new ShoppingCart(customer, item_Catalog);
		testCart.addCartItem("item1", 3, 10);

		Exception exception = assertThrows(ItemNotInCartException.class, () -> {
			testCart.removeCartItem("item99");
        });
    	
    	String expectedMessage = "is not in the shopping cart";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
	
	@Test
    public void testChangeItemQuantityValid() throws CustomerIDNotValidException, CatalogItem_NotValidException, NameNotValidException, CostNotValidException, QuantityNotValidException, ItemNotInCartException {
		String customerID = "aaa11111bb-A";
    	CustomerIDType customer = new CustomerIDType(customerID);
    	
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType item_Catalog = new Item_CatalogType(itemList);
		
		ShoppingCart testCart = new ShoppingCart(customer, item_Catalog);
		testCart.addCartItem("item1", 3, 10);
		
		testCart.changeCartItemQuantity("item1", 20);
		assertTrue(testCart.getCartItem("item1").getItemQuantity() == 20);
    }

	@Test
    public void testChangeItemQuantityNotValid() throws CustomerIDNotValidException, CatalogItem_NotValidException, NameNotValidException, CostNotValidException, QuantityNotValidException, ItemNotInCartException {
		String customerID = "aaa11111bb-A";
    	CustomerIDType customer = new CustomerIDType(customerID);
    	
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType item_Catalog = new Item_CatalogType(itemList);
		
		ShoppingCart testCart = new ShoppingCart(customer, item_Catalog);
		testCart.addCartItem("item1", 3, 10);

		Exception exception = assertThrows(QuantityNotValidException.class, () -> {
			testCart.changeCartItemQuantity("item1", 30);
        });
    	
    	String expectedMessage = "cannot have more than";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testCartTotals() throws CustomerIDNotValidException, CatalogItem_NotValidException, NameNotValidException, CostNotValidException, QuantityNotValidException {
		String customerID = "aaa11111bb-A";
    	CustomerIDType customer = new CustomerIDType(customerID);
    	
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType item_Catalog = new Item_CatalogType(itemList);
		
		ShoppingCart testCart = new ShoppingCart(customer, item_Catalog);
		testCart.addCartItem("item1", 3, 10);
		testCart.addCartItem("item2", 5, 5);
		testCart.addCartItem("item3", 1, 100);
		
		assertTrue(testCart.getCartPriceTotal() == 155);
    }
}
