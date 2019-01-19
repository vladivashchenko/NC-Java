package sorters;

import sorters.abstractsorters.MergeSort;
import sorters.abstractsorters.Sorter;

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
     * <br>Uses {@link #parallelMergeSort(int[], int, Sorter)}  method from {@link MergeSort}
     * @param arr Array which is needed to be sorted.
     */
    public void sort(int[] arr) {
        final int cores = Runtime.getRuntime().availableProcessors();
        parallelMergeSort(arr, cores,qs);
    }
    /**
     * Overriding of {@link #toString()} method
     */
    public String toString() {
        return this.getClass().getSimpleName();
    }
}