package com.main;

import java.io.Serializable;
import java.util.Scanner;

/**
 * This class represents a record. It stores the record's name, price and quantity. The product name
 * should be stored in an array of characters (maximum 30). Since {@code String} is an array of characters,
 * we store it in an array, but keep track of its length.
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 30.03.2018
 */
public class Record implements Serializable{

    private String productName;
    private double price;
    private int quantity;
    private static Scanner in = new Scanner(System.in);

    /* Constructors */

    /**
     * Default constructor. Sets all the member variables to 0 or ""
     */
    public Record(){
        this.productName = "";
        this.price = 0;
        this.quantity = 0;
    }

    /**
     * Parametrized constructor
     * @param productName the name of the record
     * @param price the price of the record
     * @param quantity the quantity of the record
     */
    public Record(String productName, double price, int quantity){
        if(productName.length() > 30){
            productName = productName.substring(0, 30);
        }
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    /* Setters and Getters */

    /**
     * @return the name of the record
     */
    public String getProductName(){
        return this.productName;
    }

    /**
     * @return the price of the record
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * @return the quantity of the record
     */
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * Sets the record name accordin to the parameter
     * @param productName the new name of the product
     */
    public void setProductName(String productName){
        if(productName.length() > 30){
            productName = productName.substring(0, 30);
        }
        this.productName = productName;
    }

    /**
     * Sets the record price accordin to the parameter
     * @param price the new price of the product
     */
    public void setPrice(double price){
        this.price = price;
    }

    /**
     * Sets the record quantity accordin to the parameter
     * @param quantity the new quantity of the product
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * Sets the record name according to the user's input 
     * from console
     */
    public void setProductName(){
        System.out.println("Enter product name:");
        this.productName = in.nextLine();
        if(this.productName.length() > 30){
            this.productName = this.productName.substring(0, 30);
        }
    }

    /**
     * Sets the record price according to the user's input 
     * from console
     */
    public void setPrice(){
        System.out.println("Enter price:");
        this.price = in.nextDouble();
    }

    /**
     * Sets the record quantity according to the user's input 
     * from console
     */
    public void setQuantity(){
        System.out.println("Enter quantity");
        this.quantity = in.nextInt();
    }

    /* Service and helper methods */

    /**
     * Method which is used for printing the object with sysout
     * @return String representation of the name
     */
    @Override
    public String toString() {
        return "Product name: " + this.productName 
        + "\nPrice: " + this.price 
        + "\nQuantity: " + this.quantity;
    }

    /**
     * Overriden equals method which is used to see whether two
     * objects are equal
     * @param obj the object which is compared to {@code this}
     * @return {@code true} if the objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }

        if(!(obj instanceof Record)){
            return false;
        }

        Record other = (Record)obj;
        return this.productName.equals(other.productName) 
        && this.price == other.price 
        && this.quantity == other.quantity;
    }
}