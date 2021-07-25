public class QuickSort {

    public static int[] sort(int[] unorderedList) {
        return quickSort(unorderedList, 0, unorderedList.length-1);
    }

    private static int[] quickSort(int[] a, int start, int end) {
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

    public static int[] calculatedSort(int[] unorderedList) {
        long start = System.currentTimeMillis();
        int[] orderedList = sort(unorderedList);
        long end = System.currentTimeMillis();
        long total = end-start;
        System.out.println("Quick Sort\nList length: " + unorderedList.length + "\nTime: " + total + "ms");
        return orderedList;
    }

}
