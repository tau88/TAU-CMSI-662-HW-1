package shoppingCart;

import java.util.ArrayList;
import java.util.UUID;

import exceptions.CostNotValidException;
import exceptions.ItemNotInCartException;
import exceptions.CatalogItem_NotValidException;
import exceptions.NameNotValidException;
import exceptions.QuantityNotValidException;

public class ShoppingCart {
	private final CustomerIDType owner_ID;
	private final UUID cartID;
	private ArrayList<CartItemType> cart_Inventory;
	private final Item_CatalogType item_Catalog;
	
	public ShoppingCart(CustomerIDType customerID, Item_CatalogType item_Catalog) {
		this.owner_ID = customerID;
        this.cartID = UUID.randomUUID();
        this.cart_Inventory = new ArrayList<CartItemType>();
        this.item_Catalog = item_Catalog;
    }
	
	public String getOwner_ID() {
		return owner_ID.toString();
	}
	
	public String getCartID() {
		return cartID.toString();
	}

		//Returns the index of the item if it is in the cart. If the item doesn't exist, return -1.
	public int cartItemExists(String itemName) {
		for (int i = 0; i < cart_Inventory.size(); ++i) {
			if (cart_Inventory.get(i).getItemName().compareTo(itemName) == 0) {
				return i;
			}
		}
		
		return -1;
	}
	
		//This getter uses defensive copying
	public CartItemType getCartItem(String itemName) throws ItemNotInCartException {
		int cartItem_Index = cartItemExists(itemName);
		if (cartItem_Index != -1) {
			return new CartItemType(cart_Inventory.get(cartItem_Index));
		}
		
		throw new ItemNotInCartException(itemName);
	}
	
	public void addCartItem(String itemName, int itemQuantity, int itemCost) throws CatalogItem_NotValidException, NameNotValidException, CostNotValidException, QuantityNotValidException {
		if (item_Catalog.isInItem_Catalog(itemName)) {
			int cartItem_Index = cartItemExists(itemName);
			if (cartItem_Index == -1) {
				cart_Inventory.add(new CartItemType(itemName, itemQuantity, itemCost));
			}			
		} else {
			throw new CatalogItem_NotValidException(itemName);
		}
	}
	
	public void removeCartItem(String itemName) {
		int cartItem_Index = cartItemExists(itemName);
		if (cartItem_Index != -1) {
			cart_Inventory.remove(cart_Inventory.get(cartItem_Index));
		}
	}
	
	public String changeCartItemQuantity(CartItemType itemName, int new_Quantity) {
		String errorMsg = cart_Inventory.get(cart_Inventory.indexOf(itemName)).setQuantity(new_Quantity);
		return errorMsg;
	}
	
	public int getCartPriceTotal() throws ArithmeticException {
		int currentPriceTotal = 0;
		
		for (int i = 0; i < cart_Inventory.size(); ++i) {
			int itemPriceTotal = cart_Inventory.get(i).getCostPer_Item() * cart_Inventory.get(i).getItemQuantity();
			if (itemPriceTotal > 0)
				currentPriceTotal += itemPriceTotal;
			else
				throw new ArithmeticException("Either the item price or quantity is negative, something catastrophic occurred.");
		}
		
		return currentPriceTotal;
	}
	
	public String getCart_Inventory() {
		return cart_Inventory.toString();
	}
}