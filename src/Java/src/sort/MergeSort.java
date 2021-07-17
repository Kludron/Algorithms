package src.sort;

import src.Sort;

public class MergeSort extends Sort {

    public MergeSort(int[] unorderedList) {
        super(unorderedList);
    }

    @Override
    public int[] sort() {
        super.setUnorderedList(mergeSort(super.getUnorderedList()));
        return super.getUnorderedList();
    }

    private int[] mergeSort(int[] a) {

        if (a.length == 1) {
            return new int[] {a[0]};
        }

        // Split the array in two
        int[] a1 = new int[a.length/2];
        int[] a2 = new int[a.length - a.length/2];

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
            if (bi == b.length) {
                result[i] = a[ai];
                ai++;
            } else if (ai == a.length) {
                result[i] = b[bi];
                bi++;
            } else if (a[ai] < b[bi]) {
                result[i] = a[ai];
                ai++;
            } else {
                result[i] = b[bi];
                bi++;
            }
        }
        return result;
    }

}
