package StoreInventoryMV.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Product {

	private int code;
	private String name;
	private String category;
	private String supplier;
	private int quantity;
	
	public Product(int code, String name, String category,String supplier, int quantity) {
		this.code = code;
		this.name = name;
		this.category = category;
		this.supplier = supplier;
		this.quantity = quantity;
	}

	public Product() {
		this.code = 0;
		this.name = null;
		this.category = null;
		this.supplier = null;
		this.quantity = -1;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void supply(int quantity) { this.quantity += quantity;}

    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Product))return false;

        Product otherProduct = (Product)other;
        if ( this.code != otherProduct.code ) return false;
        if (!this.name.equals(otherProduct.name)) return false;
        if (!this.category.equals(otherProduct.category)) return false;
        if (!this.supplier.equals(otherProduct.supplier)) return false;

        return true;
    }

    public String fileSaveString(){
        String s = "";
        s+= code + " ";
        s+= name + " ";
        s+= category + " ";
        s+= supplier + " ";
        s+= quantity + " ";

        return s;
    }

	@Override
	public String toString() {
		String s = "Product -- ";
		s+= "[" + this.code + "] - ";
		s+= "(" + this.supplier + ") ";
		s+= this.name + " : ";
		s+= this.category + " x";
		s+= this.quantity;

		return s;
	}

	
	

}
