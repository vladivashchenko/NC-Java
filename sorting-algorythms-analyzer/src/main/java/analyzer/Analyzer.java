package analyzer;

import fillers.ArrayGenerator;
import reflection.Reflection;
import sorters.abstractsorters.Sorter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Analyzer {

    Reflection reflection;
    ArrayGenerator arrayGenerator;

    public long showExecutionTime(Sorter sorter, int[] array){
        long begin = System.nanoTime();
        sorter.sort(array);
        long end = System.nanoTime();

        return end - begin;
    }

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
