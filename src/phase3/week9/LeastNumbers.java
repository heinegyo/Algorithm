package phase3.week9;


import java.util.Collections;

public class LeastNumbers {
    //找出arr中最小的k個數
    public int[] getLeastNumbers(int[] arr,int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            pq.enqueue(arr[i]);

        for (int i = k; i < arr.length; i++)
            if(!pq.isEmpty() && arr[i] < pq.getFront()){
                pq.dequeue();
                pq.enqueue(arr[i]);
            }

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = pq.dequeue();

        return res;
    }

    //使用Java中的PriorityQueue
    public int[] getLeastNumbers2(int[] arr,int k){

        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++)
            pq.add(arr[i]);

        for (int i = k; i < arr.length; i++)
            if(!pq.isEmpty() && arr[i] < pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = pq.remove();

        return res;
    }

}
