public class LinkedListDeque<Item> implements Deque<Item>{

    private class Node {
        public Node prev;
        public Item item;
        public Node next;

        public Node(Node p, Item i, Node n) {
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

    public void addFirst(Item item) {
        Node first = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size ++;
    }

    public void addLast(Item item) {
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

    public Item removeFirst() {
        if(size == 0) return null;
        Item first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size --;
        return first;
    }

    public Item removeLast() {
        if(size == 0) return null;
        Item last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size --;
        return last;
    }

    public Item get(int index) {
        Node p = sentinel;
        while (p.next != sentinel && index > 0) {
            p = p.next;
            index --;
        }
        if (index == 0) return p.item;
        return null;
    }
}
