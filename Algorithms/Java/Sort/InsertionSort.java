package sort;

import java.util.Random;

public class InsertionSort {

    private int[] unorderedList;
    
    public InsertionSort(int[] unorderedList) {
        this.unorderedList = unorderedList;
    }

    public int[] sort() {
        // Go through the list comparing it with the most previous number
        for (int i = 1; i < unorderedList.length; i++) {
            // If this number is less that the most previous number, it has not yet been sorted.
            if (unorderedList[i] < unorderedList[i-1]) {
                // Go through the list (up until it's current position), and insert it into the correct position
                for (int j = 0; j < i; j++) {
                    // If the number to insert is less than the current number being looked at, insert it here.
                    //      *This is because we are looking from the smallest number first*.
                    if (unorderedList[i] < unorderedList[j]) {
                        int temp = unorderedList[i];
                        // Move all other numbers up one position
                        for (int k = i-1; k > j; k--) {
                            unorderedList[k+1] = unorderedList[k];
                        }
                        unorderedList[j] = temp;
                    }
                }
            }
        }
        return unorderedList;
    }

    public void showList() {
        for (int i = 0; i < unorderedList.length; i++) {
            System.out.print(unorderedList[i]);
            if (i == unorderedList.length-1) {
                System.out.println("\n");
            } else {
                System.out.print(", ");
            }
        }
    }

    public boolean isSorted() {
        for (int i = 1; i < unorderedList.length; i++) {
            if (unorderedList[i] < unorderedList[i-1]) {
                return false;
            }
        }
        return true;
    }

    public long calculatedSort() {
        long start = System.currentTimeMillis();
        sort();
        long end = System.currentTimeMillis();
        long total = end-start;
        System.out.println("List length: " + unorderedList.length + "\nTime: " + total + "ms");
        return total;
    }

    public static void main(String[] args) {
        int size = 1024;
        int[] unorderedList = new Random(System.currentTimeMillis()).ints(size).toArray();
        InsertionSort sortedList = new InsertionSort(unorderedList);
        sortedList.calculatedSort();
        System.out.println(sortedList.isSorted());
    }

}