import java.util.Scanner;

/**
 * This is the testing class for Pet
 */
public class Test {
    /**
     * This is the main method which is used for testing the class
     * @param args Unused.
     */
    public static void main(String[] args){
        /* Input and creation of a pet object */
        String name1, breed1, name2, breed2;
        int age1,age2;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the first pet:");
        name1 = in.nextLine();
        System.out.println("Enter the breed of the first pet:");
        breed1 = in.nextLine();
        System.out.println("Enter the age of the first pet:");
        age1 = in.nextInt();

        /* We need this in.nextLine() because in.nextInt() doesn't
         * get the new line after it and that makes the next
         * in.nextLine() be skipped.*/
        in.nextLine();

        System.out.println("Enter the name of the second pet:");
        name2 = in.nextLine();
        System.out.println("Enter the breed of the second pet:");
        breed2 = in.nextLine();
        System.out.println("Enter the age of the second pet:");
        age2 = in.nextInt();

        Pet p1 = new Pet(name1,breed1,age1);
        Pet p2 = new Pet(name2,breed2,age2);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        if(p1.equals(p2)){
            System.out.println("\nThe pets are the same");
        }
    }
}
