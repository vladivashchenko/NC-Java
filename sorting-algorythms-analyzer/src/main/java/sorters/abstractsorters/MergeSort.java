package sorters.abstractsorters;

import sorters.MergeSortRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Abstract merge sort class that extends {@link Sorter} class
 *     and contains {@link #merge(int[], int, int, int)} method, usually used to merge sorted parts of array.
 *</p>
 */
public abstract class MergeSort extends Sorter {
    /**
     * Merging method that usually used to merge sorted parts of array.
     *
     * @param array Array which is needed to be sorted
     * @param left   - Left index
     * @param right   - Right index
     * @param middle   - Middle index
     */
    private synchronized void merge(int array[], int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle-1;

        int leftArray[] = new int[leftSize];
        int rightArray[] = new int[rightSize];

        for (int i = 0; i < leftSize; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < rightSize; ++j)
            rightArray[j] = array[middle + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
    /**
     * Merging method that used to merge sorted parts of array in parallel.
     *
     * @param array Array which is needed to be sorted
     * @param threadCount   - Count of threads
     * @param sorter   - Sorter to sort halves
     */
    public void parallelMergeSort(int[] array, final int threadCount,Sorter sorter) {
        if (threadCount <= 1) {
            mergeSort(array,sorter);
        } else if (array.length >= 2) {
            int leftIndex =0;
            int rightIndex = array.length;
            int middleIndex= (rightIndex-leftIndex)/2;
          
            int[] left = Arrays.copyOfRange(array, leftIndex, middleIndex);
            int[] right = Arrays.copyOfRange(array, middleIndex, rightIndex);

            Thread lThread = new Thread(new MergeSortRunner(left, threadCount -1,this,sorter));
            Thread rThread = new Thread(new MergeSortRunner(right, threadCount -1,this,sorter));
            lThread.start();
            rThread.start();

            try {
                lThread.join();
                rThread.join();
            } catch (InterruptedException ie) {
            }
            
            merge(array,leftIndex,middleIndex, rightIndex);
        }
    }

    /**
     * Method that arranges the elements of the given array into sorted order
     * using the "merge sort" algorithm, which splits the array in half,
     * sorts the halves, then merges the sorted halves
     *
     * @param array Array which is needed to be sorted
     * @param sorter   - Sorter to sor halves
     */
    private synchronized void mergeSort(int[] array, Sorter sorter) {
        if (array.length >= 2) {
            int leftIndex =0;
            int rightIndex = array.length;
            int middleIndex= (rightIndex-leftIndex)/2;

            int[] left  = Arrays.copyOfRange(array, 0, array.length / 2);
            int[] right = Arrays.copyOfRange(array, array.length / 2, array.length);

            sorter.sort(left);
            sorter.sort(right);

            merge(array,leftIndex,middleIndex, rightIndex);
        }
    }
}