package sorters;

import sorters.abstractsorters.BubbleSort;
import sorters.abstractsorters.MergeSort;

public class MergeSortWithBubbleFromEndToBegin extends MergeSort {
    BubbleSort bs = new BubbleSortFromEndToBegin();

    public void sort(int arr[]){
        int left = 0;
        int right = arr.length-1;

        if (left < right)
        {
            int middle = (left+right)/2;

            int[] leftArray = copyArray(arr,left,middle);
            int[] rightArray = copyArray(arr,middle,right);

            bs.sort(leftArray);
            bs.sort(rightArray);
            merge(arr, left, middle, right);
        }
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }
}
