import java.util.Arrays;
/*
- buildHeap
- maxHeap
- hasKids and has2Kids
- then make sortNums
*/
public class heap {

  public static Integer[] nums = {8,2,5,4,0,1,9};
  public static int i, j, temp;

  public static void main(String[] args) {
    System.out.println(Arrays.toString(nums));
    sortNums();
    System.out.println(Arrays.toString(nums));
  }

  public static void sortNums() {
    Integer[] result = Arrays.copyOfRange(nums,0,nums.length);
    buildHeap(nums);

    for (j = nums.length-1; j >= 0; j--) {  //use j here to no confuse program
      //max of nums goes at end of result
      result[j] = nums[0];
      nums[0] = 0;
      buildHeap(nums);
    }
    nums = result;
  }

  public static void buildHeap(Integer[] array) {
    for (i = (array.length-2)/2; i >=0; i--) {   //i equals smallest leaf -1 to 0
      maxHeap(array, i);
    }
  }

  public static void maxHeap(Integer[] heap, int i) {
    int max = i;
    int biggestChild; //for 2 kids
    if (hasKids(heap,i)) {
      if (has2Kids(heap,i)) {
        if (heap[2*i+1] < heap[2*i+2]) {
          biggestChild = 2*i+2;
        } else {
          biggestChild = 2*i+1;
        }
        if (heap[biggestChild] > heap[i]) {
          max = biggestChild;
        }
      } else {
        if (heap[i] < heap[2*i+1]) {
          max = 2*i+1;
        }
      }

      //swap whatever is max
      temp = heap[i];
      heap[i] = heap[max];
      heap[max] = temp;
      //if max changed, check disruptions down the tree
      if (max != i) {
        maxHeap(heap,max);
      }
    }
  }

  public static boolean hasKids(Integer[] heap, int i) {
    try {
      temp = heap[2*i+1];
    } catch (ArrayIndexOutOfBoundsException e) { //remember ArrayIndexOutOfBoundsException
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
