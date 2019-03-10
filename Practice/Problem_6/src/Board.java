
/**
 * <h1> Board Class </h1>
 * The Board Class implements an application that
 * makes an object board.
 *
 * @author Dragi Kamov
 * @since 01.03.2018
 */
public class Board{
    private char[][] arr;
    private int x,y;

    /**
     * This is the constructor for the class
     * @param x This parameter is used for the x-axis of the matrix
     * @param y This parameter is used for the y-axis of the matrix
     */
    Board(int x, int y){
        this.x=x;
        this.y=y;
        arr = new char[x][y];
    }

    /**
     * This method is used to make all members in the matrix
     * to one symbol.
     * @param c This is the character that every member is being changed to
     */
    public void placeSymbol(char c){
        for(int i=0;i<this.x;i++) {
            for(int j=0;j<this.y;j++) {
                arr[i][j]=c;
            }
        }
    }

    /**
     * This method is used to make every second member in the matrix
     * to one symbol.
     * @param c This is the character that every member is being changed to
     */
    public void placeSymbols(char c){
        boolean check=false;
        for(int i=0;i<this.x;i++) {
            for(int j=0;j<this.y;j++) {
                if(check==false) {
                    check=true;
                    arr[i][j]=c;
                }
                else{
                    check=false;
                }
            }
        }
    }

    /**
     * This is the method for printing the matrix
     */
    public void print(){
        for(int i=0;i<this.x;i++)
        {
            for(int j=0;j<this.y;j++)
            {
                System.out.print(this.arr[i][j]);
            }
            System.out.print('\n');
        }
    }

    /**
     * This method is used to change a particular member
     * of the matrix to a given character. Also it is
     * checking if the given location is in the matrix.
     * And if it is not it is returning a false value to
     * the main function where it is asking for a valid
     * input.
     * @param c This is the character that is going to be put
     * @param x This is the location for the x-axis
     * @param y This is the location for the y-axis
     * @return Returns a false boolean if the input is not valid
     */
    public boolean change(char c, int x, int y){
        if(x<0 || y<0 || x>this.x || y>this.y){
            return false;
        }
        else{
            this.arr[x][y]=c;
            return true;
        }
    }
}