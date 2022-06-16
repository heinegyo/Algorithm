package phase1.week2.selectionSort;

import phase1.week2.insertSort.InsertionSort;
import phase2.week5.mergeSort.MergeSort;
import phase2.week5.mergeSort.MergeSortPrint;
import phase2.week6.QuickSort;
import phase3.week10.BubbleSort;
import phase3.week10.ShellSort;
import phase3.week9.HeapSort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SortingHelper {
    public SortingHelper(){}

    /**
     * 測試排序演算法正確性
     * @param arr
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>>boolean isSorted(E[] arr){
        for (int i=1;i<arr.length;i++)
            if(arr[i-1].compareTo(arr[i]) > 0)
                return false;
            return  true;
    }

    /**
     * 測試排序演算法性能、同時驗證排序的正確性
     * @param sortname
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sortTest(String sortname,E[] arr){

        long startTime = System.nanoTime();
        if(sortname.equals("SelectionSort"))
            SelectionSort.sort(arr);
        else if(sortname.equals("InsertionSort"))
            InsertionSort.sort(arr);
        else if(sortname.equals("MergeSort"))
            MergeSort.sort(arr);
        else if(sortname.equals("MergeSortBU"))
            MergeSort.sortBU(arr);
        else if(sortname.equals("MergeSortPrint"))
            MergeSortPrint.sort(arr);
        else if(sortname.equals("QuickSort"))
            QuickSort.sort(arr);
        else if(sortname.equals("QuickSort2Ways"))
            QuickSort.sort2Ways(arr);
        else if(sortname.equals("QuickSort3Ways"))
            QuickSort.sort3Ways(arr);
        else if(sortname.equals("HeapSort"))
            HeapSort.sort(arr);
        else if(sortname.equals("HeapSort2"))
            HeapSort.sort2(arr);
        else if(sortname.equals("BubbleSort"))
            BubbleSort.sort(arr);
        else if(sortname.equals("BubbleSort2"))
            BubbleSort.sort2(arr);
        else if(sortname.equals("BubbleSort3"))
            BubbleSort.sort3(arr);
        else if(sortname.equals("ShellSort"))
            ShellSort.sort(arr);
        else if(sortname.equals("ShellSort2"))
            ShellSort.sort2(arr);
        long endTime = System.nanoTime();

        double time = (endTime - startTime)/1000000000.0;

        if (!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortname+" failed");
        System.out.println(String.format("%s, n = %d : %f s",sortname,arr.length,time));

    }
}
