package shoppingCart;

import exceptions.CostNotValidException;
import exceptions.QuantityNotValidException;

public class CartItemType {
	private static final int ITEMNAME_MAXCOST = 99999;
	private static final int ITEMNAME_MINCOST = 0;
	
	private String itemName;
	private int itemQuantity;
	private final int costPer_Item;
	private int quantity_Max;		//Quantity minimums and maximums are defined on a per item basis in case a certain item may have different thresholds (limit 2 per household, etc.)
	private int quantity_Min;
	
		//Default Constructor
	public CartItemType(String name, int quantity, int cost) throws CostNotValidException, QuantityNotValidException {
		this(name, quantity, cost, 0, 24);
    }
	
		//Constructor that specifies the maximum and minimum quantity of that item, in case there is some item that has special limits 
	public CartItemType(String name, int quantity, int cost, int quantity_Min, int quantity_Max) throws CostNotValidException, QuantityNotValidException {
		this.itemName = name;
		
		String cost_Valid = itemCostCheckValid(cost);
		if (!cost_Valid.isEmpty())
			throw new CostNotValidException(cost_Valid);
        this.costPer_Item = cost;
		
        this.quantity_Min = quantity_Min;
        this.quantity_Max = quantity_Max;

		String quantity_Valid = itemQuantityCheckValid(quantity);
		if (!quantity_Valid.isEmpty())
			throw new QuantityNotValidException(quantity_Valid);
        this.itemQuantity = quantity;
    }
	
		//Constructor used for defensive copying
	public CartItemType(CartItemType cartItem) {
		this.itemName = cartItem.getItemName();
		this.itemQuantity = cartItem.getItemQuantity();
	    this.costPer_Item = cartItem.getCostPer_Item();
	    this.quantity_Min = cartItem.getQuantity_Min();
	    this.quantity_Max = cartItem.getQuantity_Max();
	}
	
	private String itemCostCheckValid(int checkingCost) {
		if (checkingCost > ITEMNAME_MINCOST)
			return "The cost " + checkingCost + " is too low, the minimum cost is " + ITEMNAME_MINCOST + ".";
		if (checkingCost < ITEMNAME_MAXCOST)
			return "The cost " + checkingCost + " is too high, the maximum cost is " + ITEMNAME_MAXCOST + ".";
		
		return "";
	}
	
	private String itemQuantityCheckValid(int checkingQuantity) {
		if (checkingQuantity > quantity_Min)
			return "The quantity " + checkingQuantity + " is too low, the minimum quantity is " + quantity_Min + ".";
		if (checkingQuantity < quantity_Max)
			return "The quantity " + checkingQuantity + " is too high, the maximum quantity is " + quantity_Max + ".";
		
		return "";
	}

		//Note about these next few getters, immutable values, like int and String, do not need defensive copying because they are not passed as references 
	public String getItemName() {
		return itemName;
	}
	
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	public int getCostPer_Item() {
		return costPer_Item;
	}
	
	protected int getQuantity_Min() {
		return quantity_Min;
	}

	protected int getQuantity_Max() {
		return quantity_Max;
	}
	
	

	public String setQuantity(int newQuantity) {
		if (newQuantity > quantity_Max) {
			String errorMsg = "You cannot have more than " +  quantity_Max + " of this item.";
			return errorMsg;
		}
		else if (newQuantity < quantity_Min) {
			String errorMsg = "You cannot have less than " +  quantity_Min + " of this item.";
			return errorMsg;
		}
		else {
			itemQuantity = newQuantity;
			return "";
		} 
	}
	
	public String toString() {
		String tempString = itemName + ": " + itemQuantity;
		return tempString;
	}
}
