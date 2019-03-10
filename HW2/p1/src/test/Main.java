/**
 * This class is a driver class to test the implementation of Movie, Movie sorter class
 * It contains an immutable movie list. It will print out the list three times: sorted by
 * title, by year and by score;
 *
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 17.03.2018
 */
package test;

import core.implementation.Movie;
import core.MovieServices;
import core.implementation.MovieSorter;

public class Main {
    static final Movie[] MOVIES = {
            new Movie("Star Wars", 1977, 8.8),
            new Movie("Shawshank Redemption, The", 1994, 9.0),
            new Movie("Pulp Fiction", 1994, 8.6),
            new Movie("Titanic", 1997, 7.2),
            new Movie("Star Wars: Episode V - The Empire Strikes Back", 1980,
                    8.6),
            new Movie("Usual Suspects, The", 1995, 8.7),
            new Movie("Schindler''s List", 1993, 8.8),
            new Movie("Saving Private Ryan", 1998, 8.5),
            new Movie("Braveheart", 1995, 8.3),
            new Movie("American Beauty", 1999, 8.8),
            new Movie("Raiders of the Lost Ark", 1981, 8.6),
            new Movie("Godfather, The", 1972, 9.0),
            new Movie("Star Wars: Episode VI - Return of the Jedi", 1983,
                    8.0),
            new Movie("Blade Runner", 1982, 8.3),
            new Movie("Silence of the Lambs, The", 1991, 8.5),
            new Movie("Forrest Gump", 1994, 7.8),
            new Movie("Star Wars: Episode I - The Phantom Menace", 1999,
                    7.3),
            new Movie("Sixth Sense, The", 1999, 8.5),
            new Movie("Independence Day", 1996, 6.0),
            new Movie("Terminator 2: Judgment Day", 1991, 7.9),
            new Movie("Se7en", 1995, 8.1),
            new Movie("Fargo", 1996, 8.2),
            new Movie("2001: A Space Odyssey", 1968, 8.3),
            new Movie("Aliens", 1986, 8.2),
            new Movie("Truman Show, The", 1998, 7.8),
            new Movie("Back to the Future", 1985, 7.8),
            new Movie("Casablanca", 1942, 8.8),
            new Movie("One Flew Over the Cuckoo''s Nest", 1975, 8.7),
            new Movie("Good Will Hunting", 1997, 7.9),
            new Movie("Fifth Element, The", 1997, 7.0),
            new Movie("Twelve Monkeys", 1995, 7.8)
    };

    public static void main(String[] args) {
        MovieSorter ms = new MovieSorter();

        System.out.println("Sort by title:");
        ms.sortByTitle(MOVIES);
        System.out.println("******************************************************");
        System.out.println("******************************************************");


        System.out.println("Sort by year:");
        ms.sortByYear(MOVIES);
        System.out.println("******************************************************");
        System.out.println("******************************************************");


        System.out.println("Sort by score:");
        ms.sortByScore(MOVIES);
    }
}
