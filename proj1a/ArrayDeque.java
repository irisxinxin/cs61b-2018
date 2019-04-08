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
        if (size == 0){
            tail = 0;
        } else {
            tail = size - 1;
        }
    }

      // Using circular method and simplifying conditional choice by %
    // This method is served to get the indices that need to minus one
    private int minusOne(int index){
        if (index == 0){
            index = item.length - 1;
        } else {
            index = (index - 1) % item.length;
        }
        return index;
    }

    // This method is served to get the indices that need to add one
    private int addOne(int index){
        index = (index + 1) % item.length;
        return index;
    }

    public void addFirst(T obj){
        if (size == item.length){
            resize(size * 2);
        }
        if (size == 0){
            item[head] = obj;
            item[tail] = obj;
            size++;
        } else {
        head = minusOne(head);
        item[head] = obj;
        size++;
        }
    }

    public void addLast(T obj){
        if (size == item.length){
            resize(size * 2);
        }
        if (size == 0){
            item[head] = obj;
            item[tail] = obj;
            size++;
        } else {
        tail = addOne(tail);
        item[tail] = obj;
        size++;
        }
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        } else {
            return false;
        }
    }

    public int size(){
        return size;
    }

    // Special case : the AList is empty.  >> means to devide by 4

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        T res = item[head];
        item[head] = null;
        size--;
        if (size == 0){
            resize( 1);
            return res;
        }
        head = addOne(head);
        if (size < 0.25 * item.length && size != 0){
            resize( item.length >> 2);
        }
        return res;
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T res = item[tail];
        item[tail] = null;
        size --;
        if (size == 0){
             resize( 1);
             return res;
        }
        tail = minusOne(tail);
        if (size < 0.25 * item.length && size != 0){
            resize( item.length >> 2);
        }
        return res;
    }

    public void printDeque(){
        if (head <= tail){
            for (int i = head; i < tail + 1; i++) {
                System.out.print(item[i] + " ");
            }
        } else {
                for (int i = head; i < item.length - 1; i++){
                    System.out.print(item[i] + " ");
                }
                for (int i = 0; i < tail + 1; i++){
                    System.out.print(item[i] + " ");
                }
            }
        }

    public T get(int index){
        if (index > size - 1){
        return null;
        } else {
            int realIndex = head + index <= item.length - 1 ? (head + index) : (index - (item.length - head));
            return item[realIndex];
        }
    }

//    public static void main(String[] args) {
//        ArrayDeque<Integer> list = new ArrayDeque<>();
////        for (int i = 0; i < 8; i++) {
////            list.addFirst(i);
////        }
////        Integer a = list.get(7);
////        Integer c = list.get(8);   // Integer can be null, but int cannot
////        for (int i = 0; i < 8; i++) {
////            list.addLast(i);
////        }
//        // list.printDeque();
//
////        list.addLast(0);
////        list.removeLast();
////        list.addLast(2);
////        list.removeLast()  ;
////        list.addLast(4);
////        list.addLast(5);
////        list.isEmpty();
////        list.addLast(7);
////        list.removeLast()  ;
////        list.removeLast();
////        Integer b = list.get(6);
////        System.out.print(b);
//
//
////        list.removeLast();
////        list.removeFirst();
////        for (int i = 0; i < 8; i++) {
////            list.removeFirst();
////        }
////        for (int i = 0; i < 8; i++) {
////            list.removeLast();
////        }
//
//
////        list.addLast(0);
////        list.isEmpty();
////        list.removeFirst()   ;
////        list.addLast(3);
////        list.addLast(4);
////        list.addLast(5);
////        list.addLast(6);
////        list.addLast(7);
////        list.addLast(8);
////        Integer a = list.removeFirst();
////        System.out.println(a);
//
//        list.addFirst(0);
//        list.addFirst(1);
//        list.removeLast();
//        Integer a = list.get(0);
//        list.addLast(4);
//        list.addFirst(5);
//        list.get(1);
//        list.removeLast();
//        Integer b = list.get(0);
//        System.out.println(a);
//        System.out.println(b);
//    }
}
