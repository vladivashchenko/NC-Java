import fillers.ArrayGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import reflection.Reflection;
import sorters.abstractsorters.Sorter;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReflectionTest {
    private Reflection reflection;
    private Method method;
    private long millis = 10000;

    @Rule
    public final Timeout timeout = new Timeout(millis, TimeUnit.MILLISECONDS);

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws NoSuchMethodException {
        reflection= new Reflection();
        method = ArrayGenerator.class.getDeclaredMethod("generateSortedArrayEndingWithX",int.class,int.class,int.class);
    }
    @Test
    public void getAnnotatedMethodsTest(){
        List<Method> methods = reflection.getAnnotatedMethods(ArrayGenerator.class);
        Assert.assertNotNull(methods);
    }
    @Test
    public void invokeTest(){
        int[]array = reflection.invoke(method,20);
        Assert.assertNotNull(array);
    }
    @Test
    public void getAllSortersTest() {
        List<Sorter> sorters = reflection.getAllSorters();
        Assert.assertNotNull(sorters);
    }
}
