package sorters;

import sorters.abstractsorters.BubbleSort;
import sorters.abstractsorters.MergeSort;

public class MergeSortWithBubbleFromEndToBegin extends MergeSort {
    BubbleSort bs = new BubbleSortFromEndToBegin();

    public void sort(Integer arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;

            bs.sort(arr, l, m);
            bs.sort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }
}
