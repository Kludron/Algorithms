package Sort;

import java.util.Random;

public class BubbleSort {

    private int[] unorderedList;

    public BubbleSort(int[]unorderedList) {
        this.unorderedList = unorderedList;
    }

    public int[] sort() {
        for (int i = unorderedList.length-1; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (unorderedList[j] < unorderedList[j-1]) {
                    int temp = unorderedList[j];
                    unorderedList[j] = unorderedList[j-1];
                    unorderedList[j-1] = temp;
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
        int size = 1024*11;
        int[] unorderedList = new Random(System.currentTimeMillis()).ints(size).toArray();
        BubbleSort sortedList = new BubbleSort(unorderedList);
        sortedList.calculatedSort();
        System.out.println(sortedList.isSorted());
    }

}