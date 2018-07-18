/*
- i, j, nested for
- min and minIndex
*/
import java.util.Arrays;

public class select {

  public static Integer[] nums = {8,4,7,2,1,9};
  public static int i,j;

  public static void main(String[] args) {
    System.out.println(Arrays.toString(nums));
    sortNums();
    System.out.println(Arrays.toString(nums));
  }

  public static void sortNums() {
    for (i = 0; i < nums.length; i++) {
      int min = nums[i];
      int minIndex = i;
      int temp = 0;

      for (j = i; j < nums.length; j++) {
        if (min > nums[j]) {
          min = nums[j];
          minIndex = j;
        }
      }

      temp = nums[i];
      nums[i] = nums[minIndex];
      nums[minIndex] = temp;

    }
  }
}
