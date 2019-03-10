import java.util.Scanner;

/**
 * This is the testing class for Square
 */
public class Test {
    /**
     * This is the main method which is used for testing the class
     * @param args Unused
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] arr;
        arr=new int[9];
        System.out.println("Enter the square");
        for(int i=0;i<9;i++){
            arr[i]=in.nextInt();
        }

        Square s = new Square(arr);

        if(s.check()){
            System.out.println("The square is a magic square");
        }
        else{
            System.out.println("The square is not a magic square");
        }
    }
}
