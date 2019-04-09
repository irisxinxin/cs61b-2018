public class LinkedListDeque<T> implements Deque<T> {
        private TNode sentinel;
        private int size;

        private class TNode<T> {
            private T item;
            private TNode prev;
            private TNode next;

            public TNode(T item, TNode p, TNode n) {
                this.item = item;
                prev = p;
                next = n;
            }
        }
        /* Attention: We should define the sentinel.next and sentinel.prev after
            its instantiation rather than in its instantiation.
         */
        public LinkedListDeque() {
            sentinel = new TNode(null, null, null);
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size = 0;
        }

        @Override
        public void addFirst(T item) {
            TNode node = new TNode(item, sentinel, sentinel.next);
            sentinel.next.prev = node;
            sentinel.next = node;
            size += 1;
        }

        @Override
        public void addLast(T item) {
            TNode node = new TNode(item, sentinel.prev, sentinel);
            sentinel.prev.next = node;
            sentinel.prev = node;
            size += 1;
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

        @Override
        public void printDeque() {
            TNode p = sentinel;
            for (int i = 0; i < size; i++) {
                System.out.print(p.next.item + " ");
            }
        }

        @Override
        public T removeFirst() {
            if (size == 0) {
                return null;
            }
            T res = (T) sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return res;
        }

        @Override
        public T removeLast() {
            if (size == 0) {
                return null;
            }
            T res = (T) sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return res;
        }

        @Override
        public T get(int index) {
            if (size < index + 1) {
                return null;
            }
            TNode p = sentinel;
            for (int i = 0; i < index + 1; i++) {
                p = p.next;
            }
            return (T) p.item;
        }

        public T getRecursive(int index) {
            return (T) getRecursiveHelper(sentinel.next, index);
        }

        private T getRecursiveHelper(TNode node, int index) {
            if (size < index + 1) {
                return null;
            }
            if (index == 0) {
                return (T) node.item;
            }
            return (T) getRecursiveHelper(node.next, index - 1);
        }
    }

