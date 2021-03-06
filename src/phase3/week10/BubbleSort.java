package phase3.week10;

import phase1.week1.linearSearch.ArrayGenerator;
import phase1.week2.selectionSort.SortingHelper;

import java.util.Arrays;

public class BubbleSort {

    public BubbleSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            //第i輪開始：arr[ n - i , n]已排好序
            //通過Bubble arr[arr - i -1]位置放上合適的元素
            for (int j = 0; j < data.length - i - 1; j++)
                if (data[j].compareTo(data[j + 1]) > 0)
                    swap(data, j, j + 1);
            //第i輪結束：arr[ n-i-1 , n]已經排好序
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            //第i輪開始：arr[ n - i , n]已排好序
            //通過Bubble arr[arr - i -1]位置放上合適的元素
            boolean isSwapped = false;
            for (int j = 0; j < data.length - i - 1; j++)
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    isSwapped = true;
                }
            if (!isSwapped) break;
            //第i輪結束：arr[ n-i-1 , n]已經排好序
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] data) {
        for (int i = 0; i < data.length - 1;) {
            //第i輪開始：arr[ n - i , n]已排好序
            //通過Bubble arr[arr - i -1]位置放上合適的元素
            int lastSwappedIndex = 0;
            for (int j = 0; j < data.length - i - 1; j++)
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    lastSwappedIndex = j + 1;
                }
            //if (lastSwappedIndex == 0 ) break;
            i = data.length - lastSwappedIndex;
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
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);

        System.out.println("Random Array");
        SortingHelper.sortTest("BubbleSort", arr);
        SortingHelper.sortTest("BubbleSort2", arr2);
        SortingHelper.sortTest("BubbleSort3", arr3);
        System.out.println();

        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr,arr.length);
        arr3 = Arrays.copyOf(arr,arr.length);

        System.out.println("Ordered Array");
        SortingHelper.sortTest("BubbleSort", arr);
        SortingHelper.sortTest("BubbleSort2", arr2);
        SortingHelper.sortTest("BubbleSort3", arr3);
        System.out.println();
    }
}
