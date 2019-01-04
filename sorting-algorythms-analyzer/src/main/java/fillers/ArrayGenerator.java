package fillers;

import java.util.Random;
/**
 * @author Vlad Ivashchenko
 *
 *<p>
 *     Class that used to generate array with defined length and max and min element.
 *
 *</p>
 */
public class ArrayGenerator {
    private static Random random = new Random();
    private static int RANDOM_LIMIT = 8;
    /**
     * <p>
     *     Method used to generate random array.
     * </p>
     *
     * @param min Minimum element
     * @param max Maximum element
     * @param length Length of array
     * @return array
     */
    @Filler
    public static int[] generateRandomArray(int min,int max,int length){
        if(length<=0)
            throw new IllegalArgumentException("Length must be greater than 0");
        else if ((max>0) && (min>0) && (max-min<1))
            throw new IllegalArgumentException("Maximal bound must be greater than minimum bound at least by 1");
        
        int randLimit = max-min+1;
        int[] resultArray = new int[length];
        
        for(int i=0;i<resultArray.length;i++)
            resultArray[i] = min + random.nextInt(randLimit);

        return resultArray;
    }
    /**
     * <p>
     *     Method used to generate sorted array.
     * </p>
     *
     * @param min Minimum element
     * @param max Maximum element
     * @param length Length of array
     * @return array
     */
    @Filler
    public static int[] generateSortedArray(int min,int max,int length){
        if(length<=0)
            throw new IllegalArgumentException("Length must be greater than 0");
        else if ((max>0) && (min>0) && (max-min<1))
            throw new IllegalArgumentException("Maximal bound must be greater than minimum bound at least by 1");

        int[] resultArray = new int[length];
        
        for(int i=1;i<resultArray.length;i++) {
            resultArray[0] = min;
            int next = resultArray[i-1]+random.nextInt(RANDOM_LIMIT);
            
            if(next>=max)
                resultArray[i] = max;
            else
                resultArray[i] = next;
        }
        
        return resultArray;
    }
    /**
     * <p>
     *     Method used to generate sorted array that ends with random element.
     * </p>
     *
     * @param min Minimum element
     * @param max Maximum element
     * @param length Length of array
     * @return array
     */
    @Filler
    public static int[] generateSortedArrayEndingWithX(int min,int max,int length){
        if(length<=0)
            throw new IllegalArgumentException("Length must be greater than 0");
        else if ((max>0) && (min>0) && (max-min<1))
            throw new IllegalArgumentException("Maximal bound must be greater than minimum bound at least by 1");

        int[] resultArray = generateSortedArray(min,max,length);
        resultArray[length-1] = random.nextInt(RANDOM_LIMIT);
        
        return resultArray;
    }
    /**
     * <p>
     *     Method used to generate reverse sorted array.
     * </p>
     *
     * @param min Minimum element
     * @param max Maximum element
     * @param length Length of array
     * @return array
     */
    @Filler
    public static int[] generateReverseSortedArray(int min,int max,int length){
        if(length<=0)
            throw new IllegalArgumentException("Length must be greater than 0");
        else if ((max>0) && (min>0) && (max-min<1))
            throw new IllegalArgumentException("Maximal bound must be greater than minimum bound at least by 1");

        int[] resultArray = new int[length];
        
        for(int i=1;i<resultArray.length;i++) {
            resultArray[0] = max;
            int next = resultArray[i-1]-random.nextInt(RANDOM_LIMIT);
            
            if(next<=min)
                resultArray[i] = min;
            else
                resultArray[i] = next;
        }
        
        return resultArray;
    }
}
