
/**
 * <h1> Square Class </h1>
 * The Magic Square Class implements an application
 * that makes an object Square.
 *
 * @author Dragi Kamov
 * @since 01.03.2018
 */
public class Square{
    private int[][] mat;
    private int[]nums;

    /**
     * This is the constructor for the class
     * @param arr This is the array that is giving
     *            the elements of the square
     */
    Square(int[] arr){
        mat=new int[3][3];
        nums=new int[9];
        int k=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                this.mat[i][j]=arr[k];
                this.nums[arr[k]-1]=1;
                k++;
            }
        }
    }

    /**
     * This method is used to check whether the square
     * is a magic square
     * @return It is returning whether it is a magic square
     */
    public boolean check(){
        int sum;
        sum=this.mat[0][0]+this.mat[0][1]+this.mat[0][2];
        /*checking the totals of rows*/
        for(int i=1;i<3;i++){
            int curr=0;
            for(int j=0;j<3;j++){
                curr+=this.mat[i][j];
            }
            if(curr!=sum){
                return false;
            }
        }
        /*checking if all the numbers have appeared once*/
        for(int i=0;i<9;i++){
            if(this.nums[i]!=1){
                return false;
            }
        }
        /*checking the totals of columns*/
        for(int j=0;j<3;j++){
            int curr=0;
            for(int i=0;i<3;i++){
                curr+=this.mat[i][j];
            }
            if(curr!=sum){
                return false;
            }
        }
        /*checking the total of the diagonal*/
        if(sum!=(this.mat[0][0]+this.mat[1][1]+this.mat[2][2])){
            return false;
        }
        else{
            return true;
        }
    }
}