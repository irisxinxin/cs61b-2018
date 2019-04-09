public class ArrayDeque<T> implements Deque<T> {
    private T[] item;
    private int size;
    private int head;
    private int tail;

    public ArrayDeque() {
        item = (T[]) new Object[8];
        size = 0;
        head = 0;
        tail = 0;
    }

    private void resize(int capacity) {
        T[] resizedItem = (T[]) new Object[capacity];
        if (head <= tail) {
            System.arraycopy(item, head, resizedItem, 0, tail - head + 1);
        } else {
            System.arraycopy(item, head, resizedItem, 0, item.length - head);
            System.arraycopy(item, 0, resizedItem, item.length - head, tail + 1);
        }
        item = resizedItem;
        head = 0;
        if (size == 0) {
            tail = 0;
        } else {
            tail = size - 1;
        }
    }

    // Using circular method and simplifying conditional choice by %
    // This method is served to get the indices that need to minus one
    private int minusOne(int index) {
        if (index == 0) {
            index = item.length - 1;
        } else {
            index = (index - 1) % item.length;
        }
        return index;
    }

    // This method is served to get the indices that need to add one
    private int addOne(int index) {
        index = (index + 1) % item.length;
        return index;
    }

    @Override
    public void addFirst(T obj) {
        if (size == item.length) {
            resize(size * 2);
        }
        if (size == 0) {
            item[head] = obj;
            item[tail] = obj;
            size++;
        } else {
            head = minusOne(head);
            item[head] = obj;
            size++;
        }
    }

    @Override
    public void addLast(T obj) {
        if (size == item.length) {
            resize(size * 2);
        }
        if (size == 0) {
            item[head] = obj;
            item[tail] = obj;
            size++;
        } else {
            tail = addOne(tail);
            item[tail] = obj;
            size++;
        }
    }
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    // Special case : the AList is empty.  >> means to devide by 4

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = item[head];
        item[head] = null;
        size--;
        if (size == 0) {
            resize(1);
            return res;
        }
        head = addOne(head);
        if (size < 0.25 * item.length && size != 0) {
            resize(item.length >> 2);
        }
        return res;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T res = item[tail];
        item[tail] = null;
        size--;
        if (size == 0) {
            resize(1);
            return res;
        }
        tail = minusOne(tail);
        if (size < 0.25 * item.length && size != 0) {
            resize(item.length >> 2);
        }
        return res;
    }

    @Override
    public void printDeque() {
        if (head <= tail) {
            for (int i = head; i < tail + 1; i++) {
                System.out.print(item[i] + " ");
            }
        } else {
            for (int i = head; i < item.length - 1; i++) {
                System.out.print(item[i] + " ");
            }
            for (int i = 0; i < tail + 1; i++) {
                System.out.print(item[i] + " ");
            }
        }
    }

    @Override
    public T get(int index) {
        if (index > size - 1) {
            return null;
        } else {
            int realIndex = head + index <= item.length - 1 ?
                    (head + index) : (index - (item.length - head));
            return item[realIndex];
        }
    }
}

