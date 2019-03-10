/**
 * This program tests the creation of cars
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 17.03.2018
 */
package test;

import com.Chevy;
import com.Ford;

public class UseAuto {

    public static void main(String[] args) {
        Ford car1 = new Ford();
        System.out.println(car1.toString());
        Chevy car2 = new Chevy();
        System.out.println(car2.toString());
    }
}
