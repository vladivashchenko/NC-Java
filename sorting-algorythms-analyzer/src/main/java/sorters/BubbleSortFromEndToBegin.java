package sorters;

import sorters.abstractsorters.BubbleSort;

public class BubbleSortFromEndToBegin extends BubbleSort {

    public void sort(Integer[] array) {
        sort(array,array.length-1,0);
    }

    protected int getNext(int index) {
        index-=1;
        return index;
    }
}
