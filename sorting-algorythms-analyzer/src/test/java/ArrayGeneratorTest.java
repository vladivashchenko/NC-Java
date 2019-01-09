import fillers.ArrayGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ArrayGeneratorTest {
    private long millis = 10000;

    @Rule
    public final Timeout timeout = new Timeout(millis, TimeUnit.MILLISECONDS);
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void generateRandomArrayTest(){
        int[] array = ArrayGenerator.generateRandomArray(0,100,20);
        Assert.assertNotNull(array);
        Assert.assertTrue(array.length==20);
    }

    @Test
    public void  generateSortedArray(){
        int[] array = ArrayGenerator.generateSortedArray(0,100,20);
        Assert.assertNotNull(array);
        Assert.assertTrue(array.length==20);
    }

    @Test
    public void  generateSortedArrayEndingWithX(){
        int[] array = ArrayGenerator.generateSortedArrayEndingWithX(0,100,20);
        Assert.assertNotNull(array);
        Assert.assertTrue(array.length==20);
    }

    @Test
    public void generateReverseSortedArray(){
        int[] array = ArrayGenerator.generateReverseSortedArray(0,100,20);
        Assert.assertNotNull(array);
        Assert.assertTrue(array.length==20);
    }

    @Test
    public void testExpectedException() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        int[] array = ArrayGenerator.generateSortedArray(0,1,0);
    }
}
