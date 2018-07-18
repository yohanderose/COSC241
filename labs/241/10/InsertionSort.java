package week10;

/**
 * Insertion Sort implementation of Sorter object.
 *
 * @author Yohan de Rose
 */
public class InsertionSort extends Sorter {

    /**
     *  Create a new InsertionSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public InsertionSort(Integer[] nums) {
        super(nums);
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class). 
     */
    public void sortNums() {
        comparisons = 0;
        for (i = 1; i < nums.length; i++) {
            int key = nums[i];
            int temp = 0;
            j = i-1;

            while (j >= 0 && key < nums[j]) {
                comparisons++;
                temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
                j--;
                update();
            }
        }
    }
}
