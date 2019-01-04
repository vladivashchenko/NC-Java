package reflection;

import fillers.ArrayGenerator;
import fillers.Filler;
import net.sourceforge.stripes.util.ResolverUtil;
import sorters.abstractsorters.Sorter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
/**
 * @author Vlad Ivashchenko
 *
 * <p>
 *     Class that used for finding annotated fillers and classes, extending {@link Sorter}.
 *     <br> Contains method for invoking fillers.
 * </p>
 */
public class Reflection {

    private static int MAX_ELEMENT = 1000;
    private static int MIN_ELEMENT = 0;
    /**
     * <p>
     *     Method used to find all methods from {@link ArrayGenerator} class.
     *     It checks if they are marked with {@code @FillerAnnotation) and adds them to List.
     *     <br> Uses {@link #getAllMethods(Class)} method
     * </p>
     * @return List of methods, marked by {@code FillerAnnotation}
     */
    public List<Method> getAnnotatedMethods(Class type){
        List<Method> methods = new ArrayList<Method>();
        Class srcClass = ArrayGenerator.class;
        List<Method> allMethods = getAllMethods(srcClass);

        for(Method method:allMethods){
            if (method.isAnnotationPresent(Filler.class)) {
                Filler annotation = method.getAnnotation(Filler.class);
                if(annotation!=null) {
                    methods.add(method);
                }
            }
        }

        return methods;
    }
    /**
     * <p>
     *     Method used to invoke methods from {@link ArrayGenerator} class.
     *     * </p>
     * @return int[] Array of integers
     */
    public int[] invoke(Method method,int length){
        int[]array = new int[length];
        try {
             array= (int[]) method.invoke(ArrayGenerator.class,MIN_ELEMENT,MAX_ELEMENT, length);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return array;
    }
    /**
     * <p>
     *     Method used to get all methods from some class.
     *     * </p>
     * @return List of methods
     */
    private List<Method> getAllMethods(Class type){
        List<Method> allMethods = new ArrayList<Method>();
        allMethods = new ArrayList<Method>(Arrays.asList(type.getDeclaredMethods()));
        return allMethods;
    }
    /**
     * <p>
     *      Method used to find all classes extending {@link Sorter}.
     *      <br>Uses <i>net.sourceforge.stripes</i> library.
     * </p>
     * <p>
     *      All the founded classes, if they are not abstract, are added to List.
     *      <br> Uses {@link #isAbstract(Class)} method to check if the founded class is abstract.
     * </p>
     * @return List of founded non abstract methods.
     */
    public List<Sorter> getAllSorters() {
        List<Sorter> sorters = new ArrayList<Sorter>();
        Class superClass = Sorter.class;
        ResolverUtil resolver = new ResolverUtil();

        resolver.findImplementations(superClass, "sorters");
        Set<Class<? extends Sorter>> allSorters = resolver.getClasses();

        for(Class<? extends Sorter> sorter:allSorters){
            if(!isAbstract(sorter)){
                try {
                    Sorter nonAbstractSorter = sorter.newInstance();
                    sorters.add(nonAbstractSorter);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return  sorters;
    }
    /**
     * <p>
     *     Method used to to check if the class is abstract.
     * </p>
     * @return boolean
     */
    private boolean isAbstract(Class type) {
        int modifier = type.getModifiers();

        if(Modifier.isAbstract(modifier))
            return true;
        else
            return false;
    }
}
