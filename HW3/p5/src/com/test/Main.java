package com.test;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.main.Record;

/**
 * This class represents a test class for Record.java.
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 30.03.2018
 */
public class Main{

    private static String instruction = "To add a recrod type (a), "
    + "to lookup a record type (l) " 
    + "and to edit a record type (e), " 
    + "type anything else to exit and save.";

    private static Scanner in = new Scanner(System.in);

    /**
     * This method adds a new record instance into the database
     * @param data a TreeMap which contains all the entries from the database
     */
    public static void add(TreeMap<String, Record> data){
        Record record = new Record();
        record.setProductName();
        record.setPrice();
        record.setQuantity();
        data.put(record.getProductName(), record);
    }

    /**
     * A method which looks up an entry in the database
     * @param data a TreeMap which contains all the entries from the database
     */
    public static void lookup(TreeMap<String, Record> data){
        System.out.println("Please enter the product name: ");
        String productName = in.nextLine();
        if(data.containsKey(productName)){
            System.out.println(data.get(productName));
        } else {
            System.err.println("Record not found");
        }
    }

    /**
     * A method which allows the user to edit an entry's price
     * @param data a TreeMap which contains all the entries from the database
     */
    public static void edit(TreeMap<String, Record> data){
        System.out.println("Please enter the product name:");
        String productName = in.nextLine();
        if(data.containsKey(productName)){
            Record record = data.get(productName);
            data.remove(productName);
            record.setPrice();
            data.put(record.getProductName(), record);
        } else {
            System.err.println("Record not found");
        }
    }

    /**
     * A method which saves all the new entries from the TreeMap into 
     * a binary file. 
     * @param data the TreeMap whose entries are saved into a binary file
     */
    public static void save(TreeMap<String, Record> data){

        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream("db.dat"));
            for(Map.Entry<String, Record> entry : data.entrySet()){
                Record record = entry.getValue();
                os.writeObject(record);
            }
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        ObjectInputStream is = null;
        TreeMap<String, Record> data = new TreeMap<String, Record>();
        try {
            is = new ObjectInputStream(new FileInputStream("db.dat"));
            boolean flag = true;
            while(flag){
                Record record = (Record)is.readObject();
                if(record != null){
                    data.put(record.getProductName(), record);
                } else {
                    flag = false;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            // e.printStackTrace();
            System.out.println("DEBUG: end of file.");
        }

        boolean flag = true;
        while(flag){

            System.out.println(instruction);
            String op = in.nextLine();
            switch(op){
                case "a":
                    add(data);
                    break;
                case "l":
                    lookup(data);
                    break;
                case "e":
                    edit(data);
                    break;
                default:
                    save(data);
                    flag = false;
            }
        }
    }
}