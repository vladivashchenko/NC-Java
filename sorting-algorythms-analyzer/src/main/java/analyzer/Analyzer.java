package analyzer;

import sorters.abstractsorters.Sorter;

public class Analyzer {

    public long showExecutionTime(Sorter sorter, Integer[] array){
        long begin = System.nanoTime();
        sorter.sort(array);
        long end = System.nanoTime();

        return end - begin;
    }
}