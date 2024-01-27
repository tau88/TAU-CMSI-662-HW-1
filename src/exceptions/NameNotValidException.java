package exceptions;

public class NameNotValidException extends Exception {
	private static final String MESSAGE = "Error: %s";
	
    public NameNotValidException(String message) {
        super(String.format(MESSAGE, message));
    }
}
