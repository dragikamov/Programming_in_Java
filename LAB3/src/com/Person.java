/**
 * This class stores the information of a person
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunmar 20331648
 * @since 20.03.2018
 */
package com;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable{
    private String name;
    private String address;
    private String email;
    private long phoneNumber;
    private String website;
    private String note;
    private static Scanner in = new Scanner(System.in); //static field would not be serializable.

    public Person() {}

    public String getName() {
        return name;
    }

    public void setName() {
        System.out.println("Enter the name: ");
        String n;
        while ( (n = in.nextLine()).equals("") ) {
            System.out.println("Name cannot be empty! ");
            System.out.println("Enter the name: ");
        }
        this.name = n;
    }

    public String getAddress() { return this.address; }

    public void setAddress() {
        System.out.println("Enter the address: ");
        String a = in.nextLine();
        this.address = a;
    }

    public String getEmail() { return this.email; }

    public void setEmail() {
        System.out.println("Enter the email: ");
        String e = in.nextLine();
        this.email = e;
    }

    public long getPhoneNumber() { return this.phoneNumber; }

    public void setPhoneNumber() {
        System.out.println("Enter the phone number: ");
        String p = in.nextLine();
        long number = 0;
        try{
            number = Long.parseLong(p);
        } catch (NumberFormatException e){
            System.out.println("The phone number is not valid! This field will remain 0!");
        }
        this.phoneNumber = number;
    }

    public String getWebsite() { return this.website; }

    public void setWebsite() {
        System.out.println("Enter the website: ");
        String w = in.nextLine();
        this.website = w;
    }

    public String getNote() { return this.note; }

    public void setNote() {
        System.out.println("Enter the note: ");
        String note = in.nextLine();
        this.note = note;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", website='" + website + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}

