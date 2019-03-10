
/**
 * <h1> Donor Class </h1>
 * The Donor Class implements an application that
 * makes an object donor with two parameters:
 * name and rating.
 *
 * @author Dragi Kamov
 * @since 01.03.2018
 */
public class Donor{
    private String name;
    private String rating;

    /**
     * This is the constructor for the class
     * @param name This is the parameter used for the name
     * @param rating This is the parameter used for the rating
     */
    Donor(String name, String rating){
        this.name=name;
        this.rating=rating;
    }

    /**
     * Getter method for this.name
     * @return Getting the name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter method for this.rating
     * @return Getting the rating
     */
    public String getRating(){
        return this.rating;
    }

    /**
     * Setter method for this.name
     * @param name Used for setting name
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * Setter method for this.rating
     * @param rating Used for setting rating
     */
    public void setRating(String rating){
        this.rating=rating;
    }
}