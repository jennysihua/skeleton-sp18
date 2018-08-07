//It appears that T can only be defined in instance creation.
//This makes sense, no need for generics for static variables.
//Why does type erasure occur?

public class LinkedListDeque<T> {

    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
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
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        String deque = "";
        Node p = sentinel.next;
        System.out.println(p.item);
        while (p.next != sentinel) {
            deque += p.item.toString();
            p = p.next;
        }
    }

    public T removeFirst() {
        if(size == 0) return null;
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size --;
        return first;
    }

    public T removeLast() {
        if(size == 0) return null;
        T last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size --;
        return last;
    }

    public T get(int index) {
        Node p = sentinel;
        while (p.next != sentinel && index > 0) {
            p = p.next;
            index --;
        }
        if (index == 0) return p.item;
        return null;
    }

    //Have not tested this recursive method.
    public T getRecursive(int index) {
        if(sentinel.next == sentinel) return null;
        if(index == 0) return sentinel.next.item;
        LinkedListDeque<T> innerList = new LinkedListDeque();
        innerList.sentinel.next = this.sentinel.next.next;
        return innerList.getRecursive(index - 1);
        //Better to write a recursive "traverse" helper method that takes in node, index.
    }
}
