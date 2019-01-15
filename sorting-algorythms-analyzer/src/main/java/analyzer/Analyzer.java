package analyzer;

import fillers.ArrayGenerator;
import reflection.Reflection;
import sorters.abstractsorters.Sorter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Analyzer class that used to analyze duration of sorting different types of arrays by each sorter
 *
 *</p>
 */
public class Analyzer {

    Reflection reflection;
    ArrayGenerator arrayGenerator;
    /**
     * <p>
     *     Method used to calculate duration of sorting.
     * </p>
     *
     * @param sorter Object of certain sorter
     * @param array Array to be sorted
     * @return Time of sorting in nanoseconds
     */
    public long showExecutionTime(Sorter sorter, int[] array){
        long begin = System.nanoTime();
        sorter.sort(array);
        long end = System.nanoTime();

        return end - begin;
    }
    /**
     * <p>
     *     Method used to get all results of analyzing.
     * </p>
     * <p>
     *     Uses <b>Reflection</b> to find all methods in {@link ArrayGenerator} class, that are marked by
     *     {@link fillers.Filler}.
     * </p>
     *
     * <p>
     *     All founded fillers generate arrays that are sorted by every sorting class, which is not abstract.
     *     The method uses {@link #showExecutionTime(Sorter, int[])} method to calculate the duration of sorting.
     * </p>
     * <br>
     * @see <a href="https://mvnrepository.com/artifact/net.sourceforge.stripes/stripes">net.sourceforge.stripes</a>
     * @return Map<String,Map<String,Map<Integer,Long>>> Map that has: String key - filler, Map value - sorting data
     */
    public Map<String,Map<String,Map<Integer,Long>>> analyze(){
        Map<String,Map<String,Map<Integer,Long>>> result =
                new HashMap<String, Map<String, Map<Integer, Long>>>();
        reflection = new Reflection();
        arrayGenerator = new ArrayGenerator();
        int[]array;

        List<Sorter> sorters = reflection.getAllSorters();
        List<Method> fillers = reflection.getAnnotatedMethods(arrayGenerator.getClass());

        for(Method filler:fillers){
            Map<String,Map<Integer,Long>> data =
                    new HashMap<String, Map<Integer, Long>>();
            for(Sorter sorter:sorters){
                Map<Integer,Long> sorterDurations = new HashMap<Integer, Long>();
                for(int length = 10;length<=100000;length=length*10){
                    array= reflection.invoke(filler,length);
                    sorterDurations.put(length,showExecutionTime(sorter,array));
                    data.put(sorter.toString(),sorterDurations);
                    result.put(filler.getName(),data);
                }
            }
        }
        return result;
    }
}
