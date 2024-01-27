package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.CostNotValidException;
import exceptions.QuantityNotValidException;
import shoppingCart.CartItemType;

public class CartItemTypeTest {

	@Test
    public void testConstructCartItemGood() throws CostNotValidException, QuantityNotValidException {
		CartItemType testCartItem = new CartItemType("item1", 3, 10);
		
		assertEquals(testCartItem.toString(), "3 item1: each costs $10");
    }

	@Test
    public void testConstructCartItemBadCost() throws CostNotValidException, QuantityNotValidException {
		Exception exception = assertThrows(CostNotValidException.class, () -> {
			new CartItemType("item1", 3, -1);
        });
    	
    	String expectedMessage = "is too low, the minimum cost";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testConstructCartItemBadQuantity() throws CostNotValidException, QuantityNotValidException {
		Exception exception = assertThrows(QuantityNotValidException.class, () -> {
			new CartItemType("item1", 30, 10);
        });
    	
    	String expectedMessage = "is too high, the maximum quantity";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testGetName() throws CostNotValidException, QuantityNotValidException {
		CartItemType testCartItem = new CartItemType("item1", 3, 10);
		
		assertEquals(testCartItem.getItemName(), "item1");
    }

	@Test
    public void testGetQuantity() throws CostNotValidException, QuantityNotValidException {
		CartItemType testCartItem = new CartItemType("item1", 3, 10);
		
		assertEquals(testCartItem.getItemQuantity(), 3);
    }

	@Test
    public void testGetCosts() throws CostNotValidException, QuantityNotValidException {
		CartItemType testCartItem = new CartItemType("item1", 3, 10);
		
		assertEquals(testCartItem.getCostPer_Item(), 10);
    }

	@Test
    public void testSetQuantityValid() throws CostNotValidException, QuantityNotValidException {
		CartItemType testCartItem = new CartItemType("item1", 3, 10);
		testCartItem.setQuantity(15);
		
		assertEquals(testCartItem.getItemQuantity(), 15);
    }

	@Test
    public void testSetQuantityNotValidLow() throws CostNotValidException, QuantityNotValidException {
		CartItemType testCartItem = new CartItemType("item1", 3, 10);
		assertEquals(testCartItem.setQuantity(-1), "You cannot have less than 0 of this item.");
    }

	@Test
    public void testSetQuantityNotValidHigh() throws CostNotValidException, QuantityNotValidException {
		CartItemType testCartItem = new CartItemType("item1", 3, 10);
		assertEquals(testCartItem.setQuantity(30), "You cannot have more than 24 of this item.");
    }
}
