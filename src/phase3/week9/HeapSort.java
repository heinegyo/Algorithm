package phase3.week9;

import phase1.week1.linearSearch.ArrayGenerator;
import phase1.week2.selectionSort.SortingHelper;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {

    private HeapSort() {
    }

    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else {
            maxHeap = new MaxHeap<>();
            for (Integer num : testData)
                maxHeap.add(num);
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++)
            arr[i] = maxHeap.extractMax();
        for (int i = 1; i < testData.length; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static <E extends Comparable<E>> void sort(E[] data) {

        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : data)
            maxHeap.add(e);

        for (int i = data.length - 1; i >= 0; i--)
            data[i] = maxHeap.extractMax();

    }

    public static <E extends Comparable<E>> void sort2(E[] data) {

        if (data.length <= 1) return;
        //parent(arr.length -1) == (arr.length -2) /2
        for (int i = (data.length - 2) / 2; i >= 0; i--)
            siftDown(data, i, data.length);

        for (int i = data.length - 1; i >= 0; i--) {
            swap(data, 0, i);
            siftDown(data, 0, i);
        }
    }

    //對data[0,n)所形成的MaxHeap中，索引k的元素，執行siftDown
    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {

        while (2 * k + 1 < n) {
            int j = 2 * k + 1; //此輪循環中，data[k]和data[j]交換位置
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0)
                j++;
            //data[j]是leftChild和rightChild中的最大值

            if (data[k].compareTo(data[j]) >= 0)
                break;
            swap(data, k, j);
            k = j;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2= Arrays.copyOf(arr,arr.length);
        Integer[] arr3= Arrays.copyOf(arr,arr.length);
        Integer[] arr4= Arrays.copyOf(arr,arr.length);
        Integer[] arr5= Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("QuickSort2Ways",arr2);
        SortingHelper.sortTest("QuickSort3Ways",arr3);
        SortingHelper.sortTest("HeapSort",arr4);
        SortingHelper.sortTest("HeapSort2",arr5);

        // Random random = new Random();
        // Integer[] testData = new Integer[n];
        // for (int i = 0; i < n; i++)
        //     testData[i] = random.nextInt(Integer.MAX_VALUE);
        //
        // double time1 = testHeap(testData, false);
        // System.out.println("Without heapify : " + time1 + "s");
        //
        // double time2 = testHeap(testData, true);
        // System.out.println("With heapify : " + time2 + "s");
    }


}
