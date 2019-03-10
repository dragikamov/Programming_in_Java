
import java.util.Scanner;

/**
 * This is the testing class for Board
 */
public class Test {
    /**
     * This is the main method which is used for testing the class
     * @param args Unused
     */
    public static void main(String[] args){
        int x,y,a,b;
        char c;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the x size of the board:");
        x = in.nextInt();
        System.out.println("Enter the y size of the board:");
        y = in.nextInt();
        in.nextLine();
        System.out.println("Enter the symbol for the whole board:");
        c = in.next().charAt(0);


        Board board = new Board(x,y);

        board.placeSymbol(c);
        board.print();
        System.out.println();

        System.out.println("Enter a symbol for every second place on the board:");
        c = in.next().charAt(0);
        board.placeSymbols(c);
        board.print();
        System.out.println();

        System.out.println("Enter the symbol for the change in the board:");
        c = in.next().charAt(0);
        System.out.println("Enter value for x to change:");
        a = in.nextInt();
        System.out.println("Enter value for x to change:");
        b = in.nextInt();
        while(!board.change(c,a,b)) {
            System.out.println("Invalid input. Try again:");
            System.out.println("Enter value for x to change:");
            a = in.nextInt();
            System.out.println("Enter value for x to change:");
            b = in.nextInt();
        }
        board.print();
    }
}
