package src;

import java.util.Arrays;
import java.util.Random;

import src.sort.BubbleSort;
import src.sort.MergeSort;
import src.sort.QuickSort;

public class Main {
    
    public static final int size = 100;

    public static void main(String[] args) {

        Random rand = new Random(555);
        int[] unorderedList = new int[size];
        for (int i = 0; i < size; i++) {
            unorderedList[i] = rand.nextInt(1000+1);
        }

        System.out.println("Unordered List:");
        for (int i = 0; i < unorderedList.length; i++) {
            System.out.print(unorderedList[i]);
            if (i == unorderedList.length-1) {
                System.out.println("\n");
            } else {
                System.out.print(", ");
            }
        }

        BubbleSort bubbleSorted = new BubbleSort(Arrays.copyOf(unorderedList, unorderedList.length));
        int[] bubbleSortedList = bubbleSorted.sort();
        System.out.println("BubbleSorted Array: " + bubbleSorted.isSorted());
        for (int i = 0; i < bubbleSortedList.length ; i++) {
            System.out.print(bubbleSortedList[i]);
            if (i == bubbleSortedList.length-1) {
                System.out.println("\n");
            } else {
                System.out.print(", ");
            }
        }

        MergeSort mergeSorted = new MergeSort(Arrays.copyOf(unorderedList, unorderedList.length));
        int[] mergeSortedList = mergeSorted.sort();
        System.out.println("MergeSorted Array: " + mergeSorted.isSorted());
        for (int i = 0; i < mergeSortedList.length ; i++) {
            System.out.print(mergeSortedList[i]);
            if (i == mergeSortedList.length-1) {
                System.out.println("\n");
            } else {
                System.out.print(", ");
            }
        }

        QuickSort quickSorted = new QuickSort(Arrays.copyOf(unorderedList, unorderedList.length));
        int[] quickSortedList = quickSorted.sort();
        System.out.println("QuickSorted Array: " + quickSorted.isSorted());
        for (int i = 0; i < quickSortedList.length ; i++) {
            System.out.print(quickSortedList[i]);
            if (i == quickSortedList.length-1) {
                System.out.println("\n");
            } else {
                System.out.print(", ");
            }
        }
    }

}
