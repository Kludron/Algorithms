package Sort;

import java.util.Random;

public class QuickSort {

    private int[] unorderedList;

    public QuickSort(int[] unorderedList) {
        this.unorderedList = unorderedList;
    }

    public int[] sort() {
        quickSort(unorderedList, 0, unorderedList.length-1);
        return unorderedList;
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
        int size = 1024*128;
        int[] unorderedList = new Random(System.currentTimeMillis()).ints(size).toArray();
        QuickSort sortedList = new QuickSort(unorderedList);
        sortedList.calculatedSort();
        System.out.println(sortedList.isSorted());
    }

}
