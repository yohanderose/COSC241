package week08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * A very basic random word generator.
 *
 * @author Michael Albert, Iain Hewson
 */
public class DigramGenerator implements WordGenerator {

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
    public DigramGenerator(Random r) {
        
        random = r;
    }
    
    /**
     * Return a random word of length n.
     *
     * @param n the required length of the word.
     * @return a random word of length n.
     */
    public String nextWord(int n) {
        final int alphnum = 26;
        StringBuilder result = new StringBuilder();
        String[] continuation = new String[alphnum];
        
        //add first letter
        try {
            Scanner file = new Scanner(new File("first-letters.txt"));
            String first = file.next();
            result.append(first.charAt(random.nextInt(first.length())));
        } catch (FileNotFoundException e) {
            System.exit(-1);
        }
        
        try {
            Scanner file = new Scanner(new File("continuations.txt"));
            int j = 0;
            while (file.hasNextLine()) {
                continuation[j] = file.nextLine();
                j++;
            }
            
        } catch (FileNotFoundException e) {
            System.exit(-1);
        }
        
        //add remainder
        final int asciiA = 97;
        for (int i = 0; i < n-1; i++) {
            String letters = continuation[result.charAt(i) -asciiA];
            result.append(letters.charAt(random.nextInt(letters.length())));
        }
        
        return result.toString();
    }

}
