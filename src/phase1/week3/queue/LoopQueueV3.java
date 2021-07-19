package phase1.week3.queue;

/**
 * 完全不使用size
 *
 * @param <E>
 */
public class LoopQueueV3<E> implements Queue<E> {

    private E[] data;
    private int front, tail;

    public LoopQueueV3() {
        this(10);
    }

    public LoopQueueV3(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        //注意此時的getSize的邏輯
        //如果tail >= front -> Queue中的元素就是 tail - front
        //如果tail < front ，說明我們的queue"循環"起來了，此時，Queue中的元素個數為
        //tail - front + date.length
        //也可以理解為，此時data中沒有元素的數目為front - tail
        //整體元素個數就是 data.length - (front - tail) = data.length

        return tail >= front ? tail - front : tail - front + data.length;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == getCapacity())
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        int sz = getSize();
        for (int i = 0; i < sz; i++)
            newData[i] = data[(i + front) % data.length];
        data = newData;
        front = 0;
        tail = sz;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size=%d , capacity = %d\n", getSize(), getCapacity()));
        res.append(" front[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueueV3<Integer> queue = new LoopQueueV3<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
