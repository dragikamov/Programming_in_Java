/**
 * This Movie class contains three attributes: title, year and score. Each attribute has a getter method accordingly
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 17.03.2018
 */
package core.implementation;

public class Movie {
    private String title;
    private int year;
    private float score;

    public Movie(String t, int y, double s) {
        title = t;
        year = y;
        score = (float)s;
    }


    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public float getScore() {
        return score;
    }
}


