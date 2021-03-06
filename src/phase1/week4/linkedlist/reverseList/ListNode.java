package phase1.week4.linkedlist.reverseList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    //鏈表節點的建構子
    //使用arr為參數，建立一個鏈表，目前的ListNode為鏈表頭節點
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode cur = this;
        //index 從1開始 0:index為虛擬節點
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    //以目前節點為head的鏈表字串訊息
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            res.append(cur.val+"->");
            cur =cur.next;
        }
        res.append("Null");
        return res.toString();
    }

}
