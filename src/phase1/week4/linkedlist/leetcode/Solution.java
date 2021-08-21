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

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution2()).removeElements(head, 6);
        System.out.println(res);
    }
}