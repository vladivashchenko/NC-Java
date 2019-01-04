package sorters.abstractsorters;

/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Abstract bubble sort class that extends {@link Sorter} class
 *     and contains {@link #swap(int[], int,int)} function, usually used in bubble sorts.
 *     Have two parameters:
 *     {@link #first int} - first element of sorting
 *     {@link #last int} - last element of sorting
 *
 *     Methods {@link #getFirst()},  {@link #setFirst(int)},{@link #getLast()} ,  {@link #setLast(int)}
 *     and abstract method {@link #getNext(int)} used in method {@link #sort(int[], int, int)}}
 *     to define way of sorting: from begin to end or from end to begin
 *</p>
 */
public abstract class BubbleSort extends Sorter{

    private int first;
    private int last;
    /**
     * Method that used to set first element to sort.
     * @param first First element
     */
    private void setFirst(int first) {
        this.first = first;
    }
    /**
     * Method that used to set last element to sort.
     * @param last Last element
     */
    private void setLast(int last) {
        this.last = last;
    }
    /**
     * Method that used to get first element to sort
     * @see #sort(int[], int, int)
     * @return {@link #first}
     */
    private int getFirst(){
        return first;
    }
    /**
     * Method that used to get last element to sort
     * @see #sort(int[], int, int)
     * @return {@link #last}
     */
    private int getLast(){
        return last;
    }

    /**
     * Method used to swap two elements in array.
     * @param array array in which two elements are needed to be swapped.
     * @param i fist index of element that needed to be swapped.
     * @param j second index of element that needed to be swapped.
     */
    protected void swap(int []array,int i, int j) {
        if (i < 0 || j < 0 || i >= array.length || j >= array.length)
            throw new IndexOutOfBoundsException();
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * Abstract method that should be implemented
     * <br>Used to get next index
     * @param index Index which is needed to be changed.
     * @return int Next index
     */
    protected abstract int getNext(int index);
    /**
     * Realization of sorting array via bubble sort algorithm.
     * <br>Uses {@link #getFirst()},  {@link #setFirst(int)},{@link #getLast()} ,  {@link #setLast(int)}
     * and abstract method {@link #getNext(int)} methods
     * @param array Array which is needed to be sorted.
     * @param first First element of sorting
     * @param last Last element of sorting
     */
    protected void sort(int array[],int first,int last)
    {
        boolean sorted = true;
        setFirst(first);
        setLast(last);
        for(int i = 0; i < array.length&&sorted; i++){
            sorted = false;
            for(int j = getFirst(); j < getLast()||j>getLast(); j = getNext(j)){
                if(array[j - 1] > array[j]){
                    swap(array, j,j-1);
                    sorted = true;
                }
            }
        }
    }
}
