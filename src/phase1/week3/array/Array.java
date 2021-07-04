package phase1.week3.array;

/**
 * 索引沒有語意，如何表示沒有元素？
 * 如何加入、刪除元素？
 */
public class Array {

    private int[] data;

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
    public Array(int capacity) {
        data = new int[capacity];
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
    public void addFirst(int e){
        add(0,e);
    }

    //向所有元素後加入一個新元素
    public void addLast(int e) {
        add(size,e);
    }

    //在第index個位置插入一個新元素e
    public void add(int index, int e) {

        if (size == data.length)
            throw new IllegalArgumentException("AddLast failed.Array is full.");
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Require index >= 0 and index <= size");

        //每個元素都向後移一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index]=e;
        size++;

    }
    //獲取index索引位置的元素
    int get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is illegal");
        return  data[index];
    }

    //修改index髓飲位置的元素為e
    void set(int index,int e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed.Index is illegal");
        data[index]=e;
    };

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d , capacity = %d\n",size,data.length));
        res.append('[');
        for(int i = 0 ;i < size ; i++){
            res.append(data[i]);
            if(i != size -1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}