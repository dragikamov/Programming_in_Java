/**
 * This abstract class represents a bank account. It stores the balance in cents
 * to avoid incorrectness of floating point decimals
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 3000522, Sanjit Kunwar 20331648
 * @since 15.03.2018
 * */
package com.mypackage.main;

public abstract class BankAccount {

    protected int balance;

    /**
     * This method deposits the amount of cents into the balance
     * @param cents amount of cents to be added into the balance
     * */
    public void deposit(int cents){
        balance += cents;
    }

    /**
     * This method withdraws the amount of cents from the account balance
     * @param cents the amount of cents to be withdrawn from the bank account
     * @return boolean - true if the account balance has enough money to withdraw, false otherwise
     * */
    public boolean withdraw(int cents){
        if(cents > this.balance){
            return  false;
        }
        balance -= cents;
        return true;
    }

    /**
     * This method returns the account balance in cents
     * @return int - the account balance in cents
     * */
    public int balance(){
        return this.balance;
    }

    /**
     * This method transfers cents from one account to another
     * @param cents the amount of cents needed to be transferred
     * @param fromAccount the bank account from which the cents are withdrawn
     * @param toAccount the bank account to which the cents are deposited
     * @return boolean - true if there are enough money to transfer, false otherwise
     * */
    public static boolean transfer(int cents, BankAccount fromAccount,
                                   BankAccount toAccount){

        boolean isEnough = fromAccount.withdraw(cents);
        if(isEnough){
            toAccount.deposit(cents);
        } else {
            return false;
        }

        return true;
    }
}
