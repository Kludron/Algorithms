public class SelectionSort {
    
    public static int[] sort(int[] unorderedList) {
        for (int i = 0; i < unorderedList.length; i++) {
            for (int j = i+1; j < unorderedList.length; j++) {
                if (unorderedList[i] > unorderedList[j]) {
                    int temp = unorderedList[i];
                    unorderedList[i] = unorderedList[j];
                    unorderedList[j] = temp;
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
        System.out.println("Selection Sort\nList length: " + unorderedList.length + "\nTime: " + total + "ms");
        return orderedList;
    }

}