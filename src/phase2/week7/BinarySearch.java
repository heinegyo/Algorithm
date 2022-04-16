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

}
