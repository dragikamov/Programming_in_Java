/**
 * This class is a driver class to test BankAccount.java, SavingsAccount.java, CheckingAccount.java
 * It initializes two bank accounts: one SavingsAccount and one CheckingAccount. Instructions for the user
 * are printed on the console.
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 3000522, Sanjit Kunwar 20331648
 * @since 16.03.2017
 * */
package com.mypackage.test;

import com.mypackage.main.BankAccount;
import com.mypackage.main.CheckingAccount;
import com.mypackage.main.SavingsAccount;

import java.util.Scanner;

public class Bank {

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        CheckingAccount checkingAccount = new CheckingAccount();
        SavingsAccount savingsAccount = new SavingsAccount();

        while(true){

            System.out.println("Please write (s) if you want to interact \n" +
                    "with your savings account, write (c) if you want to \n" +
                    "interact with your checking account, (q) if you want \n" +
                    "to quit: ");

            String accountType = in.next();
            if(accountType.equals("s")){

                System.out.println("Welcome to your savings account!");
                boolean flag = true;
                while(flag){

                    System.out.println("Please write (d) to deposit, \n" +
                            "(w) to withdraw, (t) to transfer from your \n" +
                            "savings account to your checking account, (b) \n" +
                            "for balance, anything to quit: ");

                    String op = in.next();
                    String amount;
                    int cents;
                    switch (op){

                        case "d":

                            System.out.println("amount: ");
                            amount = in.next();
                            cents = convertToCents(amount);
                            if(cents == -1){
                                System.out.println("Invalid format: use this format $XX.XX");
                            } else if (cents == -2) {
                                System.out.println("Invalid amount: you cannot deposit more than one hundred " +
                                        "thousand dollars");
                            } else {
                                savingsAccount.deposit(cents);
                            }

                        break;
                        case "w":

                            System.out.println("amount: ");
                            amount = in.next();
                            cents = convertToCents(amount);
                            if(cents == -1){
                                System.out.println("Invalid format: try this $XX.XX");
                            } else if (cents == -2) {
                                System.out.println("Invalid amount: you cannot withdraw more than one hundred " +
                                        "thousand dollars");
                            } else {
                                if(savingsAccount.withdraw(cents)){
                                    System.out.println("Withdrawn " + cents + " cents");
                                } else {
                                    System.out.println("Insufficient funds.");
                                }
                            }

                        break;
                        case "t":

                            System.out.println("amount: ");
                            amount = in.next();
                            cents = convertToCents(amount);
                            if(cents == -1){
                                System.out.println("Invalid format: try this $XX.XX");
                            } else if (cents == -2) {
                                System.out.println("Invalid amount: you cannot transfer more than one hundred " +
                                        "thousand dollars");
                            } else {
                                if(BankAccount.transfer(cents, savingsAccount, checkingAccount)){
                                    System.out.println("Successful transfer.");
                                } else {
                                    System.out.println("Insufficient funds.");
                                }
                            }

                        break;
                        case "b":

                            int number = savingsAccount.balance();
                            System.out.println(convertToFormat(number));

                        break;
                        default: flag = false;
                    }
                }
            } else if(accountType.equals("c")){

                System.out.println("Welcome to your checking account!");
                boolean flag = true;
                while(flag){

                    System.out.println("Please write (d) to deposit, \n" +
                            "(w) to withdraw, (t) to transfer from your \n" +
                            "checking account to your savings account, (b) \n" +
                            "for balance, (c) to write a check, anything to quit: ");

                    String op = in.next();
                    String amount;
                    int cents;
                    switch (op){

                        case "d":

                            System.out.println("amount: ");
                            amount = in.next();
                            cents = convertToCents(amount);
                            if(cents == -1){
                                System.out.println("Invalid format: use this format $XX.XX");
                            } else if (cents == -2) {
                                System.out.println("Invalid amount: you cannot deposit more than one hundred " +
                                        "thousand dollars");
                            } else {
                                checkingAccount.deposit(cents);
                            }

                            break;
                        case "w":

                            System.out.println("amount: ");
                            amount = in.next();
                            cents = convertToCents(amount);
                            if(cents == -1){
                                System.out.println("Invalid format: try this $XX.XX");
                            } else if (cents == -2) {
                                System.out.println("Invalid amount: you cannot withdraw more than one hundred " +
                                        "thousand dollars");
                            } else {
                                if(checkingAccount.withdraw(cents)){
                                    System.out.println("Withdrawn " + cents + " cents");
                                } else {
                                    System.out.println("Insufficient funds.");
                                }
                            }

                            break;
                        case "t":

                            System.out.println("amount: ");
                            amount = in.next();
                            cents = convertToCents(amount);
                            if(cents == -1){
                                System.out.println("Invalid format: try this $XX.XX");
                            } else if (cents == -2) {
                                System.out.println("Invalid amount: you cannot transfer more than one hundred " +
                                        "thousand dollars");
                            } else {
                                if(BankAccount.transfer(cents, checkingAccount, savingsAccount)){
                                    System.out.println("Successful transfer.");
                                } else {
                                    System.out.println("Insufficient funds.");
                                }
                            }

                            break;
                        case "b":

                            int number = checkingAccount.balance();
                            System.out.println(convertToFormat(number));

                            break;
                        case "c":

                            System.out.println("amount: ");
                            amount = in.next();
                            cents = convertToCents(amount);
                            if(cents == -1){
                                System.out.println("Invalid format: try this $XX.XX");
                            } else if (cents == -2) {
                                System.out.println("Invalid amount: you cannot deposit more than one hundred " +
                                        "thousand dollars");
                            } else {
                                System.out.println(checkingAccount.writeCheck(cents));
                            }

                            break;
                        default: flag = false;
                    }
                }

            } else if(accountType.equals("q")){
                break;
            } else {
                System.out.println("Unknown Command\n");
            }
        }
    }

    /**
     * This method converts cents into String of format $XX.XX, where X is a digit
     * @param number the number of cents
     * @return String - the number of cents in format $XX.XX
     * */
    private static String convertToFormat(int number) {
        int cents = number%100;
        number /= 100;
        return "$" + String.valueOf(number) + "." + String.valueOf(cents);
    }



    /**
     * This method converts amount of money into cents.
     * @param amount the amount of money in type String
     * @return -1 if format is not valid, -2 if the amount is too huge. int the number of cents
     * */
    private static int convertToCents(String amount) {

        /* First check if the format of the amount is correct */
        if(!validAmount(amount)) {
            return -1;
        }

        /* Look for the dot (if there is one), to separate cents from dollars */
        int dotIdx = amount.indexOf('.');

        /* Calculate the number of cents */
        int numCents = 0;
        if(dotIdx != -1){
            for(int i = dotIdx+1; i < Math.min(dotIdx+3, amount.length()); i++){
                numCents = numCents*10 + amount.charAt(i) - '0';
            }
            if(numCents < 10){
                numCents *= 10;
            }
        }

        /* Calculate the number of dollars */
        if(dotIdx == -1){
            dotIdx = amount.length();
        }
        int numDollars = 0;
        for(int i = 0; i < dotIdx; i++){
            if(Character.isDigit(amount.charAt(i))){
                numDollars = numDollars*10 + amount.charAt(i) - '0';
            }
        }

        if (numDollars >= 100000) { return -2; }

        return numDollars*100 + numCents;
    }

    /**
     * This method verifies whether the amount entered has a valid format.
     * @param amount the amount entered
     * @return true if the format is valid, false otherwise
     * */
    private static boolean validAmount(String amount) {
        int numOfDots = countOccurrences(amount, '.');
        if(numOfDots > 1){
            return false;
        }
        int numOfDollarSigns = countOccurrences(amount, '$');
        if(numOfDollarSigns > 1){
            return false;
        }
        for(int i = 0; i < amount.length(); i++){
            if(amount.charAt(i) != '$' && amount.charAt(i) != '.' && !Character.isDigit(amount.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * This method count the occurrences of some character in a String
     * @param amount the String which we are looking at
     * @param c the character which occurrences we are counting
     * @return the number of occurrences of c in amount
     * */
    private static int countOccurrences(String amount, char c) {
        int cnt = 0;
        for(int i = 0; i < amount.length(); i++){
            if(amount.charAt(i) == c){
                cnt++;
            }
        }
        return cnt;
    }
}
