import analyzer.Analyzer;
import fillers.ArrayGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import sorters.BubbleSortFromBeginToEnd;
import sorters.abstractsorters.Sorter;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AnalyzerTest {
    private Analyzer analyzer;
    private Sorter sorter;
    private int[]array;
    private long millis = 10000;

    @Rule
    public final Timeout timeout = new Timeout(millis, TimeUnit.MILLISECONDS);

    @Before
    public void setUp(){
        analyzer = new Analyzer();
        sorter = new BubbleSortFromBeginToEnd();
        array = ArrayGenerator.generateRandomArray(0,100,25);
    }
    @Test
    public void showExecutionTimeTest(){
        long time = analyzer.showExecutionTime(sorter,array);
        Assert.assertNotNull(time);
    }
    @Test
    public void analyzeTest(){
        List<String> result = analyzer.analyze();
        Assert.assertNotNull(result);
    }
}
