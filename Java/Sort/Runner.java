import java.util.Random;
import java.util.Scanner;

import utils.Utilities;

public class Runner {

    private int size = 1024;
    private int minValue = Integer.MIN_VALUE;
    private int maxValue = Integer.MAX_VALUE;
    private Scanner input = new Scanner(System.in);
    public boolean isShown = false;
    private int[] unorderedList;

    public Runner() {
        promptLength();
        promptMinValue();
        promptMaxValue();
        promptShowList();
        unorderedList = new Random(System.currentTimeMillis()).ints(size, minValue, maxValue).toArray();
        System.out.println("");
    }

    public void promptLength() {
        System.out.print("Enter list length: ");
        try {
            size = Integer.parseInt(input.nextLine());
            if (size < 0) {
                size = 0;
            }
        } catch (NumberFormatException e) {;}
    }

    public void promptMinValue() {
        System.out.print("Enter minimum number: ");
        try {
            minValue = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {;}
    }

    public void promptMaxValue() {
        System.out.print("Enter maximum number: ");
        try {
            maxValue = Integer.parseInt(input.nextLine());
            if (maxValue <= minValue) {
                maxValue= minValue + 1;
            }
        } catch (NumberFormatException e) {;}
    }

    public void promptShowList() {
        System.out.print("Print the list (default = N) [Y/N]: ");
        if (input.nextLine().toLowerCase().equals("y")) {
            isShown = true;
        }
    }

    public int[] getUnorderedList() {
        return unorderedList.clone();
    }

    public void parseList(int[] orderedList) {
        System.out.println("List is sorted: " + Utilities.isSorted(orderedList));
        if(isShown) {
            Utilities.showList(orderedList);
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        Runner runner = new Runner();

        runner.parseList(runner.getUnorderedList());
        runner.parseList(MergeSort.calculatedSort(runner.getUnorderedList()));
        runner.parseList(QuickSort.calculatedSort(runner.getUnorderedList()));
        runner.parseList(SelectionSort.calculatedSort(runner.getUnorderedList()));
        runner.parseList(BubbleSort.calculatedSort(runner.getUnorderedList()));
        runner.parseList(InsertionSort.calculatedSort(runner.getUnorderedList()));
    }
    
}
