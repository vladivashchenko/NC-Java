package sorters;

import sorters.abstractsorters.MergeSort;

import java.util.Arrays;

public class MergeSortWithArraysSort extends MergeSort {
    ArraysSort as = new ArraysSort();

    public void sort(Integer arr[])
    {
        int left = 0;
        int right = arr.length-1;
        if (left < right)
        {
            int middle = (left+right)/2;

            Integer[] leftArray = copyArray(arr,left,middle);
            Integer[] rightArray = copyArray(arr,middle,right);


            as.sort(leftArray);
            as.sort(rightArray);
            merge(arr, left, middle, right);
        }
    }
}
