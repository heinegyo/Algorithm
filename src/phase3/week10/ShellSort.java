package phase3.week10;

import phase1.week1.linearSearch.ArrayGenerator;
import phase1.week2.selectionSort.SortingHelper;

import java.util.Arrays;

public class ShellSort {

    private ShellSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] data) {

        int h = data.length / 2;
        while (h >= 1) {

            for (int start = 0; start < h; start++) {//遍歷每個子陣列的起始位置

                //對data[start,start + h , start + 2h ,start + 3h ...],進行InsertionSort
                for (int i = start + h; i < data.length; i += h) {
                    E t = data[i];
                    int j;
                    for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h)
                        data[j] = data[j - h];
                    data[j] = t;
                }
            }
            h /= 2;
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("ShellSort",arr);
        // SortingHelper.sortTest("InsertionSort",arr2);
        SortingHelper.sortTest("MergeSort",arr);

    }
}
