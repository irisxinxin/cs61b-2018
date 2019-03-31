public class LinkedListDeque<T> {
    private TNode sentinel;
    private int size;


    public class TNode<T> {
        public T item;
        public TNode prev;
        public TNode next;

        public TNode(T item, TNode p, TNode n) {
            this.item = item;
            prev = p;
            next = n;
        }
    }
/* Attention: We should define the sentinel.next and sentinel.prev after
    its instantiation rather than in its instantiation.
 */
    public LinkedListDeque(){
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item){
        sentinel.next = new TNode(item, sentinel, sentinel.next);
        size += 1;
    }

    public void addLast(T item){
        sentinel.prev = new TNode(item, sentinel.prev, sentinel);
        size += 1;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        TNode p = sentinel;
        for(int i = 0; i < size ; i++){
            System.out.print(sentinel.next.item + " ");
        }
    }

    public T removeFirst(){
        T res = (T) sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return res;
    }

    public T removeLast(){
        T res = (T) sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return res;
    }

    public T get(int index){
        if(size < index - 1){
            return null;
        }
        TNode p = sentinel;
        for(int i = 0; i < index; i ++){
            p = p.next;
        }
        return (T)p.item;
    }

    public T getRecursive(int index){
        if(size < index - 1){
            return null;
        }
        if(index == 0){
            return (T) sentinel.next.item;
        }
        return getRecursive(index - 1);
    }

}
