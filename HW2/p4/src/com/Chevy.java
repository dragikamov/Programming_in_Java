/**
 * This class implements abstract class Auto
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 17.03.2018
 */
package com;

public class Chevy extends Auto {
    public Chevy(){
        super();
        setPrice();
        setMake("Chevy");
    }

    public void setPrice() {
        price = 22000;
    }

}