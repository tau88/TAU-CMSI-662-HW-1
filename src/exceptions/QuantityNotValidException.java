package exceptions;

public class QuantityNotValidException extends Exception {
	private static final String MESSAGE = "Error: %s";
	
    public QuantityNotValidException(String message) {
        super(String.format(MESSAGE, message));
    }
}
