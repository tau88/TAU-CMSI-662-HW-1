package exceptions;

public class ItemNotInCartException extends Exception {
	private static final String MESSAGE = "Error: %s is not in the shopping cart.";
	
    public ItemNotInCartException(String message) {
        super(String.format(MESSAGE, message));
    }
}
