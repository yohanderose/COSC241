package week11;
import java.util.Arrays;
/**
 *  A merge implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Yohan de Rose.
 */
public class MergeSort extends Sorter {

    /**
     *  Create a new MergeSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public MergeSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }  

    /**
     * Sort the integers (which are stored in the parent Sorter class). 
     */
    public void sortNums() {
        comparisons = 0;
        mergeSort(0, nums.length-1);
    }

    /**
     * recursive method that splits nums and then splits the split.
     * @param lo - lower bound
     * @param hi - upper bound
     */
    public void mergeSort(int lo, int hi) {
        if (lo < hi) {
            int mid = (hi+lo)/2; 
            mergeSort(lo, mid);
            mergeSort(mid+1, hi);
            merge(lo,mid,hi);
        }
    }

    /**
     * recombines split parts of nums in ascending order.
     * @param lo - lower bound
     * @param hi - upper bound
     * @param mid - middle of hi and lo
     */
    public void merge(int lo, int mid, int hi) {
        i = lo;
        j = mid+1;
        int count = lo;
        int[] temp;
        temp= Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
        for (int x = lo; x <= hi; x++) {
            temp[x] = nums[x];
        }

        while (i <= mid && j <= hi) {
            if (temp[i] < temp[j]) {
                comparisons++;
                nums[count] = temp[i];
                i++;
            } else {
                comparisons++;
                nums[count] = temp[j];
                j++;
            }
            count++;
        }

        while (i <= mid) {
            comparisons++;
            nums[count] = temp[i];
            i++;
            count++;
        }
        update();
    }
}
