package sorters;

import sorters.abstractsorters.MergeSort;
import sorters.abstractsorters.Sorter;

/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Merge sort class that extends {@link MergeSort} class
 *     and uses {@link ArraysSort} class to sort merged parts of array.
 *</p>
 */

public class MergeSortWithArraysSort extends MergeSort {
    ArraysSort as = new ArraysSort();
    /**
     * Realization of sorting array via merge sort algorithm with using a {@link ArraysSort} class.
     * <br>Uses {@link #parallelMergeSort(int[], int, Sorter)} method from {@link MergeSort}
     * @param arr Array which is needed to be sorted.
     */
    public void sort(int[] arr) {
        final int cores = Runtime.getRuntime().availableProcessors();
        parallelMergeSort(arr, cores,as);
    }
    /**
     * Overriding of {@link #toString()} method
     */
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
