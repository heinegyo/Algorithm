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

}
