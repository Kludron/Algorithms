package src.sort;

import src.Sort;

public class BubbleSort extends Sort {

    public BubbleSort(int[]unorderedList) {
        super(unorderedList);
    }

    @Override
    public int[] sort() {
        int[] unorderedList = super.getUnorderedList();
        for (int i = 0; i < unorderedList.length; i++) {
            for (int j = i+1; j < unorderedList.length; j++) {
                if (unorderedList[i] > unorderedList[j]) {
                    int temp = unorderedList[j];
                    unorderedList[j] = unorderedList[i];
                        unorderedList[i] = temp;
                }
            }
        }
        return unorderedList;
    }

}