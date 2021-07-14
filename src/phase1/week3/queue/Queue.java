package phase1.week3.queue;

public interface Queue <E>{
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
