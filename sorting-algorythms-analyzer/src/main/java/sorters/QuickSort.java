package sorters;

import sorters.abstractsorters.Sorter;

/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Quick sort class that extends {@link Sorter} class
 *     and implements  {@link Sorter#sort(int[])} method.
 *</p>
 */
public class QuickSort  extends Sorter {

    /**
     * Implementation of {@link Sorter} class {@link Sorter#sort(int[])} method.
     * @param array Array which is needed to be sorted.
     */
    public void sort(int[]array){
        sort(array,0,array.length);
    }

    /**
     * Realization of sorting array via quick sort algorithm.
     * @param array Array which is needed to be sorted.
     * @param left Left bound of array
     * @param right Right bound of array
     */
    private void sort(int[] array,int left,int right){
        if(left >=right) return;
        int leftI = left;
        int rightI = right-1;
        int pivot = array[left + (right - left)/2];
        while(leftI<=rightI)
        {
            while(array[leftI]  < pivot )leftI++;
            while(array[rightI] > pivot )rightI--;
            if(leftI <=rightI)
            {
                swap(array,leftI,rightI);
                leftI++;
                rightI--;
            }
        }
        if(left < rightI)
            sort(array,left,rightI);
        if(leftI < right)
            sort(array,leftI,right);
    }
    /**
     * Method used to swap two elements in array.
     * @param values Array in which two elements are needed to be swapped.
     * @param i Fist index of element that needed to be swapped.
     * @param j Second index of element that needed to be swapped.
     */
    private void swap(int[]values,int i, int j) {
        if (i < 0 || j < 0 || i >= values.length || j >= values.length)
            throw new IndexOutOfBoundsException();
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    /**
     * Overriding of {@link #toString()} method
     */
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
