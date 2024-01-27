package exceptions;

public class ItemNotInCatalogException extends Exception {
	private static final String MESSAGE = "Error: The item %s is not in the item catalog. Insure you select an item that is in stock.";
	
    public ItemNotInCatalogException(String message) {
        super(String.format(MESSAGE, message));
    }
}
