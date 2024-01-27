package exceptions;

public class CatalogItem_NotValidException extends Exception {
	private static final String MESSAGE = "Error: %s";
	
    public CatalogItem_NotValidException(String message) {
        super(String.format(MESSAGE, message));
    }
}
