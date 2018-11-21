package sorters;

import sorters.abstractsorters.MergeSort;

public class MergeSortWithQuickSort extends MergeSort {
    QuickSort qs = new QuickSort();

    public void sort(Integer arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;

            qs.sort(arr, l, m);
            qs.sort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }
}
