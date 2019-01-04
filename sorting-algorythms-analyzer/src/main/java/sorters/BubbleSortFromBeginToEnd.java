package sorters;

import sorters.abstractsorters.BubbleSort;
/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Bubble Sort class that extends {@link BubbleSort} class and sort array from begin to end.
 *</p>
 */
public class BubbleSortFromBeginToEnd extends BubbleSort {

    /**
     * Realization of {@link #getNext(int)} method from {@link BubbleSort}
     * @param index Index which is needed to be changed.
     * @return int Next index
     */
    protected int getNext(int index) {
        index+=1;
        return index;
    }
    /**
     * Realization of sorting array via bubble sort algorithm with checking from begin to end.
     * <br>Uses {@link #sort(int[], int, int)} method from {@link BubbleSort}
     * @param array Array which is needed to be sorted.
     */
    public void sort(int[] array) {
        sort(array,1,array.length);
    }

    /**
     * Overriding of {@link #toString()} method
     */
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
