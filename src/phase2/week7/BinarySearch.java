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
}
