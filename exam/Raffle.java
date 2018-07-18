import java.util.Arrays;
import java.util.Random;
public class Raffle {
  public static int count;
  public static void main(String[] args) {
    int[] entrants = {113, 210, 95, 17, 2014};
    System.out.println("Entrants: " + Arrays.toString(entrants));
    //testing if the outputs match actual probabilities...
    int a = 0,b = 0,c = 0,d = 0,e = 0;

    for (int i = 0; i <= 1000000; i++) {
      int result = choose(entrants);
      if (result == 'a') a++;
      else if (result == 'b') b++;
      else if (result == 'c') c++;
      else if (result == 'd') d++;
      else e++;
    }
    String results = String.format("Expected wins: a:%s\tb:%s\tc:%s\td:%s\te:%s",(int)(entrants[0]/(float)count*1000000),(int)(entrants[1]/(float)count*1000000),(int)(entrants[2]/(float)count*1000000),(int)(entrants[3]/(float)count*1000000),(int)(entrants[4]/(float)count*1000000));
    System.out.println(results);
    results = String.format("Got: a:%s\tb:%s\tc:%s\td:%s\te:%s",a,b,c,d,e);
    System.out.println(results);
  }

  public static char choose(int[] entrants) {
    int[] partitions = new int[entrants.length];
    count = 0;
    // we'll use a rolling total in a loop to turn [113, 210, 95, 17, 2014]
    // into [113, 323, 418, 435, 2449], as if giving tickets numbers
    for (int i = 0; i < entrants.length; i++) {
      count += entrants[i];
      partitions[i] = count;
    }

    Random r = new Random();
    int winner = r.nextInt(count)+1; //pick a winning ticket number
    for (int j = 0; j < partitions.length-1; j++) {
      if (partitions[j] >= winner) {  //check winner against indexes
        return (char)(j+97); //return player letter a-d instead of index
      }
    }
    return (char)(partitions.length+96); //else return player e
  }

}
