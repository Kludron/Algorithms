public class BubbleSort {

    public static int[] sort(int[] unorderedList) {
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

    public static int[] calculatedSort(int[] unorderedList) {
        long start = System.currentTimeMillis();
        int[] orderedList = sort(unorderedList);
        long end = System.currentTimeMillis();
        long total = end-start;
        System.out.println("Bubble Sort\nList length: " + unorderedList.length + "\nTime: " + total + "ms");
        return orderedList;
    }

}