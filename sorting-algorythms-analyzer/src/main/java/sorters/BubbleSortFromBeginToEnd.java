package sorters;

import sorters.abstractsorters.BubbleSort;

public class BubbleSortFromBeginToEnd extends BubbleSort {

    public void sort(Integer[] array, int begin, int end){
         for(Integer i=begin;i<end-1;i++){
            for(Integer j=begin;j<end-i-1;j++)
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
        }

    }
}
