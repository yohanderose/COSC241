package week11;
import java.util.Arrays;

/**
 *  A heap sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Yohan de Rose.
 */
public class HeapSort extends Sorter {

    /** Allows Methods to work with int[].
     */
    public int[] num;
    /**
     *  Create a new HeapSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public HeapSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class). 
     */
    public void sortNums() {
        
        comparisons = 0;
        num= Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
        //build first, make empty result, swap in end index
        build(num);
        int[] result = new int[nums.length];
        int end = num.length-1;

        for (j = 0; j < num.length; j++) {
            result[j] = num[0];  //the start of test will be the max
            num[0] = num[end];
            num[end] = 0;
            end--;   //decrement end, as zeros will accumulate
            build(num);
            update();
        }

        //reverse the result
        end = result.length-1;   //index end where smallest will be in result
        for (i = 0; i < nums.length; i++) {
            //System.out.println("i = " + i + "end = " +end);
            nums[i] = result[end];
            end--;
        }
    }

    /**
     * make a heap data structure.
     * @param input - int[] to be heaped
     */
    public void build(int[] input) {
        //i is the last leaf -1
        for (i = (input.length-2)/2; i >= 0; i--) {
            maxHeap(input,i);
        }
    }

    /**
     * make a heap a maxheap and check down when swaps occur.
     * @param heap - max heap to be checked
     * @param i - current parent node
     */
    public void maxHeap(int[] heap, int i) {
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
                comparisons++;
                max = biggestChild;  //update max to check if swapped
                temp = heap[i];
                heap[i] = heap[biggestChild];
                heap[biggestChild] = temp;
            }

            //if there was a swap, check if its disrupted down the tree
            if (max != i) {
                maxHeap(heap, biggestChild);
            }
            update();
        }
    }



    /**
     * exception handle to check if one or two kids.
     * @param heap - max heap to be checked
     * @param i - current parent node
     * @return - true if two kids, false if just one.
     */
    public boolean has2Kids(int[] heap, int i) {
        try {
            int test = heap[2*i+2];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    /**
     * exception handle to check if has kids at all.
     * @param heap - max heap to be checked
     * @param i - current parent node
     * @return - true if not a leaf, false otherwise.
     */
    public boolean hasKids(int[] heap, int i) {
        try {
            int test = heap[2*i+1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

}
