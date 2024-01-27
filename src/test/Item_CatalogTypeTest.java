package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import exceptions.CatalogItem_NotValidException;
import exceptions.CustomerIDNotValidException;
import shoppingCart.CustomerIDType;
import shoppingCart.Item_CatalogType;

public class Item_CatalogTypeTest {

	@Test
    public void testConstructorCorrectItemCatalog() throws CatalogItem_NotValidException {
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType test_Catalog = new Item_CatalogType(itemList);
		
		assertEquals(test_Catalog.toString(), "Item Catalog: item1, item2, item3");
    }

	@Test
    public void testConstructorNoItemCatalog() throws CatalogItem_NotValidException {
		ArrayList<String> itemList = new ArrayList<String>();
		Item_CatalogType test_Catalog = new Item_CatalogType(itemList);
		
		assertEquals(test_Catalog.toString(), "Item Catalog is Empty!");
    }

	@Test
    public void testConstructorOneItemCatalog() throws CatalogItem_NotValidException {
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1"));
		Item_CatalogType test_Catalog = new Item_CatalogType(itemList);
		
		assertEquals(test_Catalog.toString(), "Item Catalog: item1");
    }

	@Test
    public void testConstructorMoreItemsCatalog() throws CatalogItem_NotValidException {
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3", "item4", "item5", "item6", "item5000000"));
		Item_CatalogType test_Catalog = new Item_CatalogType(itemList);
		
		assertEquals(test_Catalog.toString(), "Item Catalog: item1, item2, item3, item4, item5, item6, item5000000");
    }

	@Test
    public void testConstructorIncorrectItemCatalogTooLong() throws CatalogItem_NotValidException {
		String wrongName = "itemthisisverylongthisisverylongthisisverylongthisisverylong";
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", wrongName));
		
		Exception exception = assertThrows(CatalogItem_NotValidException.class, () -> {
			new Item_CatalogType(itemList);
        });
    	
    	String expectedMessage = wrongName + " is too long. Maximum length";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testConstructorIncorrectItemCatalogTooShort() throws CatalogItem_NotValidException {
		String wrongName = "no";
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", wrongName));
		
		Exception exception = assertThrows(CatalogItem_NotValidException.class, () -> {
			new Item_CatalogType(itemList);
        });
    	
    	String expectedMessage = wrongName + " is too short. Minimum length";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testConstructorIncorrectItemCatalogSpecialChar() throws CatalogItem_NotValidException {
		String wrongName = "item-";
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", wrongName));
		
		Exception exception = assertThrows(CatalogItem_NotValidException.class, () -> {
			new Item_CatalogType(itemList);
        });
    	
    	String expectedMessage = wrongName + " contains invalid characters. Ensure";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testConstructorIncorrectItemCatalogLeadingSpace() throws CatalogItem_NotValidException {
		String wrongName = " item2";
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", wrongName));
		
		Exception exception = assertThrows(CatalogItem_NotValidException.class, () -> {
			new Item_CatalogType(itemList);
        });
    	
    	String expectedMessage = wrongName + " contains invalid characters. Ensure";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testConstructorDuplicateCatalogItem() throws CatalogItem_NotValidException {
		String wrongName = "item1";
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", wrongName));
		
		Exception exception = assertThrows(CatalogItem_NotValidException.class, () -> {
			new Item_CatalogType(itemList);
        });
    	
    	String expectedMessage = wrongName + " is already in the catalog.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testIsItemInCatalogYes()  throws CatalogItem_NotValidException {
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType test_Catalog = new Item_CatalogType(itemList);

		assertTrue(test_Catalog.isInItem_Catalog("item1"));
		assertTrue(test_Catalog.isInItem_Catalog("item2"));
		assertTrue(test_Catalog.isInItem_Catalog("item3"));
    }

	@Test
    public void testIsItemInCatalogNo()  throws CatalogItem_NotValidException {
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1", "item2", "item3"));
		Item_CatalogType test_Catalog = new Item_CatalogType(itemList);

		assertFalse(test_Catalog.isInItem_Catalog("ITEM1"));
		assertFalse(test_Catalog.isInItem_Catalog("item20"));
		assertFalse(test_Catalog.isInItem_Catalog("item 3"));
		assertFalse(test_Catalog.isInItem_Catalog("item3 "));
		assertFalse(test_Catalog.isInItem_Catalog("item4"));
    }

	@Test
    public void testGetCatalogItem()  throws CatalogItem_NotValidException {
		ArrayList<String> itemList = new ArrayList<String>(Arrays.asList("item1"));
		Item_CatalogType test_Catalog = new Item_CatalogType(itemList);

		ArrayList<String> itemList2 = new ArrayList<String>();
		itemList2.add("item1");
		Item_CatalogType test_Catalog2 = new Item_CatalogType(itemList2);
		assertEquals(test_Catalog.getItem_Catalog(), test_Catalog2.getItem_Catalog());
    }
}
