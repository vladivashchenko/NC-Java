package sorters;

import sorters.abstractsorters.Sorter;
import sorters.interfaces.Swapable;

public class QuickSort  extends Sorter implements Swapable {

    public void sort(Integer[] array,int left,int right){
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

    public void swap(Integer[]values,int i, int j) {
        if (i < 0 || j < 0 || i >= values.length || j >= values.length)
            throw new IndexOutOfBoundsException();
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}
