import java.util.Arrays;

public class select {

    public static Integer[] nums = {8,4,7,1,9};
    public static int i, j ,temp;

    public static void main(String[] args) {
      System.out.println(Arrays.toString(nums));
      sortNums();
      System.out.println(Arrays.toString(nums));
    }

    public static void sortNums() {


      for (i = 0; i < nums.length; i++) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums,i,nums.length)));
        int minIndex = i;
        for (j = i; j < nums.length; j++) {
          if (nums[j] < nums[minIndex]) {
            minIndex = j;
          }
        }
        System.out.println(nums[minIndex]);
        System.out.println("i: " + i);


        temp = nums[minIndex];
        nums[minIndex] = nums[i];
        nums[i] = temp;
        System.out.println("new: " + Arrays.toString(nums));

      }

      }

}
