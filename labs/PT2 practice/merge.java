/*
- i,j mergeSort and merge
- do comparisons on helper[] in merge as nums changes
- he's confident oh nah nah, oh nah nah
*/
import java.util.Arrays;

public class merge {
  public static Integer[] nums = {8,4,7,2,1,9};
  public static int i,j;

  public static void main(String[] args) {
    System.out.println(Arrays.toString(nums));
    sortNums();
    System.out.println(Arrays.toString(nums));
  }

  public static void sortNums() {
    mergeSort(0, nums.length-1);
  }

  public static void mergeSort(int lo, int hi) {
    if (lo < hi) {
      int mid = (hi+lo)/2;
      mergeSort(lo, mid);
      mergeSort(mid+1,hi);
      merge(lo, mid, hi);
    }
  }

  public static void merge(int lo, int mid, int hi) {
    Integer[] helper = Arrays.copyOfRange(nums, 0, hi+1);
    System.out.println(Arrays.toString(helper));
    i = lo;
    j = mid+1;
    int k = lo;
    while (i <= mid && j <= hi) {
      if (helper[i] < helper[j]) {
        nums[k] = helper[i];
        i++;
      } else {
        nums[k] = helper[j];
        j++;
      }
      k++;
    }
    while (i <= mid) {
      nums[k] = helper[i];
      i++;
      k++;
    }
    System.out.println();
    System.out.println(Arrays.toString(nums));

  }
}
