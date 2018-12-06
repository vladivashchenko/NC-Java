package fillers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ArrayGenerator {
    private static Random random = new Random();

    public static Integer[] generateRandomArray(Integer min,Integer max,Integer length){
        Integer randLimit = max-min+1;
        Integer[] resultArray = new Integer[length];
        for(Integer i=0;i<resultArray.length;i++)
            resultArray[i] = min + random.nextInt(randLimit);

        return resultArray;
    }

    public static Integer[] generateSortedArray(Integer min,Integer max,Integer length){

        Integer[] resultArray = generateRandomArray(min,max,length);
        Arrays.sort(resultArray);

        return resultArray;
    }

    public static Integer[] generateSortedArrayEndingWithX(Integer min,Integer max,Integer length){
        Integer randLimit = max-min+1;
        Integer[] resultArray = generateSortedArray(min,max,length);
        resultArray[length-1] = random.nextInt(randLimit);
        return resultArray;
    }

    public static Integer[] generateReverseSortedArray(Integer min,Integer max,Integer length){
        Integer[] resultArray = generateSortedArray(min,max,length);
        Arrays.sort(resultArray, Collections.reverseOrder());
        return resultArray;
    }
}
