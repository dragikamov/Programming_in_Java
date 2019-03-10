
import java.util.Scanner;

/**
 * This is the testing class for CopyMonitor
 */
public class Test {
    /**
     * This is the main method which is used for testing the class
     * @param args Unused
     */
    public static void main(String[] args){
        boolean toner,paper;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the status of the toner status:[true/false]");
        toner = in.nextBoolean();
        System.out.println("Enter the status of the paper status:[true/false]");
        paper = in.nextBoolean();

        CopyMonitor cm = new CopyMonitor(toner,paper);
        System.out.println("The current situation is:");
        cm.check();
    }
}
