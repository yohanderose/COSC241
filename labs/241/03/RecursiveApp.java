package week03;

/**
 * A class that does computation on numbers using recursion.
 *
 * @author Yohan de Rose
 */
public class RecursiveApp {

    /**
     * Method that calculates number of digits in a number.
     *
     * @param n number to be manipulated.
     * @return total digits in number.
     */
    public static long digits(long n) {
        if (n == 0) {
            return 0;
        } else {
            return 1 + digits(n/10);
        }
    }

    /**
     * Method that computes the sum of a numbers individual digits.
     *
     * @param n represents input n and what will be reduced.
     * @return sum of digits.
     */
    public static long sumOfDigits(long n) {

        if (n == 0) {
            return 0;
        } else {
            return n%10 + sumOfDigits(n/10);
        }       
   
    }

    public static void main(String[] args) {

        sumOfDigits(7244414)

    }
  
}
