import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

  public static int[] bobs = {3,4,5};

  public static void main(String[] args) {
    System.out.println(Arrays.toString(bobs));
    shuffle(bobs);
    System.out.println(Arrays.toString(bobs));
  }

  public static void shuffle(int[] arr) {
    Random r = new Random();
    //from len-1 to 0
    for (int i = arr.length-1; i >= 0; i--) {
      int swapIndex = r.nextInt(i+1);
      int temp = arr[i];
      arr[i] = arr[swapIndex];
      arr[swapIndex] = temp;
    }
  }
}
