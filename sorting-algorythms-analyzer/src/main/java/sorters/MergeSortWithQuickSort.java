package sorters;

import sorters.abstractsorters.MergeSort;
/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Merge sort class that extends {@link MergeSort} class
 *     and implements {@code Arrays.sort(int[]array)} method using a {@link QuickSort} class.
 *</p>
 */
public class MergeSortWithQuickSort extends MergeSort {
    QuickSort qs = new QuickSort();
    /**
     * Realization of sorting array via merge sort algorithm with using a {@link QuickSort} class.
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

            qs.sort(leftArray);
            qs.sort(rightArray);
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

