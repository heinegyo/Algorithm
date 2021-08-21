package phase1.week4.linkedlist.leetcode;

/**
 * Remove Linked List Elements
 * LeetCode 203
 * 解說版
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //先處理head節點，
            //使用循環是避免第二個節點也等於val
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null)
            return null;

        //處理完head之後，用prev處理中後段的節點
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}