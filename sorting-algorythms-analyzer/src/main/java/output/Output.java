package output;

import analyzer.Analyzer;
import fillers.ArrayGenerator;
import sorters.*;
import sorters.abstractsorters.Sorter;

import java.util.Scanner;

public class Output {
    Analyzer analyzer = new Analyzer();
    ArrayGenerator arrayGenerator = new ArrayGenerator();
    Sorter sorter;
    Integer[] array;
    public void show(){

        int key = 0;
        do{
            System.out.println("1) Bubble Sort From Begin To End ");
            System.out.println("2) Bubble Sort From End To Begin");
            System.out.println("3) Quick Sort");
            System.out.println("4) Arrays Sort");
            System.out.println("5) Merge Sort with Bubble Sort From Begin To End");
            System.out.println("6) Merge Sort with Bubble Sort From End To Begin");
            System.out.println("7) Merge Sort with Quick Sort");
            System.out.println("8) Merge Sort with Arrays Sort");

            Scanner sc = new Scanner(System.in);

            key = sc.nextInt();

            switch (key){
                case 1:{
                    sorter = new BubbleSortFromBeginToEnd();
                    showResults(sorter);
                    break;
                }
                case 2:{
                    sorter = new BubbleSortFromEndToBegin();
                    showResults(sorter);
                    break;
                }
                case 3:{
                    sorter = new QuickSort();
                    showResults(sorter);
                    break;
                }
                case 4:{
                    sorter = new ArraysSort();
                    showResults(sorter);
                    break;
                }
                case 5:{
                    sorter = new MergeSortWithBubbleFromBeginToEnd();
                    showResults(sorter);
                    break;
                }
                case 6:{
                    sorter = new MergeSortWithBubbleFromEndToBegin();
                    showResults(sorter);
                    break;
                }
                case 7:{
                    sorter = new MergeSortWithQuickSort();
                    showResults(sorter);
                    break;
                }
                case 8:{
                    sorter = new MergeSortWithArraysSort();
                    showResults(sorter);
                    break;
                }
                case 0:{
                    System.exit(0);
                }
                default:
                    System.out.println("Not valid input");
            }
        } while(key != 0);

    }
    private void showResults(Sorter sorter){
        sorter = new BubbleSortFromBeginToEnd();
        array = arrayGenerator.generateRandomArray(0,100,100);
        System.out.println("Random array - "+analyzer.showExecutionTime(sorter,array));
        array = arrayGenerator.generateSortedArray(0,100,100);
        System.out.println("Sorted array - "+analyzer.showExecutionTime(sorter,array));
        array = arrayGenerator.generateSortedArrayEndingWithX(0,100,100);
        System.out.println("Array Ending With X  - "+analyzer.showExecutionTime(sorter,array));
        array = arrayGenerator.generateReverseSortedArray(0,100,100);
        System.out.println("Reverse Sorted array - "+analyzer.showExecutionTime(sorter,array));
    }
}
