package phase2.week7;

import java.util.Arrays;

// Koko loves to eat bananas. There are n piles of bananas,
// the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
// Koko can decide her bananas-per-hour eating speed of k.
// Each hour, she chooses some pile of bananas and eats k bananas from that pile.
// If the pile has less than k bananas,
// she eats all of them instead and will not eat any more bananas during this hour.
// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.
// Example 1:
//
//         Input: piles = [3,6,7,11], h = 8
//         Output: 4
// Example 2:
//
//         Input: piles = [30,11,23,4,20], h = 5
//         Output: 30
// Example 3:
//
//         Input: piles = [30,11,23,4,20], h = 6
//         Output: 23
public class Leetcode875 {

    public int minEatingSpeed(int[] piles, int H) {

        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (eatingTime(piles, mid) <= H)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int eatingTime(int[] piles, int k) {
        int res = 0;
        for (int pile : piles)
            res += pile / k + (pile % k > 0 ? 1 : 0);
        return res;
    }

    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        Leetcode875 leetcode875 = new Leetcode875();
        System.out.println(leetcode875.minEatingSpeed(piles, 6));
    }
}
