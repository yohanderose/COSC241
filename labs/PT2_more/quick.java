import java.util.Arrays;

public class quick {
  public static Integer[] nums = {8,4,7,1,9};
  public static int i, j ,temp;

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
      int mid = partition(lo, hi);
      quick(lo,mid-1);
      quick(mid+1,hi);
    }
  }
  public static int partition(int lo, int hi) {
    i = 0;
    j = i-1;
    int max = nums[hi];

    for (i = 0; i < nums.length-1; i++) {
      if (nums[i] < max) {
        j++;
        temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
      }
    }
    j++;
    temp = nums[hi];
    nums[hi] = nums[j];
    nums[j] = temp;
    return j;
  }
}
