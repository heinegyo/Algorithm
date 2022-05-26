package phase3.week9;

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
            if (arr[i-1]< arr[i])
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

    public static void main(String[] args) {
        int n = 3000000;

        // Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        // Integer[] arr2= Arrays.copyOf(arr,arr.length);
        // Integer[] arr3= Arrays.copyOf(arr,arr.length);
        // Integer[] arr4= Arrays.copyOf(arr,arr.length);
        //
        // SortingHelper.sortTest("MergeSort",arr);
        // SortingHelper.sortTest("QuickSort2Ways",arr2);
        // SortingHelper.sortTest("QuickSort3Ways",arr3);
        // SortingHelper.sortTest("HeapSort",arr4);

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        double time1 = testHeap(testData,false);
        System.out.println("Without heapify : " + time1 + "s");

        double time2 = testHeap(testData,true);
        System.out.println("With heapify : " + time2 + "s");

    }


}
