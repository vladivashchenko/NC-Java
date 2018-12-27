package sorters;

import sorters.abstractsorters.MergeSort;

import java.util.Arrays;

public class MergeSortWithArraysSort extends MergeSort {
    ArraysSort as = new ArraysSort();

    public void sort(int arr[])
    {
        int left = 0;
        int right = arr.length-1;
        if (left < right)
        {
            int middle = (left+right)/2;

            int[] leftArray = copyArray(arr,left,middle);
            int[] rightArray = copyArray(arr,middle,right);


            as.sort(leftArray);
            as.sort(rightArray);
            merge(arr, left, middle, right);
        }
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }
}
