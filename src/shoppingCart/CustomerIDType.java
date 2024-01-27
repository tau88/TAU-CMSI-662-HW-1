package shoppingCart;

import exceptions.CustomerIDNotValidException;

public class CustomerIDType {
	private final String customerID;
	
	public CustomerIDType(String customerID) throws CustomerIDNotValidException {
		if (!customerIDCheckValid(customerID))
			throw new CustomerIDNotValidException(customerID);
		else
			this.customerID = customerID;
	}
	
		//All customer IDs must have the following form: 3 letters, 5 numbers, 2 letters, a dash, and finally an A or a Q
	public static boolean customerIDCheckValid(String checkingID) {
		int sizeGroupOne = 3;			//Should contain 3 letters
		int sizeGroupTwo = 5;			//Should contain 5 numbers
		int sizeGroupThr = 2;			//Should contain 2 letters
		int size_Total = sizeGroupOne + sizeGroupTwo + sizeGroupThr + 1 + 1;
		String regex = "[a-zA-Z]{" + sizeGroupOne + "}[0-9]{" + sizeGroupTwo + "}[a-zA-Z]{" + sizeGroupThr + "}-[QA]";
		
	    if (size_Total != checkingID.length())
	    	return false;
	    if (!checkingID.matches(regex))
			return false;
	    
	    return true;
	}

	public String toString() {
		return customerID.toString();
	}
}
