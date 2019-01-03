package sorters;

import sorters.abstractsorters.BubbleSort;
import sorters.abstractsorters.MergeSort;
/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Merge sort class that extends {@link MergeSort} class
 *     and uses {@link BubbleSortFromEndToBegin} class to sort merged parts of array.
 *</p>
 */
public class MergeSortWithBubbleFromEndToBegin extends MergeSort {
    BubbleSort bs = new BubbleSortFromEndToBegin();
    /**
     * Realization of sorting array via merge sort algorithm with using a {@link BubbleSortFromEndToBegin} class.
     * <br>Uses {@link #merge(int[], int, int, int)} method from {@link MergeSort}
     * @param arr Array which is needed to be sorted.
     */
    public void sort(int arr[]){
        int left = 0;
        int right = arr.length-1;

        if (left < right)
        {
            int middle = (left+right)/2;

            int[] leftArray = copyArray(arr,left,middle);
            int[] rightArray = copyArray(arr,middle,right);

            bs.sort(leftArray);
            bs.sort(rightArray);
            merge(arr, left, middle, right);
        }
    }
    /**
     * Overriding of {@link #toString()} method
     */
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
