package Sort;

import java.util.Random;

public class MergeSort {

    private int[] unorderedList;

    public MergeSort(int[] unorderedList) {
        this.unorderedList = unorderedList;
    }

    public int[] sort() {
        unorderedList = mergeSort(unorderedList);
        return unorderedList;
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
        MergeSort sortedList = new MergeSort(unorderedList);
        sortedList.calculatedSort();
        System.out.println(sortedList.isSorted());
    }

}
