package week11;

/**
 *  A quick sort  implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Yohan de Rose.
 */
public class QuickSort extends Sorter {

    /**
     *  Create a new SillySort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public QuickSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class). 
     */
    public void sortNums() {
        comparisons = 0;
        quick(0, nums.length-1);
    }

    /**
     * method that divides nums and calls itself on those divisions.
     * @param lo - lower bound
     * @param hi - upper bound
     */
    public void quick(int lo, int hi) {
        if (lo<hi) {
            int i = partition(lo, hi);
            quick(lo, i-1);
            quick(i+1,hi);
        }
    }

    /**
     * method that finds the partition index.
     *
     * @param lo - lower bound
     * @param hi - upper bound
     * @return i - the partition
     */
    public int partition(int lo, int hi) {
        int x = nums[hi];
        j = lo;
        i = j-1;
        int temp = 0;

        for (j = lo; j < hi; j++) {
            comparisons++;
            if (nums[j] < x) {
                i++;
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                update();
            }
        }
        i++;
        temp = nums[i];
        nums[i] = nums[hi];
        nums[hi] = temp;
        comparisons++;
        update();
        return i;
    }
}
