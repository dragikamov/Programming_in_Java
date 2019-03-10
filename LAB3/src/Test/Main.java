/**
 * This class is the application of of personal address book
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunmar 20331648
 * @since 20.03.2018
 */
package Test;

import com.Person;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static final String instruction1 = "Press n for creating new address book, a for reading a " +
            "existing address book, anything else for quit. ";

    static final String instruction2 = "Press a for adding an entry, l for look up an entry, " +
            "e for edit an entry, d for delete, s for save the address book, h for help, anything " +
            "else for exiting the program.";

    private static Scanner in = new Scanner(System.in);

    static void setInfo(Person p) {
        p.setName();
        p.setAddress();
        p.setEmail();
        p.setNote();
        p.setPhoneNumber();
        p.setWebsite();
    }

    /**
     * add an entry to the address book
     * @param addressbook
     */
    static void add(TreeMap<String, Person> addressbook) {
        Person p = new Person();
        setInfo(p);
        addressbook.put(p.getName(), p);
    }

    /**
     * look up an entry by entering the name
     * @param addressbook
     */
    static void lookup(TreeMap<String, Person> addressbook) {
        System.out.println("Enter the name: ");
        String name = in.next();
        if (addressbook.containsKey(name)) {
            System.out.println(addressbook.get(name).toString());
        } else {
            System.out.println("Name not found!");
        }
    }

    /**
     * edit an entry if exists
     * @param addressbook
     */
    static void edit(TreeMap<String, Person> addressbook) {
        System.out.println("Whose information do you want to change? Enter the name: ");
        String name = in.next();
        if (addressbook.containsKey(name)) {
            setInfo(addressbook.get(name));
        } else {
            System.out.println("Name not found!");
        }
    }

    /**
     * delete an entry to the address book
     * @param addressbook
     */
    static void delete(TreeMap<String, Person> addressbook) {
        System.out.println("Which entry do you want to delete? Enter the name: ");
        String name = in.next();
        if (addressbook.containsKey(name)) {
            addressbook.remove(addressbook.get(name));
        } else {
            System.out.println("Name not found!");
        }
    }

    /**
     * save the file to a user specified location if it is a new address book
     * else, save the file from the original place
     * @param addressBook
     * @param filename
     */
    static void save(TreeMap<String, Person> addressBook, String filename) {
        if (filename.equals("")) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            }
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            filename = fileChooser.getSelectedFile().getName();
        }
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(addressBook);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "";
        System.out.println(instruction1);
        TreeMap<String, Person> addressBook = new TreeMap<String, Person>();
        String c = in.next();
        switch (c) {
            case "n":
                TreeMap<String, Person> newaddressBook = new TreeMap<String, Person>();
                break;
            case "a":
                System.out.println("Enter the name of your file");
                filename = in.next();
                try {
                    FileInputStream fis = new FileInputStream(filename);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    addressBook = (TreeMap<String, Person>) ois.readObject();
                } catch (FileNotFoundException fnfe) {
                    fnfe.printStackTrace();
                    System.exit(1);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    System.exit(1);
                } catch (ClassNotFoundException cne) {
                    cne.printStackTrace();
                    System.exit(1);
                }
                break;
            default:
                System.exit(0);
        }

        System.out.println("Loading the address book...");
        System.out.println(instruction2);
        while (true) {
            c = in.next();
            switch (c) {
                case "a":
                    add(addressBook);
                    break;
                case "l":
                    lookup(addressBook);
                    break;
                case "e":
                    edit(addressBook);
                    break;
                case "d":
                    delete(addressBook);
                    break;
                case "s":
                    save(addressBook, filename);
                    break;
                case "h":
                    System.out.println(instruction2);
                    break;
                default:
                    System.exit(0);
            }
            System.out.println(instruction2);
        }
    }

}

