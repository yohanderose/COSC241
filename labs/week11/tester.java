import java.util.Arrays;
import java.util.ArrayList;

public class tester {

  public static void main(String[] args) {

    int[] test = {8,2,3,5,1,9,6,4};
    ArrayList<Integer> copy = new ArrayList<>();
    for (int i : test) {
      copy.add(i);
    }
    copy.add(0, test[test.length-1]);
    copy.remove(copy.size()-1);



    copy.toArray();
    System.out.println(copy);


  }
}
