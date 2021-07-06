package phase1.week3.array;

/**
 * 索引沒有語意，如何表示沒有元素？
 * 如何加入、刪除元素？
 */
public class Array<E> {

    private E[] data;

    //array中實際的元素數量
    private int size;

    /**
     * 無參建構子，預設陣列的容量capacity為10
     */
    public Array() {
        this(10);
    }

    /**
     * 建構子，傳入陣列的容量capacity建構Array
     *
     * @param capacity
     */
    public Array(int capacity){
        //data = new E[capacity]; //java 中無法
        data = (E[])(new Object[capacity]);
        size = 0;
    }

    //獲取陣列中的元素個數
    public int getSize() {
        return size;
    }

    //獲取陣列容量
    public int getCapacity() {
        return data.length;
    }

    //回傳陣列是否為空
    public boolean isEmpty() {
        return size == 0;
    }

    //在所有元素前面加入一個元素
    public void addFirst(E e) {
        add(0, e);
    }

    //向所有元素後加入一個新元素
    public void addLast(E e) {
        add(size, e);
    }

    //在第index個位置插入一個新元素e
    public void add(int index, E e) {

        if (size == data.length)
            throw new IllegalArgumentException("AddLast failed.Array is full.");
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Require index >= 0 and index <= size");

        //每個元素都向後移一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;

    }

    //獲取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is illegal");
        return data[index];
    }

    //修改index髓飲位置的元素為e
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed.Index is illegal");
        data[index] = e;
    }

    //查詢陣列中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //查詢陣列中元素e所在的索引，如果不存在元素e，則回傳-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //從陣列中刪除index位置的元素，回傳刪除的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed.Index is illegal");
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; //loitering objects != memory leak
        return ret;
    }

    //從陣列中刪除第一個元素，回傳刪除的元素
    public E removeFirst() {
        return remove(0);
    }

    //從陣列中刪除最後一個元素，回傳刪除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    //從陣列中刪除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
