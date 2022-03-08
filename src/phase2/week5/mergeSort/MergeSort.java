package phase2.week5.mergeSort;

import phase1.week1.linearSearch.ArrayGenerator;
import phase1.week2.selectionSort.SortingHelper;

import java.util.Arrays;

public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;//整個區間沒有元素或只有一個元素

        //int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;//避免l+r 溢位
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    //合併兩個有序的區間 arr[l, mid] 和 arr[mid + 1 ,r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        E[] temp = Arrays.copyOfRange(arr, l, r + 1);//copyOfRange是前閉後開，r+1 這個元素是不包含的

        int i = l, j = mid + 1;

        //每輪循環為 arr[k] 賦值
        for (int k = l; k <= r; k++) {

            //arr[i] 和 arr[j]
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }


    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("SelectionSort", arr2);
        SortingHelper.sortTest("InsertionSort", arr3);
        SortingHelper.sortTest("MergeSort", arr);
    }
}
