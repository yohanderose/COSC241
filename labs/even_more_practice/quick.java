import java.util.Arrays;

public class quick {

  public static Integer[] nums = { 58, 17, 39, 44, 97, 62,45, 11};
  public static int i, j, temp;

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
      int mid = part(lo, hi);
      quick(lo, mid-1);
      quick(mid+1, hi);
    }

  }

  public static int part(int lo, int hi) {
    int max = nums[hi];
    i = 0;
    j = i-1;
    for (i = 0; i < hi; i++) {
      if (nums[i] < max) {
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
    System.out.println("pivot index: " + j);
    return j;
  }
}
