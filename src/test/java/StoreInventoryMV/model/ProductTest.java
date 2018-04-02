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

    public void testGetters() {
        Product p = new Product(1, "a", "b", "c", 2);

        assertTrue("Code should be 1!", p.getCode() == 1);
        assertTrue("Name should be a!", p.getName().equals("a"));
        assertTrue("Category should be b!", p.getCategory().equals("b"));
        assertTrue("Supplier should be c!", p.getSupplier().equals("c"));
        assertTrue("Quantity should be 2!", p.getQuantity() == 2);

        p = new Product();

        assertTrue("Code should be 0!", p.getCode() == 0);
        assertTrue("Name should be null!", p.getName() == null);
        assertTrue("Category should be null!", p.getCategory() == null);
        assertTrue("Supplier should be null!", p.getSupplier() == null);
        assertTrue("Quantity should be -1!", p.getQuantity() == -1);

    }

    public void testSetters() {
        Product p = new Product();

        p.setCode(1);
        p.setName("a");
        p.setCategory("b");
        p.setSupplier("c");
        p.setQuantity(2);

        assertTrue("Code should be 1!", p.getCode() == 1);
        assertTrue("Name should be a!", p.getName().equals("a"));
        assertTrue("Category should be b!", p.getCategory().equals("b"));
        assertTrue("Supplier should be c!", p.getSupplier().equals("c"));
        assertTrue("Quantity should be 2!", p.getQuantity() == 2);
    }
}
