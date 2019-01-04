package sorters;

import sorters.abstractsorters.Sorter;
import java.util.Arrays;

/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Arrays sort class that extends {@link Sorter} class
 *     and uses {@code Arrays.sort(int[]array)} method to sort array.
 *</p>
 */
public class ArraysSort extends Sorter{

    /**
     * Realization of {@link Sorter} class {@link #sort(int[])} method with the use of {@link Arrays#sort(int[])}.
     * @param array array which is needed to be sorted.
     */
    public void sort(int[]array){
        Arrays.sort(array);
    }
    /**
     * Overriding of {@link #toString()} method
     */
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
