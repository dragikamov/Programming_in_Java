/**
 * This is the abstract class that only contains the definition of sort methods.
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 17.03.2018
 */
package core;
import core.implementation.Movie;

public abstract class MovieServices{
    public abstract void sortByTitle(Movie[] a);

    public abstract void sortByYear(Movie[] a);

    public abstract void sortByScore(Movie[] a);
}
