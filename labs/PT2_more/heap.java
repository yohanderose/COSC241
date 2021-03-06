import java.util.Arrays;

public class heap {

    public static Integer[] nums = {8,4,7,1,9};
    public static int i, j ,temp;

    public static void main(String[] args) {
      System.out.println(Arrays.toString(nums));
      sortNums();
      System.out.println(Arrays.toString(nums));
    }

    public static void sortNums() {
      buildHeap(nums);
      Integer[] helper = new Integer[nums.length];

      for (i = nums.length-1; i >=0; i--) {
        helper[i] = nums[0];
        nums[0] = 0;
        buildHeap(nums);
      }
      nums = helper;
    }

    public static void buildHeap(Integer[ ] heap) {
      for (j = (heap.length-2)/2; j >=0; j--) {
        maxHeap(heap, j);
      }
    }

    public static void maxHeap(Integer[] heap, int i) {
      if (hasKids(heap,i)) {
        int max = heap[i];
        int biggestChild;
        int temp = 0;
        if (has2Kids(heap, i)) {
          if (heap[2*i+1] > heap[2*i+2]) {
            biggestChild = 2*i+1;
          } else {
            biggestChild = 2*i+2;
          }
        } else {
          biggestChild = 2*i+1;
        }

        if (max < heap[biggestChild]) {
          temp = heap[biggestChild];
          heap[biggestChild] = heap[i];
          heap[i] = temp;
        }

        if (max != i) {
          maxHeap(heap, biggestChild);
        }
      }
    }

    public static boolean hasKids(Integer[] heap, int i) {
      try {
        temp = heap[2*i+1];
      } catch (ArrayIndexOutOfBoundsException e) {
        return false;
      }
      return true;
    }
    public static boolean has2Kids(Integer[] heap, int i) {
      try {
        temp = heap[2*i+2];
      } catch (ArrayIndexOutOfBoundsException e) {
        return false;
      }
      return true;
    }

}
