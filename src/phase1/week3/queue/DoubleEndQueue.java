package phase1.week3.queue;

/**
 * 使用size表示元素數量，不浪費空間
 *
 * @param <E>
 */
public class DoubleEndQueue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public DoubleEndQueue() {
        this(10);
    }

    public DoubleEndQueue(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];

        data = newData;
        front = 0;
        tail = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //addLast 跟之前實現Queue中的enqueue 的邏輯是一樣的
    public void addLast(E e) {
        if (size == getCapacity())
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public void addFront(E e) {
        if (size == getCapacity())
            resize(getCapacity() * 2);
        //首先先確定加入的位置
        //front -1
        //但是如果 front == 0 ,新的位置是 data.length -1 的位置
        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = e;
        size++;
    }

    //與queue中的dequeue 的邏輯是一樣的
    public E removeFront() {
        if (isEmpty())
            throw new IllegalArgumentException("cannot dequeue from an empty queue");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (getSize() == data.length / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    //removeLast 為新方法
    public E removeLast() {
        if (isEmpty())
            throw new IllegalArgumentException("cannot dequeue from an empty queue");

        //計算刪除掉 tail 後 新tail的位置
        tail = tail == 0 ? data.length - 1 : tail - 1;
        E ret = data[tail];
        data[tail] = null;
        size--;
        if (getSize() == data.length / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return data[front];
    }

    //因為是DoubleEndQueue，也偶一個getLast方法 ，來去的尾端元素的值
    public E getLast() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        //因為tail指向的是尾部元素的下一個位置，我們需要計算一下真正隊尾元素的索引
        int index = tail == 0 ? data.length - 1 : tail - 1;
        return data[index];
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size=%d , capacity = %d\n", getSize(), getCapacity()));
        res.append(" front[");
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        //在下面的DoubleEnd的測試中，偶數從尾部加入，奇數從首部加入
        DoubleEndQueue<Integer> deq = new DoubleEndQueue<>();
        for (int i = 0; i < 16; i++) {
            if ((i % 2) == 0) deq.addLast(i);
            else deq.addFront(i);
            System.out.println(deq);
        }
        //依次從首部和尾部輪流刪除元素
        for (int i = 0; i < 16; i++) {
            if ((i % 2) == 0) deq.removeLast();
            else deq.removeFront();
            System.out.println(deq);
        }

    }


}

