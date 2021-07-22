import java.util.Random;
import java.util.Scanner;

import utils.Utilities;

public class QuickSort {

    public QuickSort() {;}

    public int[] sort(int[] unorderedList) {
        return quickSort(unorderedList, 0, unorderedList.length-1);
    }

    private int[] quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return a;
        }

        int pivot = end;
        for (int i = start; i < end && pivot > i; i++) {
            if (a[i] > a[pivot]) {
                int temp = a[i];
                a[i] = a[pivot-1];
                a[pivot-1] = a[pivot];
                a[pivot] = temp;
                pivot -= 1;
                i --;
            }
        }
        
        quickSort(a, start, pivot-1);
        quickSort(a, pivot+1, end);
        return a;
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
        QuickSort algorithm = new QuickSort();
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
