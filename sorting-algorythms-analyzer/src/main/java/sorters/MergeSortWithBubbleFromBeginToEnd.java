package sorters;

import sorters.abstractsorters.BubbleSort;
import sorters.abstractsorters.MergeSort;
import sorters.abstractsorters.Sorter;

/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Merge sort class that extends {@link MergeSort} class
 *     and uses {@link BubbleSortFromBeginToEnd} class to sort merged parts of array.
 *</p>
 */
public class MergeSortWithBubbleFromBeginToEnd extends MergeSort {
    BubbleSort bs = new BubbleSortFromBeginToEnd();
    /**
     * Realization of sorting array via merge sort algorithm with using a {@link BubbleSortFromBeginToEnd} class.
     * <br>Uses {@link #parallelMergeSort(int[], int, Sorter)}  method from {@link MergeSort}
     * @param arr Array which is needed to be sorted.
     */
    public void sort(int[] arr) {
        final int cores = Runtime.getRuntime().availableProcessors();
        parallelMergeSort(arr, cores,bs);
    }
    /**
     * Overriding of {@link #toString()} method
     */
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
