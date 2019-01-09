import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import sorters.ArraysSort;
import sorters.MergeSortWithArraysSort;
import sorters.abstractsorters.MergeSort;

import java.util.concurrent.TimeUnit;

public class MergeSortWithArraysSortTest {
    MergeSort sort;
    int[] array;
    int[] expectedArray;
    private long millis = 10000;

    @Rule
    public final Timeout timeout = new Timeout(millis, TimeUnit.MILLISECONDS);

    @Before
    public void setUp(){
        sort = new MergeSortWithArraysSort();
        array = new int[]{3,4,2,1,5,10,8,6,7,9};
        expectedArray = new int[]{1,2,3,4,5,6,7,8,9,10};
    }

    @Test
    public void sortTest(){
        sort.sort(array);
        Assert.assertArrayEquals(expectedArray,array);
    }
}

