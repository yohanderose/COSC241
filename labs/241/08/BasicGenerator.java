package week08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * A very basic random word generator.
 *
 * @author Michael Albert, Iain Hewson
 */
public class BasicGenerator implements WordGenerator {

    /**
     * Random source used to generate words.
     */
    private Random random;

    /**
     * Constructs a basic random word generator which uses the given
     * random source.
     *
     * @param r a source of randomness used when generating words.
     */
    public BasicGenerator(Random r) {

        random = r;
    }

    /**
     * Return a random word of length n.
     *
     * @param n the required length of the word.
     * @return a random word of length n.
     */
    public String nextWord(int n) {
        StringBuilder result = new StringBuilder();
        String[] continuation = new String[26];

        //add first letter
        try {
            Scanner file = new Scanner(new File("/home/cshome/a/aderose/COMP160/Randomness/src/first-letters.txt"));
            String first = file.next();
            result.append(first.charAt(random.nextInt(first.length())));
        } catch (FileNotFoundException e) {
            System.exit(-1);
        }

        try {
            Scanner file = new Scanner(new File("/home/cshome/a/aderose/COMP160/Randomness/src/continuations.txt"));
            int j = 0;
            while (file.hasNextLine()) {
                continuation[j] = file.nextLine();
                j++;
            }

        } catch (FileNotFoundException e) {
            System.exit(-1);
        }

        //add remainder
        for (int i = 0; i < n-1; i++) {
            result.append(continuation[result.charAt(i) -97].charAt(random.nextInt(continuation[result.charAt(i) -97].length())));
        }

        return result.toString();
    }

}
