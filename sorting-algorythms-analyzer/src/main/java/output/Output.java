package output;

import analyzer.Analyzer;

import java.util.*;

public class Output {

    Analyzer analyzer = new Analyzer();

    public void show(){

        List<String> result;
        result = analyzer.analyze();

        printResults(result);

    }

    private void printResults(List<String> result){
        for (String s: result) {
            System.out.println(s);
        }
    }
}
