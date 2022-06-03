package phase3.week10;

import phase1.week1.linearSearch.ArrayGenerator;
import phase1.week2.selectionSort.SortingHelper;

public class BubbleSort {

    public BubbleSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i + 1 < data.length; i++) {
            //第i輪開始：arr[ n - i , n]已排好序
            //通過Bubble arr[arr - i -1]位置放上合適的元素
            for (int j = 0; j < data.length - i - 1; j++)
                if (data[j].compareTo(data[j + 1]) > 0)
                    swap(data, j, j + 1);
            //第i輪結束：arr[ n-i-1 , n]已經排好序
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

        SortingHelper.sortTest("BubbleSort", arr);
    }
}
