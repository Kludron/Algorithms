package src.sort;

import java.util.Arrays;

import src.Sort;

public class QuickSort extends Sort {

    public QuickSort(int[] unorderedList) {
        super(unorderedList);
    }

    @Override
    public int[] sort() {
        super.setUnorderedList(quickSort(super.getUnorderedList()));
        return super.getUnorderedList();
    }

    private int[] quickSort(int[] a) {

        if (a.length == 1) {
            return new int[] {a[0]};
        }
        int[] less = new int[a.length];
        int[] greater = new int[a.length];
        int pivot = a[a.length-1];


        int lessi = 0;
        int greateri = 0;
        int dupCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < pivot) {
                less[lessi] = a[i];
                lessi++;
            } else if (a[i] > pivot || dupCount == 1) {
                greater[greateri] = a[i];
                greateri++;
            } else {
                dupCount++;
            }
        }
        int[] lessSorted = new int[] {};
        int[] greaterSorted = new int[] {};
        if (lessi > 0) {
            lessSorted = quickSort(Arrays.copyOf(less, lessi));
        }
        if (greateri > 0) {
            greaterSorted = quickSort(Arrays.copyOf(greater, greateri));
        }
        int[] result = new int[a.length];
        for (int i = 0; i < lessi; i++) {
            result[i] = lessSorted[i];
        }
        result[lessSorted.length] = pivot;
        for (int i = 0; i < greateri; i++) {
            result[i+lessSorted.length+1] = greaterSorted[i];
        }
        return result;
    }

}
