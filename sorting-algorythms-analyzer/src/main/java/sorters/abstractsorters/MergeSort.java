package sorters.abstractsorters;
/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Abstract merge sort class that extends {@link Sorter} class
 *     and contains {@link #merge(int[], int, int, int)} method, usually used to merge sorted parts of array.
 *</p>
 */
public abstract class MergeSort extends Sorter {
    /**
     * Merging method that usually used to merge sorted parts of array.
     * @param arr Array which is needed to be sorted
     * @param l - Left index
     * @param r - Right index
     * @param m - Middle index
     */
    protected void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    /**
     * Method that used to copy elements from one array to another.
     * @param source Source array which elements must be copied
     * @param begin - Begin index
     * @param end - End index
     */
    protected int[] copyArray(int[]source, int begin,int end){
        int[] array = new int[end-begin];
        for(int i=begin;i<end;i++)
            for(int j=0;j<array.length-1;j++)
                array[j]=source[i];
        return array;
    }
}
