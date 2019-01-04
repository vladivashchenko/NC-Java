package sorters;

import sorters.abstractsorters.BubbleSort;
/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Bubble Sort class that extends {@link BubbleSort} class and sort array from end to begin.
 *</p>
 */
public class BubbleSortFromEndToBegin extends BubbleSort {

    /**
     * Realization of sorting array via bubble sort algorithm with checking from end to begin.
     * <br>Uses {@link #sort(int[], int, int)} method from {@link BubbleSort}
     * @param array Array which is needed to be sorted.
     */
    public void sort(int[] array) {
        sort(array,array.length-1,0);
    }

    /**
     * Realization of {@link #getNext(int)} method from {@link BubbleSort}
     * @param index Index which is needed to be changed.
     * @return int Next index
     */
    protected int getNext(int index) {
        index-=1;
        return index;
    }
    /**
     * Overriding of {@link #toString()} method
     */
    public String toString() {
        return this.getClass().getSimpleName();

public class BubbleSortFromEndToBegin extends BubbleSort {

    public void sort(Integer[] array, int begin, int end){
        for(Integer i=begin;i<end-1;i++){
            for(Integer j=begin;j<end-i-1;j++) {
                if (array[j] > array[j + 1]) {
                    swap(array,j + 1, j);
                    printArr(array);
                }
            }
        }
    }
}
