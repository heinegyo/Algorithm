package phase2.week7;

public class BinarySearch {

    private BinarySearch() {
    }

    //非遞迴實現BinarySearch
    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0, r = data.length - 1;

        //在data[l,r]的範圍中查詢target
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0)
                return mid;
            if (data[mid].compareTo(target) < 0)
                l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }


    //遞迴實現Binary Search
    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {

        if (l > r) return -1;

        int mid = l + (r - l) / 2;

        if (data[mid].compareTo(target) == 0)
            return mid;
        if (data[mid].compareTo(target) < 0)
            return searchR(data, mid + 1, r, target);
        return searchR(data, l, mid - 1, target);
    }

    // >target 的最小索引
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0, r = data.length;

        //在data[l,r] 中尋找解
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    // > target，回傳最小索引值
    // == target，回傳最大索引
    public static <E extends Comparable<E>> int up_ceil(E[] data, E target) {
        int u = upper(data, target);
        if (u - 1 > 0 && data[u - 1].compareTo(target) == 0)
            return u - 1;
        return u;
    }

    // >= target 的 最小index
    public static <E extends Comparable<E>> int lower_ceil(E[] data, E target) {
        int l = 0, r = data.length;

        //在data[l,r]中尋找解
        while (l < r) {

            int mid = l + (r - l) / 2;

            //在upper中，這裡是data[mid].compareTo(target) <= 0
            //但是，對於lower_ceil來說，在data[mid] == target的時候，有可能是解
            //所以在等於的情況下，不能排除掉data[mid]的值。
            //也就是，data[mid] == target 的時候可能是解，也可能有更小的解在左邊，應該去更新右邊界
            if (data[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    // < target的最大值index
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1, r = data.length - 1;

        //在data[l,r] 中尋找解
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) < 0)
                l = mid;
            else
                r = mid - 1;
        }
        return l;
    }

    // < target ，返回最大值索引
    // == target，返回最小索引
    public static <E extends Comparable<E>> int lower_floor(E[] data, E target) {

        int l = lower(data, target);
        // 注意，因為我們要訪問 data[l + 1]，所以，我們要先確保 l + 1 不越界，
        // 即 l + 1 < data.length
        if (l + 1 < data.length && data[l + 1].compareTo(target) == 0)
            return l + 1;
        return l;
    }

    // <= target 最大索引
    public static <E extends Comparable<E>> int upper_floor(E[] data, E target) {

        int l = -1, r = data.length - 1;

        // 在 data[l, r] 中尋找解
        while (l < r) {

            int mid = l + (r - l + 1) / 2;

            // 在 lower 中，這里是 data[mid].compareTo(target) < 0
            // 但是，對於 upper_floor 來說，在 data[mid] == target 的時候，有可能是解
            // 所以在等於的情況下，不能排除掉 data[mid] 的值，我們的搜索空間的變化，同樣是 l = mid
            if (data[mid].compareTo(target) <= 0)
                l = mid;
            else
                r = mid - 1;
        }
        return l;
    }

    // 使用求解 >= target 的最小值索引的思路，實現 search
    // 在有序數組 data 中判斷 target 是否存在，存在則返回相應索引，不存在則返回 -1
    public static <E extends Comparable<E>> int search2(E[] data, E target) {
        // 以下代碼是求解 >= target 的最小值索引
        // ----------
        int l = 0, r = data.length;
        // 在 data[l, r] 中尋找解
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid;
        }
        // ----------
        // 求解 >= target 的最小值索引演算法結束
        // l 是 >= target 的最小值索引

        // 如果 data[l] == target，則返回 l；否則返回 -1
        // 注意，求解 >= target 的最小值索引，結果可能是 data.length，不是合法索引
        // 所以，我們要對 l 的合法性進行判斷，即確定 l < data.length
        if (l < data.length && data[l].compareTo(target) == 0)
            return l;
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++)
            System.out.print(BinarySearch.lower(arr, i) + " ");
        System.out.println();

    }


}
