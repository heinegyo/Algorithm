package phase1.week4.linkedlist.recursive;

import javafx.util.Pair;

public class LinkedList_Recursion<E> {

    public class Node{
        public E e;
        public Node next;
        public Node(Node node, E e){
            this.e = e;
            this.next = node;
        }
        public Node(){
            this(null,null);
        }
        public Node(E e){
            this(null,e);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node head;
    private int size;
    public LinkedList_Recursion() {
        head = null;
        size =0;
    }
    //獲取元素個數
    public int getSize(){
        return size;
    }
    //判斷鏈表時候為空
    public boolean isEmpty(){
        return size==0;

    }
    // 在鏈表的index(0-based)位置新增新的元素e
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        head = add(head, index, e);
        size++;
    }
    //在以node為頭結點的鏈表的index位置插入元素e，遞歸演算法
    public Node add(Node node, int index, E e){
        if(index == 0){
            return new Node(node, e);
        }
        node.next = add(node.next, --index, e);
        return node;
    }
    // 在鏈表頭新增新的元素e
    public void addFirst(E e){
        add(0, e);
    }
    // 在鏈表末尾新增新的元素e
    public void addLast(E e){
        add(size, e);
    }

    // 獲得鏈表的第index(0-based)個位置的元素
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        return get(head, index);
    }
    //在以node為頭節點的鏈表，獲得第index個位置的元素，遞歸演算法
    public E get(Node node, int index){
        if(index ==0){
            return node.e;
        }
        return get(node.next, --index);
    }
    // 獲得鏈表的第一個元素
    public E getFirst(){
        return get(0);
    }

    // 獲得鏈表的最後一個元素
    public E getLast(){
        return get(size - 1);
    }
    // 修改鏈表的第index(0-based)個位置的元素為e
    public void set(int index, E e){
        if(index <0 || index >= size){
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        set(head, index, e);
    }
    // 修改以node為頭結點的鏈表中，第index(0-based)個位置的元素為e，遞歸演算法
    public void set(Node node, int index, E e){
        if(index ==0){
            node.e = e;
            return;
        }
        set(node.next, --index, e);
    }

    // 查找鏈表中是否有元素e
    public boolean contains(E e){
        return contains(head, e);
    }
    // 在以node為頭結點的鏈表中，查找是否存在元素e，遞歸演算法
    public boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if(node.e.equals(e)){
            return true;
        }
        return contains(node.next, e);
    }
    // 從鏈表中刪除index(0-based)位置的元素, 回傳刪除的元素
    public E remove(int index){
        if(index < 0 || index>=size){
            throw new IllegalArgumentException("remove failed. Illegal index.");
        }
        Pair<Node, E> pair= remove(head, index);
        head = pair.getKey();
        size--;
        return pair.getValue();
    }
    // 從以node為頭結點的鏈表中，刪除第index位置的元素，遞歸演算法
    // 回傳值包含兩個元素，刪除後的鏈表頭結點和刪除的值;
    public Pair<Node, E> remove(Node node, int index){
        if(index == 0){
            return new Pair<>(node.next, node.e);
        }
        Pair<Node,E> res = remove(node.next, --index);
        node.next = res.getKey();
        return new Pair<>(node, res.getValue());
    }
    // 從鏈表中刪除第一個元素, 回傳刪除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 從鏈表中刪除最後一個元素, 回傳刪除的元素
    public E removeLast(){
        return remove(size - 1);
    }
    // 從鏈表中刪除元素e
    public void removeElement(E e){
        head = remove(head, e);
    }

    // 從以node為頭結點的鏈表中，刪除元素e，遞歸演算法
    public Node remove(Node node, E e){
        if(node ==null){
            return null;
        }
        if(node.e.equals(e)){
            size--;
            return node.next;
        }
        node.next = remove(node.next, e);
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Head :");
        Node curr = head;
        while(curr != null){
            sb.append(curr.e+"-> ");
            curr = curr.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
    public static void main(String[] args) {

        LinkedList_Recursion<Integer> list = new LinkedList_Recursion<>();
        for(int i = 0 ; i < 5 ; i ++){
            list.addFirst(i);
        }
        System.err.println(list);
        list.add(3,7);
        list.add(4,6);
        list.add(2,3);
        System.err.println(list);
        list.removeElement(3);
        list.remove(5);
        System.err.println(list);
        System.err.println("是否含有7："+list.contains(7));
        System.err.println("是否含有3："+list.contains(3));
        list.set(4,11);
        System.err.println(list);
        System.err.println("位置2的元素值："+list.get(2));

    }
}