package StoreInventoryMV.ui;


import StoreInventoryMV.controller.StoreController;
import StoreInventoryMV.model.Product;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.setOut;

/**
 * Created by Vlad on 17-Mar-16.
 */
public class StoreUI {
    private StoreController con;
    private boolean running;

    public StoreUI(StoreController con){
        this.con = con;
        this.running = true;
    }

    public void printMenu(){
        String s = "----- Menu: -----\n";
        s += "\t[1] - Add new Product \n";
        s += "\t[2] - Show products by CATEGORY \n";
        s += "\t[3] - Show products by NAME \n";
        s += "\t[4] - Show ALL products \n";
        s += "\t[0] - Exit \n";

        System.out.println(s);
    }

    public void printList(ArrayList<Product> list){
        System.out.println("-----------------------------");
        for(Product p : list){
            System.out.println("\t" + p.toString());
        }
        System.out.println("-----------------------------\n");
    }

    public int readInt(){
        try {
            Scanner in = new Scanner(System.in);
            return in.nextInt();
        } catch (Exception e){
            return -1;
        }
    }

    public String readString(){
        try {
            Scanner in = new Scanner(System.in);
            return in.next();
        } catch (Exception e){
            return "";
        }
    }


    public void addNewProduct(){
        System.out.println("----- Adding new Product -----");
        System.out.print("Code: ");
        int c = readInt();
        System.out.println();

        System.out.print("Name: ");
        String n = readString();
        System.out.println();

        System.out.print("Category: ");
        String cat = readString();
        System.out.println();

        System.out.print("Supplier: ");
        String s = readString();
        System.out.println();

        System.out.print("Quantity: ");
        int q = readInt();
        System.out.println();

        try {
            this.con.addNewProduct(c,n,cat,s,q);
            System.out.println("----- Success -----");
        } catch (Exception e){
            System.out.println("!!!!! Error !!!!!");
            System.out.println(e.getMessage());
            System.out.println("!!!!! Error !!!!!");
        }
    }

    public void displayByCategory(){
        try{
            System.out.print("Category: ");
            String cat = readString();
            System.out.println();
            printList(this.con.getProductsByCategory(cat));
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public void displayByName(){
        try{
            System.out.print("Name: ");
            String name = readString();
            System.out.println();
            printList(this.con.getProductsByName(name));
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public void displayAll(){
        printList(this.con.getAllProducts());
    }


    public void executeCommand(int c){
        switch (c){
            case 0:
                this.running = false;
                break;

            case 1:
                addNewProduct();
                break;

            case 2:
                displayByCategory();
                break;

            case 3:
                displayByName();
                break;

            case 4:
                displayAll();
                break;

            default:
                System.out.println("Invalid command!");
                break;
        }
    }

    public void run(){
        while ( this.running ){
            printMenu();
            System.out.print("> ");
            int c = readInt();
            executeCommand(c);
        }
    }
}
