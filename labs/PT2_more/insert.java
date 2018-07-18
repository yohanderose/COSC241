import java.util.Arrays;

public class insert {

  public static Integer[] nums = {8,4,7,1,9};
  public static int i, j ,temp;

  public static void main(String[] args) {
    System.out.println(Arrays.toString(nums));
    sortNums();
    System.out.println(Arrays.toString(nums));
  }

  public static void sortNums() {    

    for (i = 1; i < nums.length; i++) {
      int key = nums[i];
      j = i-1;
      while (j >= 0 && key < nums[j]) {
        temp = nums[j];
        nums[j] = nums[j+1];
        nums[j+1] = temp;
        j--;
      }
    }
  }
}
