package StoreInventoryMV.repository;

import StoreInventoryMV.model.Product;

import java.io.*;
import java.util.ArrayList;


public class StoreRepository {

	private ArrayList<Product> allProducts;
	private String file;

	public StoreRepository(String file, boolean load){
		this.allProducts = new ArrayList<Product>();
		this.file = file;
		if(load){
		    readFromFile();
        }
	}

	public Product addNewProduct(Product p){
	    if (this.hasProduct(p)){
            this.getProductEqualTo(p).supply(p.getQuantity());
            return this.getProductEqualTo(p);
        }
        else{
            this.allProducts.add(p);
            return p;
        }
    }

    public boolean hasProduct(Product p){
	    for(Product pp: this.allProducts){
	        if (pp.equals(p)){
	            return true;
            }
        }
        return false;
    }

    public Product getProductEqualTo(Product p){
        for(Product pp: this.allProducts){
            if (pp.equals(p)){
                return pp;
            }
        }

        return null;
    }

    public ArrayList<Product> getAllProducts() {
        return allProducts;
    }

    public ArrayList<Product> getProductsByCategory(String category) {
	    ArrayList<Product> res = new ArrayList<Product>();
	    for (Product p : this.allProducts){
	        if (p.getCategory().equals(category)){
	            res.add(p);
            }
        }

        return res;
    }

    public ArrayList<Product> getProductsByName(String name) {
        ArrayList<Product> res = new ArrayList<Product>();
        for (Product p : this.allProducts){
            if (p.getName().contains(name)){
                res.add(p);
            }
        }

        return res;
    }

    public ArrayList<Product> getProductsBySupplier(String supplier) {
        ArrayList<Product> res = new ArrayList<Product>();
        for (Product p : this.allProducts){
            if (p.getSupplier().equals(supplier)){
                res.add(p);
            }
        }

        return res;
    }

    public void saveToFile(){
        try(FileWriter fw = new FileWriter(this.file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            for(Product p : this.allProducts){
                out.println(p.fileSaveString());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] pre = line.split(" ");
                if(pre.length == 5){
                    int c = Integer.parseInt(pre[0]);
                    int q = Integer.parseInt(pre[4]);
                    Product p = new Product(c,pre[1],pre[2],pre[3],q);
                    this.addNewProduct(p);
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
