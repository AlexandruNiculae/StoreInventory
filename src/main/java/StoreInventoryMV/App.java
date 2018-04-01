package StoreInventoryMV;


import StoreInventoryMV.controller.StoreController;
import StoreInventoryMV.repository.StoreRepository;
import StoreInventoryMV.ui.StoreUI;

public class App {

	public static void main(String[] args){
		StoreRepository repo = new StoreRepository("products.txt",true);
        StoreController con = new StoreController(repo);
        StoreUI ui = new StoreUI(con);

        ui.run();
        repo.saveToFile();
	}

}
