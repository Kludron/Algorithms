public class MergeSort {

    public static int[] sort(int[] unorderedList) {
        return mergeSort(unorderedList);
    }

    private static int[] mergeSort(int[] a) {

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

    private static int[] merge(int[] a, int[] b) {
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

    public static int[] calculatedSort(int[] unorderedList) {
        long start = System.currentTimeMillis();
        int[] orderedList = sort(unorderedList);
        long end = System.currentTimeMillis();
        long total = end-start;
        System.out.println("Merge Sort\nList length: " + unorderedList.length + "\nTime: " + total + "ms");
        return orderedList;
    }

}
