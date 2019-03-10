/**
 * This class implements the abstract class MovieServices. It has three methods that allow user to
 * sort the list by title, year and score.
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 17.03.2018
 */
package core.implementation;

import core.MovieServices;

import java.util.*;


/**
 * This class implements a user-defined comparator that will sort the Movie alphabetically
 * according to its title.
 */
class titleComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.getTitle().compareTo(m2.getTitle());
    }
}

/**
 * This class implements a user-defined comparator that will sort the Movie in terms of year
 * in an ascending order
 */
class yearComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.getYear() - m2.getYear();
    }
}

/**
 * This class implements a user-defined comparator that will sort the Movie in terms of score
 * in an ascending order
 */
class scoreComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return (int)(m1.getScore() - m2.getScore());
    }
}

public class MovieSorter extends MovieServices {
    /**
     * a method that sort the list by title, and print the sorted list
     * @param a movie list
     */
    public void sortByTitle(Movie[] a) {
        List<Movie> movieList = new ArrayList();
        for (Movie m : a) {
            movieList.add(m);
        }
        Collections.sort(movieList, new titleComparator());
        for (Movie m: movieList){
            System.out.println("\"" + m.getTitle() + "\", " + m.getYear() + ", " + m.getScore());
        }

    }

    /**
     * a method that sort the list by year, and print the sorted list
     * @param a movie list
     */
    public void sortByYear(Movie[] a) {
        List<Movie> movieList = new ArrayList();
        for (Movie m : a) {
            movieList.add(m);
        }
        Collections.sort(movieList, new yearComparator());
        for (Movie m: movieList){
            System.out.println("\"" + m.getTitle() + "\", " + m.getYear() + ", " + m.getScore());
        }
    }

    /**
     * a method that sort the list by score, and print the sorted list
     * @param a movie list
     */
    public void sortByScore(Movie[] a) {
        List<Movie> movieList = new ArrayList();
        for (Movie m : a) {
            movieList.add(m);
        }
        Collections.sort(movieList, new scoreComparator());
        for (Movie m: movieList){
            System.out.println("\"" + m.getTitle() + "\", " + m.getYear() + ", " + m.getScore());
        }
    }
}
