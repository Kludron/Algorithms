package Sort;

import java.util.Random;

import Sort.Utilities;

public class SelectionSort {
    
    public SelectionSort(){;}

    public int[] sort(int[] unorderedList) {
        for (int i = 0; i < unorderedList.length; i++) {
            for (int j = i+1; j < unorderedList.length; j++) {
                if (unorderedList[i] > unorderedList[j]) {
                    int temp = unorderedList[i];
                    unorderedList[i] = unorderedList[j];
                    unorderedList[j] = temp;
                }
            }
        }
        return unorderedList;
    }

    public long calculatedSort(int[] unorderedList) {
        long start = System.currentTimeMillis();
        sort(unorderedList);
        long end = System.currentTimeMillis();
        long total = end-start;
        System.out.println("List length: " + unorderedList.length + "\nTime: " + total + "ms");
        return total;
    }

    public static void main(String[] args) {
        int size = 1024*128;
        int[] unorderedList = new Random(System.currentTimeMillis()).ints(size).toArray();
        SelectionSort algorithm = new SelectionSort();
        algorithm.calculatedSort(unorderedList);
        System.out.println(Utilities.isSorted(unorderedList));
    }
}