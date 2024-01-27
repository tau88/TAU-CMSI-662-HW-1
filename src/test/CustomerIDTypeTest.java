package test;

import static org.junit.Assert.*;
import org.junit.Test;

import exceptions.CustomerIDNotValidException;
import shoppingCart.CustomerIDType;

public class CustomerIDTypeTest {

	@Test
    public void testCorrectIDs() throws CustomerIDNotValidException {
		String testName1 = "aaa11111bb-A";
		String testName2 = "abc12345de-A";
		String testName3 = "abc12345de-Q";
		String testName4 = "uis30526xj-Q";
    	CustomerIDType customer1 = new CustomerIDType(testName1);
    	CustomerIDType customer2 = new CustomerIDType(testName2);
    	CustomerIDType customer3 = new CustomerIDType(testName3);
    	CustomerIDType customer4 = new CustomerIDType(testName4);

        assertEquals(testName1, customer1.toString());
        assertEquals(testName2, customer2.toString());
        assertEquals(testName3, customer3.toString());
        assertEquals(testName4, customer4.toString());
    }

	@Test
    public void testExtraLetter() throws CustomerIDNotValidException {
		String testName = "abcA12345de-A";
		
    	Exception exception = assertThrows(CustomerIDNotValidException.class, () -> {
    		new CustomerIDType(testName);
        });
    	
    	String expectedMessage = testName + " is not a valid customer ID.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testTooFewLetters() throws CustomerIDNotValidException {
		String testName = "ab12345de-A";
		
    	Exception exception = assertThrows(CustomerIDNotValidException.class, () -> {
    		new CustomerIDType(testName);
        });
    	
    	String expectedMessage = testName + " is not a valid customer ID.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testExtraNumber() throws CustomerIDNotValidException {
		String testName = "abc112345de-A";
		
    	Exception exception = assertThrows(CustomerIDNotValidException.class, () -> {
    		new CustomerIDType(testName);
        });
    	
    	String expectedMessage = testName + " is not a valid customer ID.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testTooFewNumbers() throws CustomerIDNotValidException {
		String testName = "abc2345de-A";
		
    	Exception exception = assertThrows(CustomerIDNotValidException.class, () -> {
    		new CustomerIDType(testName);
        });
    	
    	String expectedMessage = testName + " is not a valid customer ID.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testNotAOrQAtEnd() throws CustomerIDNotValidException {
		String testName = "aaa11111bb-D";
		
    	Exception exception = assertThrows(CustomerIDNotValidException.class, () -> {
    		new CustomerIDType(testName);
        });
    	
    	String expectedMessage = testName + " is not a valid customer ID.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

	@Test
    public void testNotCapitalAOrQAtEnd() throws CustomerIDNotValidException {
		String testName = "aaa11111bb-a";
		
    	Exception exception = assertThrows(CustomerIDNotValidException.class, () -> {
    		new CustomerIDType(testName);
        });
    	
    	String expectedMessage = testName + " is not a valid customer ID.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
