package output;

import analyzer.Analyzer;

import java.util.*;
/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Class that used to output results.
 *
 *</p>
 */
public class Output {

    Analyzer analyzer = new Analyzer();
    /**
     * <p>
     *     Method used to show results.
     *     <br> Uses {@link #printResults(List)} method.
     * </p>
     */
    public void show(){

        List<String> result;
        result = analyzer.analyze();

        printResults(result);

    }
    /**
     * <p>
     *     Method used to print results.
     *     <br> Used in {@link #show()} method.
     * </p>
     */
    private void printResults(List<String> result){
        for (String s: result) {
            System.out.println(s);
        }
    }
}
