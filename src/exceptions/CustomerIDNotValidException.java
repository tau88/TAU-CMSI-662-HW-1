package exceptions;

public class CustomerIDNotValidException extends Exception {
	private static final String MESSAGE = "Error: %s is not a valid customer ID.";
	
    public CustomerIDNotValidException(String id) {
        super(String.format(MESSAGE, id));
    }
}
