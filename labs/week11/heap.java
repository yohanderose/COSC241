import java.util.Arrays;
import java.lang.ArrayIndexOutOfBoundsException;

public class heap {

  public static int[] test = {8,2,3,5,1,23,6,4};

  public static void main(String[] args) {

    System.out.println(Arrays.toString(test));
    heapSort();
    System.out.println(Arrays.toString(test));

  }

  public static void heapSort() {

    //build first, make empty result, swap in end index
    build(test);
    int[] result = new int[test.length];
    int end = test.length-1;

    for (int j = 0; j < test.length; j++) {
      result[j] = test[0];  //the start of test will be the max
      test[0] = test[end];
      test[end] = 0;
      end--;   //decrement end, as zeros will accumulate
      build(test);
    }

    //reverse the result
    end = result.length-1;   //index end where smallest will be in result
    for (int i = 0; i < test.length; i++) {
      //System.out.println("i = " + i + "end = " +end);
      test[i] = result[end];
      end--;
    }


  }
  public static void build(int[] input) {
    //i is the last leaf -1
    for (int i = (input.length-2)/2; i >= 0; i--) {
      maxHeap(test,i);
    }
  }
  public static void maxHeap(int[] heap, int i) {
    int biggestChild;
    int max = i;
    int temp = 0;
    if (hasKids(heap, i)) {
      //find index of the biggest child
      if (has2Kids(heap, i)) {
        if (heap[2*i+1] > heap[2*i+2]) {
          biggestChild = 2*i+1;
        } else {
          biggestChild = 2*i+2;
        }
      } else {
        biggestChild = 2*i+1;
      }
      //then if biggest child is bigger than i, swap
      if (heap[biggestChild] > heap[i]) {
        max = biggestChild;  //update max to check if swapped
        temp = heap[i];
        heap[i] = heap[biggestChild];
        heap[biggestChild] = temp;
      }

      //if there was a swap, check if its disrupted down the tree
      if (max != i) {
        maxHeap(heap, biggestChild);
      }
    }
  }




  public static boolean has2Kids(int[] heap, int i) {
    try {
      int test = heap[2*i+2];
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
    return true;
  }

  public static boolean hasKids(int[] heap, int i) {
    try {
      int test = heap[2*i+1];
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
    return true;
  }

}
