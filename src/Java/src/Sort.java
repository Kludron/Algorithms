package src;

public abstract class Sort {
   
    private int[] unorderedList;

    public Sort(int[] unorderedList) {
        this.unorderedList = unorderedList;
    }

    public abstract int[] sort();

    public int[] getUnorderedList() {
        return unorderedList;
    }

    public void setUnorderedList(int[] unorderedList) {
        this.unorderedList = unorderedList;
    }

    public boolean isSorted() {
        for (int i = 1; i < unorderedList.length; i++) {
            if (unorderedList[i] < unorderedList[i-1]) {
                return false;
            }
        }
        return true;
    }

}
