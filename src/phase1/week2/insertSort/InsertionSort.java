package phase1.week2.insertSort;

import phase1.week1.linearSearch.ArrayGenerator;
import phase1.week2.selectionSort.SortingHelper;

import java.util.Arrays;

/**
 * 插入排序法
 */
public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //將 arr[i] 插入到合適的位置
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    public static void main(String[] args) {

        int[] dataSize = {10000, 100000};
        for (int n : dataSize){

            System.out.println("Random Array");
            Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
            Integer[] arr2 = Arrays.copyOf(arr,arr.length);

            SortingHelper.sortTest("InsertionSort",arr);
            SortingHelper.sortTest("SelectionSort",arr2);

            System.out.println("Ordered Array");

            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr,arr.length);

            SortingHelper.sortTest("InsertionSort",arr);
            SortingHelper.sortTest("SelectionSort",arr2);

            System.out.println();

        }
    }

}
