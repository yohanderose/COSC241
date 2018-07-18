package week11;

/**
 * SelectionSort implementation of Sorter object.
 *
 * @author Yohan de Rose
 */
public class SelectionSort extends Sorter {

    /**
     *  Create a new SelectionSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public SelectionSort(Integer[] nums) {
        super(nums);
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class). 
     */
    public void sortNums() {
        comparisons = 0;
        for (int j = 0; j < nums.length; j++) {
            int min = nums[j];
            int minIndex = j;
            int temp = 0;

            for (int i = j; i < nums.length; i++) {
                comparisons++;
                if (min > nums[i]) {
                    min = nums[i];
                    minIndex = i;
                }
            }

            temp = nums[j];
            nums[j] = min;
            nums[minIndex] = temp;
            update();
        }
        
    }
}
