package src;

import java.util.Arrays;
import java.util.Random;

import src.sort.BubbleSort;
import src.sort.MergeSort;
import src.sort.QuickSort;

public class Main {
    
    public static final int size = 64;
    public static final int minNum = -1000000;
    public static final int maxNum = +1000000;

    public static void main(String[] args) {

        // Created an unordered list of random numbers between the 0
        int[] unorderedList = new Random().ints(size, minNum, maxNum).toArray();

        // Print the unordered list, along with it's size
        System.out.println("Unordered List: Length - " + size);
        for (int i = 0; i < unorderedList.length; i++) {
            System.out.print(unorderedList[i]);
            if (i == unorderedList.length-1) {
                System.out.println("\n");
            } else {
                System.out.print(", ");
            }
        }

        // Print the Bubble Sorted list, along with an isSorted check
        BubbleSort bubbleSorted = new BubbleSort(Arrays.copyOf(unorderedList, unorderedList.length));
        int[] bubbleSortedList = bubbleSorted.sort();
        System.out.println("BubbleSorted Array: Sorted - " + bubbleSorted.isSorted());
        for (int i = 0; i < bubbleSortedList.length ; i++) {
            System.out.print(bubbleSortedList[i]);
            if (i == bubbleSortedList.length-1) {
                System.out.println("\n");
            } else {
                System.out.print(", ");
            }
        }

        // Print the Merge Sorted list, along with an isSorted check
        MergeSort mergeSorted = new MergeSort(Arrays.copyOf(unorderedList, unorderedList.length));
        int[] mergeSortedList = mergeSorted.sort();
        System.out.println("MergeSorted Array: Sorted - " + mergeSorted.isSorted());
        for (int i = 0; i < mergeSortedList.length ; i++) {
            System.out.print(mergeSortedList[i]);
            if (i == mergeSortedList.length-1) {
                System.out.println("\n");
            } else {
                System.out.print(", ");
            }
        }

        // Print the Quick Sorted list, along with an isSorted check
        QuickSort quickSorted = new QuickSort(Arrays.copyOf(unorderedList, unorderedList.length));
        int[] quickSortedList = quickSorted.sort();
        System.out.println("QuickSorted Array: Sorted - " + quickSorted.isSorted());
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
