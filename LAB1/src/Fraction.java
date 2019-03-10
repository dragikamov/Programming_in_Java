import java.util.Scanner;

public class Fraction {

    /* Class representing a fraction */

    /* Members of the class */
    private int numerator;
    private int denominator;

    /* Constructor
     * First puts the numerator and denominator in lowest terms and then stores them */
    Fraction(int numerator, int denominator) {

        int GCD = gcd(numerator, denominator);
        numerator /= GCD;
        denominator /= GCD;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /* Adds two fractions and returns the sum */
    static Fraction add(Fraction one, Fraction two){
        int newNumerator = one.numerator*two.denominator + two.numerator*one.denominator;
        int newDenominator = one.denominator*two.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /* Subtracts two fractions and returns the difference */
    static Fraction subtract(Fraction one, Fraction two){
        int newNumerator = one.numerator*two.denominator - two.numerator*one.denominator;
        int newDenominator = one.denominator*two.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /* Multiplies two fractions and returns the product */
    static Fraction multiply(Fraction one, Fraction two){
        return new Fraction(one.numerator*two.numerator,
                one.denominator*two.denominator);
    }

    /* Divides two fractions and returns the quotient */
    static Fraction divide(Fraction one, Fraction two){
        return new Fraction(one.numerator*two.denominator,
                one.denominator*two.numerator);
    }

    /* Overridden method used for check whether two fractions are equal
     * In case that the parameter obj is not instance of Fraction then the super class method
     * is called */
    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Fraction){
            Fraction fraction = (Fraction) obj;
            return this.numerator*fraction.denominator == fraction.numerator*this.denominator;
        }

        return super.equals(obj);
    }

    /* Euclidean algorithm for finding the greatest common divisor between two integers
     * This method returns the gcd of a and b */

    static int gcd(int a, int b){

        a = Math.abs(a);
        b = Math.abs(b);
        if(a > b){
            return gcd(b, a);
        }
        if(a == 0){
            return b;
        }
        return gcd(b%a, a);
    }

    /* Overridden method which is used for printing the fraction in fraction form (a/b) */
    @Override
    public String toString() {
        return String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator);
    }

    /* Main function which was used for testing the class Fraction, may be omitted */
    public static void main(String[] args) {

        /* Input and creation of two fractions */
        int a, b, c, d;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numerator of first fraction:");
        a = in.nextInt();
        System.out.println("Enter denominator of first fraction:");
        b = in.nextInt();
        System.out.println("Enter numerator of second fraction:");
        c = in.nextInt();
        System.out.println("Enter denominator of second fraction:");
        d = in.nextInt();

        Fraction f1 = new Fraction(a, b);
        Fraction f2 = new Fraction(c, d);
        System.out.println("Fraction one: " + f1.toString());
        System.out.println("Fraction two: " + f2.toString());

        if(f1.equals(f2)){
            /* Check if two fractions are equal */
            System.out.println("The fractions are the same.");
        }

        /* Adding, subtracting, multiplying and dividing the two fractions and then printing them */
        Fraction sum = Fraction.add(f1, f2);
        Fraction diff = Fraction.subtract(f1, f2);
        Fraction product = Fraction.multiply(f1, f2);
        Fraction quotient = Fraction.divide(f1, f2);

        System.out.println("The sum is: " + sum.toString());
        System.out.println("The difference is: " + diff.toString());
        System.out.println("The product is: " + product.toString());
        System.out.println("The quotient is: " + quotient.toString());
    }
}
