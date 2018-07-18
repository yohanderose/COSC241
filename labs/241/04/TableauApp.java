package week04;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Yohan de Rose
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
        System.out.println(isTableau(valid));
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t) {

        if (rowLengthsDecrease(t) && rowValuesIncrease(t) &&
            columnValuesIncrease(t) && isSetOf1toN(t)) {
            return true;
        }
        return false;
    }

    /**
     * Checks that descending rows reduce in length.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     * @return true if no row is longer than its predecessor, otherwise false
     */
    public static boolean rowLengthsDecrease(int[][] t) {

        for (int i = 0; i < t.length - 1; i++) {
            if (t[i].length < t[i + 1].length) {
                return false;
            }
        }

        return true;
    }

    /**
     * Determines whether values in each row increase.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     * @return true if each value in every row increases, otherwise false
     */
    public static boolean rowValuesIncrease(int[][] t) {

        for (int rows = 0; rows < t.length; rows++) {
            for (int cols = 0; cols < t[rows].length - 1; cols++) {
                if (t[rows][cols] > t[rows][cols + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Determines whether values in columns increase.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     * @return true if in equal to its predecessor - otherwise false
     */
    public static boolean columnValuesIncrease(int[][] t) {

        for (int rows = t.length - 1; rows >= 1; rows--) {
            for (int cols = 0; cols < t[rows].length; cols++) {
                if (t[rows][cols] < t[rows - 1][cols]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Determines whether values in the tableau correlate with n.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     * @return true if values in t sorted = 1 to n of t, otherwise false
     */
    public static boolean isSetOf1toN(int[][] t) {

        int count = 0;
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> oneToN = new ArrayList<>();

        for (int[] i : t) {
            for (int x : i) {
                count++;
                input.add(x);
            }
        }
        Collections.sort(input);

        for (int i = 1; i <= count; i++) {
            oneToN.add(i);
        }

        if (input.equals(oneToN)) {
            return true;
        } 

        return false;

    }

    /**
     * Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

}
