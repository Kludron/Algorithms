package Sort;

public static class Utilities {

    public static void showList(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
            if (i == list.length-1) {
                System.out.println("\n");
            } else {
                System.out.print(", ");
            }
        }
    }

    public static boolean isSorted(int[] list) {
        for (int i = 1; i < list.length; i++) {
            if (list[i] < list[i-1]) {
                return false;
            }
        }
        return true;
    }

}
