/**
 * This class represents a checking account. It extends the abstract class BankAccount
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 3000522, Sanjit Kunwar 20331648
 * @since 15.03.2018
 * */
package com.mypackage.main;

import java.text.DecimalFormat;

public class CheckingAccount extends BankAccount{

    public CheckingAccount(){
        this.balance = 0;
    }

    /* Names of the values that are multiple of ten */
    private static final String[] tensNames = {
            "",
            " TEN",
            " TWENTY",
            " THIRTY",
            " FORTY",
            " FIFTY",
            " SIXTY",
            " SEVENTY",
            " EIGHTY",
            " NINETY"
    };

    /* Names of the numbers that range from 1 to 19 inclusive */
    private static final String[] numNames = {
            "",
            " ONE",
            " TWO",
            " THREE",
            " FOUR",
            " FIVE",
            " SIX",
            " SEVEN",
            " EIGHT",
            " NINE",
            " TEN",
            " ELEVEN",
            " TWELVE",
            " THIRTEED",
            " FOURTEEN",
            " FIFTEEN",
            " SIXTEEN",
            " SEVENTEEN",
            " EIGHTEEN",
            " NINETEEN"
    };

    /**
     * This method converts a number less than 1000 into words.
     * Reference: https://stackoverflow.com/questions/3911966/how-to-convert-number-to-words-in-java
     * @param number the number to be converted
     * @return String - the word representation of the number
     * */
    private String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20){
            soFar = numNames[number % 100];
            number /= 100;
        }
        else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " HUNDRED" + soFar;
    }

    /**
     * This method converts a number greater than 999, but less than billion. It
     * divides the number into three digits and resolves them using
     * convertLessThanOneThousand()
     * Reference: https://stackoverflow.com/questions/3911966/how-to-convert-number-to-words-in-java
     * @param number the number needed to be converted into words
     * @return String - the word representation of the number
     * */
    private String convert(long number) {
        if (number == 0) { return "zero"; }


        /* Masks the number into a string (like a bitmask) */
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        String snumber = df.format(number);

        /* Divides the number into four parts of three then
         * resolves them using converLessThanThousand */
        int billions = Integer.parseInt(snumber.substring(0,3));
        int millions  = Integer.parseInt(snumber.substring(3,6));
        int hundredThousands = Integer.parseInt(snumber.substring(6,9));
        int thousands = Integer.parseInt(snumber.substring(9,12));

        String tradBillions;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1 :
                tradBillions = convertLessThanOneThousand(billions)
                        + " billion ";
                break;
            default :
                tradBillions = convertLessThanOneThousand(billions)
                        + " billion ";
        }
        String result =  tradBillions;

        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            case 1 :
                tradMillions = convertLessThanOneThousand(millions)
                        + " million ";
                break;
            default :
                tradMillions = convertLessThanOneThousand(millions)
                        + " million ";
        }
        result =  result + tradMillions;

        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1 :
                tradHundredThousands = "one thousand ";
                break;
            default :
                tradHundredThousands =
                        convertLessThanOneThousand(hundredThousands)
                        + " thousand ";
        }
        result =  result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result =  result + tradThousand;

        /* Remove extra spaces */
        return result.replaceAll("^\\s+", "")
                .replaceAll("\\b\\s{2,}\\b", " ");
    }

    /**
     * Method which returns the word representation of the word.
     * Uses convertLessThanThousand() and convert() methods to do so.
     * @param cents the number needed to be converted
     * @return String - the word representation of the number
     * */
    private String dollarsToWords(int cents){

        /* First take care of the cents part */
        int numCents = ((cents/10)%10)*10 + cents%10;
        String returnValue = "";
        if(numCents != 0){
            returnValue = returnValue + String.valueOf(numCents);
            returnValue = returnValue + ((numCents == 1) ? " CENT." : " CENTS.");
        }

        /* Then take care of the dollars part */
        cents /= 100;
        String dollarPart = "";
        if(cents > 0){
            if(cents < 1000){
                dollarPart = convertLessThanOneThousand(cents);
            } else {
                dollarPart = convert(cents);
            }
        }
        dollarPart = dollarPart.trim();
        if(!dollarPart.equals("")){
            dollarPart = dollarPart + " DOLLARS";
            if(!returnValue.equals("")) {
                returnValue = " AND " + returnValue;
            }
        }
        return dollarPart + returnValue;
    }


    /**
     * This method is used to write a check. It withdraws the amount of cents from
     * the account and returns the number into word representation.
     * @param cents the number of cents that are withdrawn
     * @return String - the number representation of the number of cents. If there not sufficient funds, returns "INSIFFUCIENT FUNDS"
     * */
    public String writeCheck(int cents){

        boolean isEnough = withdraw(cents);
        if(!isEnough){
            return "INSUFFICIENT FUNDS.";
        } else {
            return dollarsToWords(cents);
        }
    }
}
