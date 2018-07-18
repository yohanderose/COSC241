import java.util.Arrays;

public class quick {

  public static int[] nums = {8,2,6,9,7,1,0,1,3};

  public static void main(String[] args) {
    System.out.println(Arrays.toString(nums));
    sortNums();
    System.out.println(Arrays.toString(nums));

  }

  public static void sortNums() {
    quick(0, nums.length-1);
  }

  public static void quick(int lo, int hi) {
    if (lo<hi) {
      int i = partition(lo, hi);
      quick(lo, i-1);
      quick(i+1,hi);
    }
  }

  public static int partition(int lo, int hi) {
    int x = nums[hi];
    int j = lo;
    int i = j-1;
    int temp = 0;

    for (j = lo; j < hi; j++) {
      if (nums[j] < x) {
          i++;
          temp = nums[j];
          nums[j] = nums[i];
          nums[i] = temp;
      }
    }
    i++;
    temp = nums[i];
    nums[i] = nums[hi];
    nums[hi] = temp;

    return i;
  }
}
