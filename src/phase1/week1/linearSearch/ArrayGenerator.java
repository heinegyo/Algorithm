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
}
