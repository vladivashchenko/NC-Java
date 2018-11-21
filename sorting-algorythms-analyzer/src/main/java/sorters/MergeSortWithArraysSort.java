package sorters;

import sorters.abstractsorters.MergeSort;

public class MergeSortWithArraysSort extends MergeSort {
    ArraysSort as = new ArraysSort();

    public void sort(Integer arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;

            as.sort(arr, l, m);
            as.sort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
}
