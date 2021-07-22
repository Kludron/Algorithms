import java.util.Random;
import java.util.Scanner;

import utils.Utilities;

public class MergeSort {

    public MergeSort() {;}

    public int[] sort(int[] unorderedList) {
        return mergeSort(unorderedList);
    }

    private int[] mergeSort(int[] a) {

        if (a.length == 1) {
            return new int[] {a[0]};
        }

        // Split the array in two
        int[] a1 = new int[a.length/2];
        int[] a2 = new int[a.length - a1.length];

        // Fill the arrays
        for (int i = 0; i < a.length; i++) {
            if (i < a1.length) {
                a1[i] = a[i];
            } else {
                a2[i-a1.length] = a[i];
            }
        }

        return merge(mergeSort(a1), mergeSort(a2));
    }

    private int[] merge(int[] a, int[] b) {
        int ai = 0;
        int bi = 0;
        int[] result = new int[a.length+b.length];
        for (int i = 0; i < a.length + b.length; i++) {
            // if b array has all been added
            if (bi == b.length) {
                result[i] = a[ai];
                ai++;
            // if a array has all been added
            } else if (ai == a.length) {
                result[i] = b[bi];
                bi++;
            } else if (a[ai] <= b[bi]) {
                result[i] = a[ai];
                ai++;
            } else {
                result[i] = b[bi];
                bi++;
            }
        }
        return result;
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
        MergeSort algorithm = new MergeSort();
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
