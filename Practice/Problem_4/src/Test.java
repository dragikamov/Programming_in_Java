
import java.util.Scanner;

/**
 * This is the testing class for Donor
 */
public class Test {
    /**
     * This is the main method which is used for testing the class
     * @param args Unused
     */
    public static void main(String[] args){
        String name1,name2,rating1,rating2;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the first donor:");
        name1 = in.nextLine();
        System.out.println("Enter the rating of the first donor:");
        rating1 = in.nextLine();

        System.out.println("Enter the name of the second donor:");
        name2 = in.nextLine();
        System.out.println("Enter the rating of the second donor:");
        rating2 = in.nextLine();

        Donor d1 = new Donor(name1,rating1);
        Donor d2 = new Donor(name2,rating2);

        System.out.println("The first person's name is: " + d1.getName());
        System.out.println("The first person's rating is: " + d1.getRating());

        System.out.println("The second person's name is: " + d2.getName());
        System.out.println("The second person's rating is: " + d2.getRating());

        d1.setName("John");
        d1.setRating("High");
        System.out.println("After change:");
        System.out.println("The first person's name is: " + d1.getName());
        System.out.println("The first person's rating is: " + d1.getRating());
    }
}
