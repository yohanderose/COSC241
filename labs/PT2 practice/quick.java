/*
- i, j, partition and quick
- i = 0 and j = i-1
-
*/
import java.util.Arrays;

public class quick {

  public static Integer[] nums = {8,4,7,2,1,9};
  public static int i,j;

  public static void main(String[] args) {
    System.out.println(Arrays.toString(nums));
    sortNums();
    System.out.println(Arrays.toString(nums));
  }

  public static void sortNums() {
    quick(0, nums.length-1);
  }

  public static void quick(int lo, int hi) {
    if (lo < hi) {
      j = partition(lo, hi);
      quick(lo, j-1);
      quick(j+1, hi);
    }
  }
  public static int partition(int lo, int hi) {
    int pivot = nums[hi];
    i = 0;
    j = i-1;
    int temp = 0;

    for (i = 0; i < hi-1; i++) {
      if (nums[i] < nums[hi]) {
        j++;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }
    j++;
    temp = nums[hi];
    nums[hi] = nums[j];
    nums[j] = temp;
    return j;
  }
}
