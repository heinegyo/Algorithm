package phase2.week7;

import java.util.Arrays;
// A conveyor belt has packages that must be shipped from one port to another within days days.
// The ith package on the conveyor belt has a weight of weights[i].
// Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
// We may not load more weight than the maximum weight capacity of the ship.
// Return the least weight capacity of the ship that will result in all the packages
// on the conveyor belt being shipped within days days.
// A conveyor belt has packages that must be shipped from one port to another within days days.
// The ith package on the conveyor belt has a weight of weights[i].
// Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
// We may not load more weight than the maximum weight capacity of the ship.
// Return the least weight capacity of the ship that will result in all the packages
// on the conveyor belt being shipped within days days.
public class Leetcode1011 {
    public int shipWithinDays(int[] weights, int D) {

        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        while (l < r) {

            int mid = l + (r - l) / 2;
            if (days(weights, mid) <= D)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int days(int[] weights, int k) {

        int cur = 0, res = 0;
        for (int weight : weights)
            if (cur + weight <= k) cur += weight;
            else {
                res++;
                cur = weight;
            }
        res++;
        return res;
    }

}
