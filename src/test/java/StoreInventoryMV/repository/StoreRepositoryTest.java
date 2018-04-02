package StoreInventoryMV.repository;

import StoreInventoryMV.model.Product;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class StoreRepositoryTest extends TestCase {

    public StoreRepositoryTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(StoreRepositoryTest.class);
    }


    public void testAddNewProduct() {
        StoreRepository repo = new StoreRepository("test.txt", false);

        Product p = new Product();
        Product pp = new Product(1, "a", "b", "c", 2);

        repo.addNewProduct(p);
        assertTrue("There should be 1 element in the repo!", repo.getAllProducts().size() == 1);

        repo.addNewProduct(pp);
        assertTrue("There should be 2 elements in the repo!", repo.getAllProducts().size() == 2);

        repo.addNewProduct(pp);
        assertTrue("There should be 2 elements in the repo!", repo.getAllProducts().size() == 2);
    }

    public void testHasProduct() {
        StoreRepository r1 = new StoreRepository("test.txt", false);
        StoreRepository r2 = new StoreRepository("test.txt", false);
        StoreRepository r3 = new StoreRepository("test.txt", false);

        Product p = new Product(1, "a", "b", "c", 2);

        r1.addNewProduct(p);

        for (int i = 0; i < 4; i++) {
            r1.addNewProduct(new Product());
            r2.addNewProduct(new Product());
        }

        r2.addNewProduct(p);

        for (int i = 0; i < 2; i++) {
            r3.addNewProduct(new Product());
        }
        r3.addNewProduct(p);
        for (int i = 0; i < 2; i++) {
            r3.addNewProduct(new Product());
        }

        assertTrue("Should be true", r1.hasProduct(p));
        assertTrue("Should be true", r2.hasProduct(p));
        assertTrue("Should be true", r3.hasProduct(p));
    }

    public void testGetProductEqualTo() {

        StoreRepository r1 = new StoreRepository("test.txt", false);
        StoreRepository r2 = new StoreRepository("test.txt", false);
        StoreRepository r3 = new StoreRepository("test.txt", false);

        Product p = new Product(1, "a", "b", "c", 2);
        Product pp = new Product(1, "b", "b", "c", 2);

        r1.addNewProduct(p);

        for (int i = 0; i < 4; i++) {
            r1.addNewProduct(new Product());
            r2.addNewProduct(new Product());
        }

        r2.addNewProduct(p);

        for (int i = 0; i < 2; i++) {
            r3.addNewProduct(new Product());
        }
        r3.addNewProduct(p);
        for (int i = 0; i < 2; i++) {
            r3.addNewProduct(new Product());
        }

        assertEquals("1 Should be equal", p, r1.getProductEqualTo(p));
        assertEquals("2 Should be equal", p, r2.getProductEqualTo(p));
        assertEquals("3 Should be equal", p, r3.getProductEqualTo(p));

        assertTrue("4 Should be equal", null == r1.getProductEqualTo(pp));
        assertTrue("5 Should be equal", null == r2.getProductEqualTo(pp));
        assertTrue("6 Should be equal", null == r3.getProductEqualTo(pp));
    }

    public void testGetProductsByCategory() {
        StoreRepository r1 = new StoreRepository("test.txt", false);

        r1.addNewProduct(new Product(1, "a", "b", "c", 2));
        r1.addNewProduct(new Product(1, "b", "b", "c", 2));
        r1.addNewProduct(new Product(1, "b", "d", "a", 2));
        r1.addNewProduct(new Product(1, "c", "e", "b", 2));

        assertEquals("Should be 2", 2, r1.getProductsByCategory("b").size());
        assertEquals("Should be 1", 1, r1.getProductsByCategory("d").size());
        assertEquals("Should be 1", 1, r1.getProductsByCategory("e").size());
    }

    public void testGetProductsByName() {
        StoreRepository r1 = new StoreRepository("test.txt", false);

        r1.addNewProduct(new Product(1, "a", "b", "b", 2));
        r1.addNewProduct(new Product(1, "b", "b", "b", 2));
        r1.addNewProduct(new Product(1, "b", "d", "a", 2));
        r1.addNewProduct(new Product(1, "c", "e", "c", 2));

        assertEquals("Should be 2", 2, r1.getProductsByName("b").size());
        assertEquals("Should be 1", 1, r1.getProductsByName("a").size());
        assertEquals("Should be 1", 1, r1.getProductsByName("c").size());
    }

    public void testGetProductsBySupplier() {
        StoreRepository r1 = new StoreRepository("test.txt", false);

        r1.addNewProduct(new Product(1, "a", "b", "b", 2));
        r1.addNewProduct(new Product(1, "b", "b", "b", 2));
        r1.addNewProduct(new Product(1, "b", "d", "a", 2));
        r1.addNewProduct(new Product(1, "c", "e", "c", 2));

        assertEquals("Should be 2", 2, r1.getProductsBySupplier("b").size());
        assertEquals("Should be 1", 1, r1.getProductsBySupplier("a").size());
        assertEquals("Should be 1", 1, r1.getProductsBySupplier("c").size());
    }

    public void testFileFunctions() {
        StoreRepository r1 = new StoreRepository("test.txt", false);

        r1.addNewProduct(new Product(1, "a", "b", "c", 2));
        r1.addNewProduct(new Product(1, "b", "b", "c", 2));
        r1.addNewProduct(new Product(1, "b", "d", "a", 2));
        r1.addNewProduct(new Product(1, "c", "e", "b", 2));

        r1.saveToFile();

        StoreRepository r2 = new StoreRepository("test.txt", true);

        assertEquals("Should be 4!", 4, r2.getAllProducts().size());

    }

}
