
import Sort.Utilities;

import java.util.Random;

import Sort.SelectionSort;

public static class Main {
    public static void main(String[] args) {
        int size = 1024*128;
        int[] unorderedList = new Random(System.currentTimeMillis()).ints(size).toArray();
        SelectionSort algorithm = new SelectionSort();
        algorithm.calculatedSort(unorderedList);
        System.out.println(Utilities.isSorted(unorderedList));
    }
}
