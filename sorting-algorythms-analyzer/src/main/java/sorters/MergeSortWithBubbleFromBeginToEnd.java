package sorters;

import sorters.abstractsorters.BubbleSort;
import sorters.abstractsorters.MergeSort;

public class MergeSortWithBubbleFromBeginToEnd extends MergeSort {
    BubbleSort bs = new BubbleSortFromBeginToEnd();

    public void sort(Integer arr[])
    {
        int left = 0;
        int right = arr.length-1;
        if (left < right)
        {
            int middle = (left+right)/2;

            Integer[] leftArray = copyArray(arr,left,middle);
            Integer[] rightArray = copyArray(arr,middle,right);


            bs.sort(leftArray);
            bs.sort(rightArray);
            merge(arr, left, middle, right);
        }
    }
}
