package sorters.abstractsorters;
/**
 * @author Vlad Ivashchenko
 *
 * <p>
 *      An abstract class containing only one abstract method {@link #sort(int[])}.
 * </p>
 */
public  abstract class Sorter {
    /**
     * Should be implemented by sorting algorithms.
     * @param array Array which is needed to be sorted.
     */
    public abstract void sort(int[] array);
}
