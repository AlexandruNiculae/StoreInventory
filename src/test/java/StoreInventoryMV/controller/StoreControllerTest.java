package StoreInventoryMV.controller;

import StoreInventoryMV.repository.StoreRepository;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class StoreControllerTest extends TestCase {

    public StoreControllerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(StoreControllerTest.class);
    }

    public void testIsValid() {
        StoreRepository r = new StoreRepository("test.txt", false);
        StoreController c = new StoreController(r);

        assertFalse("1 Should not be valid!", c.isValid("???????&$%#$*^&(*&)(&&%%$^%#"));
        assertFalse("2 Should not be valid!", c.isValid(""));

        assertTrue("1 Should be valid!", c.isValid("Hello"));
        assertTrue("2 Should be valid!", c.isValid("WORLD"));
    }
}
