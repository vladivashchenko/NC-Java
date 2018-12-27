package sorters;

import sorters.abstractsorters.BubbleSort;

public class BubbleSortFromBeginToEnd extends BubbleSort {

    protected int getNext(int index) {
        index+=1;
        return index;
    }
    public void sort(int[] array) {
        sort(array,1,array.length);
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }
}
