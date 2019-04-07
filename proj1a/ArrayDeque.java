public class ArrayDeque<T> {
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

    public void resize(int capacity) {
        T[] resizedItem = (T[]) new Object[capacity];
        if (head <= tail) {
            System.arraycopy(item, head, resizedItem, 0, tail - head + 1);
        } else {
            System.arraycopy(item, head, resizedItem, 0, item.length - head);
            System.arraycopy(item, 0, resizedItem, item.length - head, tail + 1);
        }
        item = resizedItem;
        head = 0;
        tail = size - 1;
    }

      // Using circular method and simplifying conditional choice by %
    // This method is served to get the indices that need to minus one
    public int minusOne(int index){
        if(index == 0){
            index = item.length - 1;
        }else{
            index = (index - 1) % item.length;
        }
        return index;
    }

    // This method is served to get the indices that need to add one
    public int addOne(int index){
        index = (index + 1) % item.length;
        return index;
    }

    public void addFirst(T obj){
        if(size == item.length ){
            resize(size * 2);
        }
        if(size == 0){
            item[head] = obj;
            item[tail] = obj;
            size ++;
        }else{
        head = minusOne(head);
        item[head] = obj;
        size ++;}
    }

    public void addLast(T obj){
        if(size == item.length){
            resize(size * 2);
        }
        if(size == 0){
            item[head] = obj;
            item[tail] = obj;
            size ++;
        }else{
        tail = addOne(tail);
        item[tail] = obj;
        size ++;}
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    // Special case : the AList is empty.  >> means to devide by 4

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T res = item[head];
        item[head] = null;
        head = addOne(head);
        size --;
        if( size < 0.25 * item.length){
            resize( item.length >> 2);
        }
        return res;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T res = item[tail];
        item[tail] = null;
        tail = minusOne(tail);
        size --;
        if( size < 0.25 * item.length){
            resize( item.length >> 2);
        }
        return res;
    }

    public void printDeque(){
        if( head <= tail) {
            for (int i = head; i < tail + 1; i++) {
                System.out.print(item[i] + " ");
            }
        }else{
                for(int i = head; i < item.length - 1; i++){
                    System.out.print(item[i] + " ");
                }
                for(int i = 0; i < tail + 1; i++){
                    System.out.print(item[i] + " ");
                }
            }
        }

    public T get(int index){
        if(index > size - 1){
        return null;
        } else{
            int realIndex = head + index < item.length - 1 ? (head + index) : (index - (item.length - head));
            return item[realIndex];
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            list.addFirst(i);
        }
        Integer a = list.get(7);
        Integer c = list.get(8);   // Integer can be null, but int cannot
        for (int i = 8; i < 17; i++) {
            list.addLast(i);
        }
        // list.printDeque();
        int b = list.get(6);
        list.removeLast();
        list.removeFirst();
        for (int i = 0; i < 8; i++) {
            list.removeFirst();
        }
        for (int i = 0; i < 8; i++) {
            list.removeLast();
        }
    }
}
