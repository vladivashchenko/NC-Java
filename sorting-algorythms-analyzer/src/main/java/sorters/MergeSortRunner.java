package sorters;

import sorters.abstractsorters.MergeSort;
import sorters.abstractsorters.Sorter;

/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     MergeSort runner class that implements {@link Runnable} interface
 *     and uses {@link MergeSort#parallelMergeSort(int[], int, Sorter)} method to sort array.
 *</p>
 */
public class MergeSortRunner implements Runnable {
    private int[] array;
    private int threadCount;
    private MergeSort mergeSort;
    private Sorter sorter;

    public MergeSortRunner(int[] array, int threadCount, MergeSort mergeSort,Sorter sorter) {
        this.array = array;
        this.threadCount = threadCount;
        this.mergeSort = mergeSort;
        this.sorter=sorter;
    }
    /**
     * Method that runs a thread.
     */
    public void run() {
        mergeSort.parallelMergeSort(array, threadCount,sorter);
    }
}