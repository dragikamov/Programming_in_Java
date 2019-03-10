/**
 * This class tests the creation of a list of book
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 17.03.2018
 */
package test;

import com.Book;
import com.Fiction;
import com.NonFiction;

public class BookArray {
    public static void main(String[] args) {
        final Book[] booklist = {
                new Fiction("Atonement"),
                new NonFiction("Storia Della Bruttezza"),
                new Fiction("2666"),
                new NonFiction("1453"),
                new Fiction("My Name is Red"),
                new NonFiction("Introduction to Algorithms"),
                new Fiction("The Story of the Stone"),
                new NonFiction("Core Java"),
                new Fiction("L'Etranger"),
                new NonFiction("Effective C++"),
        };

        for (Book b:booklist) {
            System.out.println(b.toString());
        }

    }
}
