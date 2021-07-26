package phase1.week4.linkedlist;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    //取得LinkedList中元素的個數
    public int getSize() {
        return size;
    }

    //回傳鏈表是否為空
    public boolean isEmpty() {
        return size == 0;
    }

    //在鏈表頭增加新的元素e
    public void addFirst(E e) {
        // Node node = new Node(e);
        // node.next = head;
        // head = node;
        head = new Node(e, head);
        size++;
    }

    //在鏈表的index(0-based)位置新增新的元素e
    //在鏈表中不是一個常見情況，練習用
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed.Illegal index");
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1;i++)
                prev = prev.next;

            // Node node = new Node(e);
            // node.next = prev.next;
            // prev.next = node;
            prev.next = new Node(e,prev.next);
            size++;
        }
    }
    
    //在鏈表末尾增加新的元素
    public void addLast(E e){
        add(size,e);
    }
}
