package phase1.week4.linkedlist.leetcode;

/**
 * Remove Linked List Elements
 * LeetCode 203
 * 使用dummyHead
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        //使用dummyHead就不用把head和中間的節點分開處理
        //dummyHead的val不重要，目的只是在head前加個節點
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        //處理完head之後，用prev處理中後段的節點
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        //不能直接把dummyHead return回去，dummyHead是對外隱藏的
        return dummyHead.next;
    }
}