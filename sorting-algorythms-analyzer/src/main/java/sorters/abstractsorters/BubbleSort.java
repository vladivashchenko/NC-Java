package sorters.abstractsorters;

import sorters.interfaces.Swapable;

public abstract class BubbleSort extends Sorter implements Swapable {

    public void swap(Integer[]values,int i, int j) {
        if (i < 0 || j < 0 || i >= values.length || j >= values.length)
            throw new IndexOutOfBoundsException();
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
    public int getNext(int index){
        index = index+1;
        return index;
    }

    public int getFirst(int begin){
        return begin;
    }

    public boolean isGreater(int begin,int end){
        if(begin<end)
            return true;
        else
            return false;
    }
}
