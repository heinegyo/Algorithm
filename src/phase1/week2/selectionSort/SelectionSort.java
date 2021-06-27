package phase1.week2.selectionSort;


import phase1.week1.linearSearch.ArrayGenerator;

public class SelectionSort {

    public SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        //arr[0...1) 是有序的;arr[i...n) 是無序的
        for (int i = 0; i < arr.length; i++) {
            //選擇arr[i...n) 中的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    //arr[j].compareTo(arr[minIndex])
    //arr[j]>arr[minIndex] 回傳大於0 代表arr[j]>arr[minIndex]
    //arr[j]<arr[minIndex] 回傳小於0 代表arr[j]<arr[minIndex]

    private static <E> void swap(E[] arr, int i, int j) {

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {

        int[] dataSize ={10000,100000};
        for (int n :dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }
    }
}
