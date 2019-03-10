
/**
 * <h1> CopyMonitor Class </h1>
 * The CopyMonitor Class implements an application that
 * makes an object CopyMonitor with two boolean parameters
 * which are being checked in the main
 *
 * @author Dragi Kamov
 * @since 01.03.2018
 */
public class CopyMonitor {
    private boolean toner;
    private boolean paper;

    /**
     * This is the constructor for the class
     *
     * @param toner This is the parameter used for the boolean value of the toner
     * @param paper This is the parameter used for the boolean value of the paper
     */
    CopyMonitor(boolean toner, boolean paper) {
        this.toner = toner;
        this.paper = paper;
    }

    /**
     * Getter method for this.toner
     *
     * @return Getting the boolean value of toner
     */
    public boolean getToner() {
        return this.toner;
    }

    /**
     * Getter method for this.paper
     *
     * @return Getting the boolean value of paper
     */
    public boolean getPaper() {
        return this.paper;
    }

    /**
     * Setter method for this.toner
     *
     * @param toner Used for setting the boolean value of toner
     */
    public void setToner(boolean toner) {
        this.toner = toner;
    }

    /**
     * Setter method for this.paper
     *
     * @param paper Used for setting the boolean value of paper
     */
    public void setPaper(boolean paper) {
        this.paper = paper;
    }

    /**
     * A method which is checking the two boolean values and prints
     * a message on the screen whether the printers needs service
     * or not
     */
    public void check() {
        if (this.toner || this.paper) {
            System.out.println("This printer needs repair");
        } else {
            System.out.println("This printer doesn't need repair");
        }
    }
}