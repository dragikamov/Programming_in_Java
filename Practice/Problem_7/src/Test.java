
import java.util.Scanner;

/**
 * This is the testing class for Cookies
 */
public class Test {
    /**
     * This is the main method which is used for testing the class
     * @param args Unused
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int id,value;
        String number;
        Cookies s = new Cookies();
        while(true){
            System.out.println("Enter id:");
            number = in.nextLine();
            if(number.equals("") || number.equals(null)){
                break;
            }
            else{
                id = Integer.parseInt(number);
            }
            System.out.println("Enter the nr. of boxes:");
            value = in.nextInt();
            in.nextLine();
            s.insert(id,value);
        }
        System.out.println("The maximum cookies sold is id: "+s.maxId());
    }
}
