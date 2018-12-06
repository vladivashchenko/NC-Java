package sorters.abstractsorters;

public  abstract class Sorter {
    public abstract void sort(Integer[] array);
    public void printArr(Integer[] arr){
        for(Integer i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
