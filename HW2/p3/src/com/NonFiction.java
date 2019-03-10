/**
 * This class implements abstract class Book
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 17.03.2018
 */
package com;

public class NonFiction extends Book {
    public NonFiction(String t){
        super(t);
        setPrice();
    }

    public void setPrice() {
        price = 37.99;
    }

}
