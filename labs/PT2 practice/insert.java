/*
- i, j, for and while
- j = i-1
- key = nums[i]
- swap j and j+1 if j > key
*/

import java.util.Arrays;

public class insert {

  public static Integer[] nums = {8,4,7,2,1,9};
  public static int i,j;

  public static void main(String[] args) {
    System.out.println(Arrays.toString(nums));
    sortNums();
    System.out.println(Arrays.toString(nums));
  }

  public static void sortNums() {
    for (i = 1; i < nums.length; i++) {
      int key = nums[i];
      int temp = 0;
      int j = i-1;

      while (j >= 0 && nums[j] > key) {
        temp = nums[j];
        nums[j] = nums[j+1];
        nums[j+1] = temp;
        j--;
      }
    }
  }
}
