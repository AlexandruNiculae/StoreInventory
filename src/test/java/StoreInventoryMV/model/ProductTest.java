package StoreInventoryMV.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ProductTest extends TestCase {

    public ProductTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(ProductTest.class);
    }

    public void testEquals() {
        Product p = new Product(1, "a", "b", "c", 2);
        Product p1 = new Product(3, "d", "e", "f", 4);
        Product pp = p;

        assertTrue("Product should be different from null!", !p.equals(null));
        assertTrue("Product should be different from Object()!", p != new Object());
        assertTrue("Product should be different from Product()!", p != new Product());
        assertTrue("Products should be different from each other!", p != p1);
        assertTrue("1 Products should be equal!", p.equals(pp));

        pp = new Product(1, "a", "b", "c", 4);
        assertTrue("2 Products should be equal!", p.equals(pp));

        pp = new Product(1, "a", "b", "test", 4);
        assertTrue("Products should not be equal!", p != pp);

    }
}
