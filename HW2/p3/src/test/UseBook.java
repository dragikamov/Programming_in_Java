/**
 * This program tests the creation of fiction and nonfiction book
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 17.03.2018
 */
package test;

import com.Fiction;
import com.NonFiction;

public class UseBook {
    public static void main(String[] args) {
        Fiction book1 = new Fiction("My name is Red");
        NonFiction book2 = new NonFiction("Principles of Mathematical Analysis");
        System.out.println(book1.toString());
        System.out.println(book2.toString());
    }
}
