package phase2.week6;

import phase1.week1.linearSearch.ArrayGenerator;
import phase1.week2.selectionSort.SortingHelper;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1,random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r,Random random) {
        if (l >= r) return;

        int p = partition(arr, l, r,random);
        sort(arr, l, p - 1,random);
        sort(arr, p + 1, r,random);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r,Random random) {

        //產生[l,r]之間的隨機index
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        //arr[L+1...j]< v ; arr[j+1....i] >= v
        int j = l;
        for (int i = l; i <= r; i++)
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("QuickSort",arr2);

        //使用第一版的Quick sort 對有序陣列排序時，由於partition的劃分方式太不平均，會產生stackoverflow
        // Integer[] arr = ArrayGenerator.generateOrderedArray(n);
        // SortingHelper.sortTest("QuickSort",arr);
    }
}
