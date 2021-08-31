package phase1.week4.linkedlist.recursive;

public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    //計算arr[l...n)這個區間內所有數字的和
    private static int sum(int[] arr, int l) {
        if (l == arr.length)//陣列為空
            return 0;
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] sum = {1,2,3,4,5};
        System.out.println(sum(sum));
    }
}
