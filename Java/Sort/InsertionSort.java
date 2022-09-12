public class InsertionSort {
    
    public static int[] sort(int[] unorderedList) {
        // Go through the list comparing it with the most previous number
        for (int i = 1; i < unorderedList.length; i++) {
            // If this number is less that the most previous number, it has not yet been sorted.
            if (unorderedList[i] < unorderedList[i-1]) {
                // Go through the list (up until it's current position), and insert it into the correct position
                for (int j = 0; j < i; j++) {
                    // If the number to insert is less than the current number being looked at, insert it here.
                    //      *This is because we are looking from the smallest number first*.
                    if (unorderedList[i] < unorderedList[j]) {
                        int temp = unorderedList[i];
                        // Move all other numbers up one position
                        for (int k = i-1; k > j; k--) {
                            unorderedList[k+1] = unorderedList[k];
                        }
                        unorderedList[j] = temp;
                    }
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
        System.out.println("Insertion Sort\nList length: " + unorderedList.length + "\nTime: " + total + "ms");
        return orderedList;
    }

}