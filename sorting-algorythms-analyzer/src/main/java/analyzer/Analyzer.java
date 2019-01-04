package analyzer;

import fillers.ArrayGenerator;
import reflection.Reflection;
import sorters.abstractsorters.Sorter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
     * @return List of strings
     */
    public List<String> analyze(){
        List<String> result = new ArrayList<String>();
        reflection = new Reflection();
        arrayGenerator = new ArrayGenerator();
        int[]array;

        List<Sorter> sorters = reflection.getAllSorters();
        List<Method> fillers = reflection.getAnnotatedMethods(arrayGenerator.getClass());

        for(int i=0;i<sorters.size();i++){
            for(int j=0;j<fillers.size();j++){
                for(int length = 100;length<=10000;length*=10){
                    array = reflection.invoke(fillers.get(j),length);
                    result.add(sorters.get(i).toString()+" : "+fillers.get(j).getName()+ " : "
                            +showExecutionTime(sorters.get(i),array));
                }
            }
        }

        return result;
    }
}
