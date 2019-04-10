package synthesizer;
import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T> {
    int capacity();     // return size of the buffer
    int fillCount();    // return number of items currently in the buffer
    void enqueue(T x);  // add item x to the end
    T dequeue();        // delete and return item from the front
    T peek();           // return (but do not delete) item from the front

    default boolean isEmpty() {
        int fillCnt = fillCount();
        return fillCnt == 0;
    }


    default boolean isFull() {
        int fillCnt = fillCount();
        int cap = capacity();
        return fillCnt == cap;
    }

    Iterator<T> iterator();
 }
