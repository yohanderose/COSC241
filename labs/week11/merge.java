import java.util.Arrays;
//http://www.java2novice.com/java-sorting-algorithms/merge-sort/
public class merge {
  public static int[] nums = {8,5,9,1,3,4,7,1,9,6};
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
      int mid = (hi+lo)/2;  //WHY?
      mergeSort(lo, mid);
      mergeSort(mid+1, hi);
      merge(lo,mid,hi);
    }
  }
  public static void merge(int lo, int mid, int hi) {
    int i = lo;
    int j = mid+1;
    int count = lo;
    int[] temp = Arrays.copyOfRange(nums, 0, hi+1); //helper
    for (int x = lo; x <= hi; x++) {
      temp[x] = nums[x];
    }

    while (i <= mid && j <= hi) {
      if (temp[i] < temp[j]) {
        nums[count] = temp[i];
        i++;
      } else {
        nums[count] = temp[j];
        j++;
      }
      count++;
    }

    while (i <= mid) {
      nums[count] = temp[i];
      i++;
      count++;
    }
  }
}
