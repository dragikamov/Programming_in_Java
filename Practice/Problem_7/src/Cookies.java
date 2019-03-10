
/**
 * <h1> Cookies Class </h1>
 * The Cookies Class implements an application that
 * makes an object Cookies.
 *
 * @author Dragi Kamov
 * @since 02.03.2018
 */
public class Cookies{
    private int[] arr;

    /**
     * This is the constructor for the class
     */
    Cookies(){
        arr = new int[10];
        for(int i=0;i<10;i++){
            arr[i]=0;
        }
    }

    /**
     * This method is used to add elements to the array
     * @param pos Is the representation for the id of the groups
     * @param val Is the number of cookie boxes that the children sold
     */
    public void insert(int pos, int val){
        arr[pos-1]+=val;
    }

    /**
     * This method is used to return the id of the group that has
     * most cookie boxes sold.
     * @return Returns the id of the group
     */
    public int maxId(){
        int max=arr[0];
        int pos=1;
        for(int i=1;i<10;i++){
            if(arr[i]>max){
                max=arr[i];
                pos=i+1;
            }
        }
        return pos;
    }
}