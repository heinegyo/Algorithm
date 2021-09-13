package phase1.week4.linkedlist.reverseList;

/**
 * 反轉鏈表的非遞迴實現
 */
class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 反轉鏈表的遞迴實現
     */
    public ListNode reverseListWithRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rev = reverseListWithRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

}
