package week01;
import java.util.Scanner;
import java.util.ArrayList;
/**YdR.
 * @author Yohan de Rose.
 *  Counter app, outputs lines and words in unput from user.
 */

public class Counter {
    /**YdR.
     * @param args takes argument from command line.
     */
    public static void main(String[] args) {

       
        String input = getInput();

        int lines = 0;
        ArrayList<String> inputArray = new ArrayList<String>();

        Scanner scan = new Scanner(input);
        while (scan.hasNext()) {
            inputArray.add(scan.next());
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '\n') {
                lines++;
            }
        }
 
        System.out.println("lines: " + lines);
        System.out.println("words: " + inputArray.size());
        
    }
    /**YdR.
     * method reads string input from user.
     * @return returns user input.
     */
    public static String getInput() {
        String input = "";
        String line;
        Scanner keyboard = new Scanner(System.in);

        while (keyboard.hasNextLine()) {
            line = keyboard.nextLine();
            input += line + "\n";
        }
           
        return input; 
    }
}
    
