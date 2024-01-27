package exceptions;

public class CostNotValidException extends Exception {
	private static final String MESSAGE = "Error: %s";
	
    public CostNotValidException(String message) {
        super(String.format(MESSAGE, message));
    }
}
