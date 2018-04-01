package StoreInventoryMV.controller;


import StoreInventoryMV.model.Product;
import StoreInventoryMV.repository.StoreRepository;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.util.ArrayList;

public class StoreController {

    private StoreRepository repo;

    public StoreController(StoreRepository repo){
        this.repo = repo;
    }

    public boolean isValid(String s){
        if (s.length() == 0 || s == null ){
            return false;
        }

        String valid = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_";
        for(int i=0; i< s.length(); i++){
            if (valid.indexOf(s.charAt(i)) < 0){
                return false;
            }
        }

        return true;
    }

    public void addNewProduct(int code, String name, String category, String supplier, int quantity) throws ValueException{
        if (code <= 0 )
            throw new ValueException("The code of a product cannot be negative or 0!");

        if (!isValid(name))
            throw  new ValueException("The string: " + name + " is invalid!");

        if (!isValid(category))
            throw  new ValueException("The string: " + category + " is invalid!");

        if (!isValid(supplier))
            throw  new ValueException("The string: " + supplier + " is invalid!");

        if (quantity < 0 )
            throw new ValueException("The quantity of a product cannot be negative!");

        this.repo.addNewProduct(new Product(code,name,category,supplier,quantity));
    }

    public ArrayList<Product> getAllProducts(){
        return this.repo.getAllProducts();
    }

    public ArrayList<Product> getProductsByName(String name) throws ValueException{
        if (!isValid(name))
            throw  new ValueException("The string: " + name + " is invalid!");

        return this.repo.getProductsByName(name);
    }

    public ArrayList<Product> getProductsByCategory(String category) throws ValueException{
        if (!isValid(category))
            throw  new ValueException("The string: " + category + " is invalid!");

        return this.repo.getProductsByCategory(category);
    }

    public ArrayList<Product> getProdcutsBySupplier(String supplier) throws ValueException{
        if (!isValid(supplier))
            throw  new ValueException("The string: " + supplier + " is invalid!");

        return this.repo.getProductsBySupplier(supplier);
    }
}
