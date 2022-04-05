package phase1.week1.linearSearch;

import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator() {
    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 產生一個長度為n的隨機陣列，每個數字的範圍是[0,bound)
     * @param n 陣列規模
     * @param bound 每個數值的最大範圍
     * @return
     */
    public static Integer[] generateRandomArray(int n,int bound){
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for(int i=0;i<n;i++)
            arr[i] = rnd.nextInt(bound);
        return arr;
    }

    // 針對以中間點為標定點的快速排序，生成一個特殊的測試用例
    // 使得這樣的快速排序產生退化
    public static Integer[] generateSpecialArray(int n){
        Integer[] arr = new Integer[n];
        generateSpecialArray(arr, 0, arr.length - 1, 0);
        return arr;
    }

    private static void generateSpecialArray(Integer[] arr, int l, int r, int value){
        if(l > r) return;
        int mid = (l + r) / 2;
        arr[mid] = value;
        swap(arr, l, mid);
        generateSpecialArray(arr, l + 1, r, value + 1);
        swap(arr, l, mid);
    }

    private static <E> void swap(E[] arr, int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
