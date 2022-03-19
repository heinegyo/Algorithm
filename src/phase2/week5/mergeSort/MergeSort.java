package phase2.week5.mergeSort;

import phase1.week1.linearSearch.ArrayGenerator;
import phase1.week2.selectionSort.SortingHelper;

import java.util.Arrays;

public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp) {
        if (l >= r) return;//整個區間沒有元素或只有一個元素

        //int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;//避免l+r 溢位
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r, temp);
    }

    //合併兩個有序的區間 arr[l, mid] 和 arr[mid + 1 ,r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        //從arr[]以l為起點copy (r-l)+1個元素到 temp 以l為起點
        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;

        //每輪循環為 arr[k] 賦值
        for (int k = l; k <= r; k++) {

            //arr[i] 和 arr[j]
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }


    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("InsertionSort", arr2);
        SortingHelper.sortTest("MergeSort", arr);
    }
}
