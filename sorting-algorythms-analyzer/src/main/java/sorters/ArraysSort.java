package sorters;

import sorters.abstractsorters.Sorter;

import java.util.Arrays;

public class ArraysSort extends Sorter{

    public void sort(Integer[] array, int left,int right){
        Arrays.sort(array,left,right);
    }
}
