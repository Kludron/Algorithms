import java.util.Random;
import java.util.Scanner;

import utils.Utilities;

public class InsertionSort {
    
    public InsertionSort() {;}

    public int[] sort(int[] unorderedList) {
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

    public long calculatedSort(int[] unorderedList) {
        long start = System.currentTimeMillis();
        sort(unorderedList);
        long end = System.currentTimeMillis();
        long total = end-start;
        System.out.println("List length: " + unorderedList.length + "\nTime: " + total + "ms");
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter list length: ");
        int size = 1024 * 64;
        try {
            size = Integer.parseInt(scanner.nextLine());
            if (size < 0) {
                size = 0;
            }
        } catch (NumberFormatException e) {;}
        
        System.out.print("Enter minimum number: ");
        int minNumber = Integer.MIN_VALUE;
        try {
            minNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {;}

        System.out.print("Enter maximum number: ");
        int maxNumber = Integer.MAX_VALUE;
        try {
            maxNumber = Integer.parseInt(scanner.nextLine());
            if (maxNumber <= minNumber) {
                maxNumber = minNumber + 1;
            }
        } catch (NumberFormatException e) {;}

        int[] unorderedList = new Random(System.currentTimeMillis()).ints(size, minNumber, maxNumber).toArray();
        System.out.print("Print the list (default = N) [Y/N]: ");
        boolean isShown = false;
        if (scanner.nextLine().toLowerCase().equals("y")) {
            isShown = true;
        }
        InsertionSort algorithm = new InsertionSort();
        System.out.println("Unsorted List: " + Utilities.isSorted(unorderedList));
        if (isShown) {
            Utilities.showList(unorderedList);
        }
        algorithm.calculatedSort(unorderedList);
        System.out.println("Sorted List: " + Utilities.isSorted(unorderedList));
        if (isShown) {
            Utilities.showList(unorderedList);
        }
    }

}