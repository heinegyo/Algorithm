package phase2.week5.mergeSort;

//在陣列中的兩個數字，如果前面一個數字大於後面的數字，則這兩個數字組成一個逆序對。輸入一個陣列，求出這個陣列中的逆序對的總數。
public class ReverseParis {

    //暴力解
    public static int reversePairs2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }

    private int res = 0;

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return sort(nums, 0, nums.length - 1, temp);
    }

    private int sort(int[] arr, int l, int r, int[] temp) {
        if (l >= r) return 0;

        int mid = l + (r - l) / 2;
        int res = 0;
        res += sort(arr, l, mid, temp);
        res += sort(arr, mid + 1, r, temp);
        if (arr[mid] > arr[mid + 1])
            res += merge(arr, l, mid, r, temp);
        return res;
    }

    private int merge(int[] arr, int l, int mid, int r, int[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1, res = 0;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i] < temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                res += mid - i + 1;
                arr[k] = temp[j];
                j++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 4};
        ReverseParis reverseParis = new ReverseParis();
        System.out.println(reverseParis.reversePairs(arr));

    }
}
