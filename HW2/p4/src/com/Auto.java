/**
 * This abstract class include two fields: maker and price
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 17.03.2018
 */
package com;

public abstract class Auto {
    protected double price;
    protected String maker;

    public Auto(){}

    public abstract void setPrice();

    public double getPrice() { return price; }

    public String getMake() { return maker; }

    public void setMake(String s){ maker = s; }

    @Override
    public String toString() {
        return "Auto{" +
                "price=" + price +
                ", maker='" + maker + '\'' +
                '}';
    }
}
