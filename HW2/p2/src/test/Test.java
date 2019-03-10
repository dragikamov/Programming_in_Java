/**
 * This test class will check whether there are exactly 16 instance of class
 * FederalState.
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 17.03.2018
 */
package test;

import com.FederalState;

public class Test {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            System.out.println(FederalState.getInstance());
        }

    }
}
