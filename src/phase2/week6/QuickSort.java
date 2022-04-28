package phase2.week6;

import phase1.week1.linearSearch.ArrayGenerator;
import phase1.week2.selectionSort.SortingHelper;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private QuickSort() {
    }

    /**
     * one way
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        if (l >= r) return;

        int p = partition(arr, l, r, random);
        sort(arr, l, p - 1, random);
        sort(arr, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {

        //產生[l,r]之間的隨機index
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        //arr[l+1 ....i-1] <= V ; arr[j+1....r] >= v
        int i = l + 1, j = r;
        while (true) {

            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }

            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }

            if (i >= j) break;

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    /**
     * two ways
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort2Ways(E[] arr) {
        Random random = new Random();
        sort2Ways(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort2Ways(E[] arr, int l, int r, Random random) {
        if (l >= r) return;

        int p = partition2(arr, l, r, random);
        sort2Ways(arr, l, p - 1, random);
        sort2Ways(arr, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r, Random random) {

        //產生[l,r]之間的隨機index
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        //arr[l+1 ....i-1] <= V ; arr[j+1....r] >= v
        int i = l + 1, j = r;
        while (true) {

            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }

            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }

            if (i >= j) break;

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    /**
     * three ways
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort3Ways(E[] arr) {
        Random random = new Random();
        sort3Ways(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort3Ways(E[] arr, int l, int r, Random random) {
        if (l >= r) return;

        //產生[l,r]之間的隨機index
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        //arr[l+1, lt] < v, arr[lt + 1, i-1] == V ,arr[gt ,r] > v
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {

            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
            } else { //arr[i] == arr[l]
                i++;
            }
        }

        swap(arr, l, lt);
        //arr[l, lt - 1] < v , arr[lt, gt - 1 ] == v , arr [gt, r] > v

        sort3Ways(arr, l, lt - 1, random);
        sort3Ways(arr, gt, r, random);
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

        System.out.println("Random Array");
        SortingHelper.sortTest("QuickSort", arr);
        System.out.println();

        arr = ArrayGenerator.generateOrderedArray(n);

        System.out.println("Ordered Array");
        SortingHelper.sortTest("QuickSort",arr);
        System.out.println();

        arr = ArrayGenerator.generateRandomArray(n,1);

        System.out.println("Same Value Array");
        SortingHelper.sortTest("QuickSort",arr);

        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Random Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        System.out.println();

        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Order Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        System.out.println();

        arr = ArrayGenerator.generateRandomArray(n,1);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Same Value Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        System.out.println();
    }
}
