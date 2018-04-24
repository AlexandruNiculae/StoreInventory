package StoreInventoryMV.integration;

import StoreInventoryMV.controller.StoreController;
import StoreInventoryMV.repository.StoreRepository;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestABC extends TestCase {

    private StoreRepository repo;
    private StoreController con;

    public TestABC(String testName) {
        super(testName);
        repo = new StoreRepository("test2.txt", false);
        con = new StoreController(repo);
    }

    public static Test suite() {
        return new TestSuite(TestABC.class);
    }

    public void testIntegration() {
        con.addNewProduct(3, "a", "b", "c", 3);
        repo.saveToFile();

        StoreRepository idk = new StoreRepository("test2.txt", true);
        assertTrue(idk.getAllProducts().size() == 1);//A

        con.addNewProduct(4, "b", "b", "c", 3);
        con.addNewProduct(5, "c", "b", "c", 3);

        assertTrue(con.getProductsByCategory("b").size() == 3);//B

        System.out.println(con.getProductsByName("a"));
        assertTrue(con.getProductsByName("a").size() == 1);
        assertTrue(con.getAllProducts().size() == 3);//C
    }
}
