//It appears that T can only be defined in instance creation.
//This makes sense, no need for generics for static variables.
//Why does type erasure occur?

public class LinkedListDeque<T> {
    int size;

    public class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public Node sentinel = new Node(null, null, null);

    public LinkedListDeque() {
        size = 0;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        Node first = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size ++;
    }

    public void addLast(T item) {
        Node last = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size ++;
    }

    public boolean isEmpty() {
        if(sentinel.next == sentinel) return false;
        return true;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        String deque = "";
        Node p = sentinel;
        while (p.next != sentinel) {
            deque += p.item.toString();
        }
        System.out.println(deque);
    }

    public T removeFirst() {
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return first;
    }

    public T removeLast() {
        T last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return last;
    }

    public T get(int index) {
        int item = (int) new Object();
        Node p = sentinel;
        while (p.next != sentinel && index > 0) {
            p = p.next;
        }
        if (index == 0) return p.item;
        return null;
    }

}
