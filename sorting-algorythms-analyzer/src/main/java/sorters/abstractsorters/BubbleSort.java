package sorters.abstractsorters;


public abstract class BubbleSort extends Sorter{

    private int first;
    private int last;

    private void setFirst(int first) {
        this.first = first;
    }

    private void setEnd(int last) {
        this.last = last;
    }

    private int getFirst(){
        return first;
    }

    private int getLast(){
        return last;
    }

    protected void swap(Integer[]values,int i, int j) {
        if (i < 0 || j < 0 || i >= values.length || j >= values.length)
            throw new IndexOutOfBoundsException();
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    protected abstract int getNext(int index);

    protected void sort(Integer array[],int first,int end)
    {
        boolean sorted = true;
        setFirst(first);
        setEnd(end);
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
