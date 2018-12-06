package sorters;

import sorters.abstractsorters.BubbleSort;

public class BubbleSortFromEndToBegin extends BubbleSort {

    public void sort(Integer[]array){
        sort(array,0,array.length);
    }
    private void sort(Integer[] array, int begin, int end){
        for(Integer i=begin;i<end;i++){
            for(Integer j=getFirst(end-1);isGreater(i,j);j=getNext(j)) {
                if (array[j-1] > array[j]) {
                    swap(array,j,j-1);
                }
            }
        }
    }

    public int getNext(int index) {
        index-=1;
        return index;
    }
}
