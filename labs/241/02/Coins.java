package week02;

import java.util.Random;

/** 
 * Lab 2 COSC241 2018.
 * @author YohandeRose
 */
public class Coins {

    /**heads constant. */
    public static final boolean HEADS = true;
    /**tails constant. */
    public static final boolean TAILS = false;
    /**coins array. */
    private boolean[] coins;

    /**
     *Constructs state from array input.
     *@param coins .
     */
    public Coins(boolean[] coins) {
        this.coins = coins;
    }
    
    /**
     *Constructs state from String  input.
     *@param c .
     */
    public Coins(String c) {
        this.coins = new boolean[c.length()];
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == 'H') {
                this.coins[i] = HEADS;
            } else if (c.charAt(i) == 'T') {
                this.coins[i] = TAILS; 
            }
        }
    }
    
    /**
     *Constructs random state from int input.
     *@param length .
     */
    public Coins(int length) {
        this.coins = new boolean[length];
        for (boolean f: coins) {
            Random r = new Random();
            if (r.nextInt(2) == 1) {
                f = HEADS;
            } else {
                f = TAILS;
            }
        }
    }
    
    /**
     *number of HEADS in coins.
     *@return headCount
     */
    public int countHeads() {
        int headCount = 0;
        for (boolean f: coins) {
            if (f == HEADS) {
                headCount++;
            }
        }
        return headCount;
    }

    /**
     *finds number of consecutive groups.
     *@return runs
     */
    public int countRuns() {
        int result = 1;
        for (int i = 0; i < coins.length-1; i++) {
            if (this.coins[i] != this.coins[i+1]) {
                result++;
            }
        }
        return result;
    }

    /**
     *String representation of coins.
     *@return result
     */
    public String toString() {
        String result = "";
        for (boolean f: coins) {
            if (f == HEADS) {
                result += "H";
            } else {
                result += "T";
            }
        }
        return result;
    } 

   
}
