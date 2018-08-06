//Implement with int first - generics later.

public class LinkedListDeque {
    int size;
    int sentinel;

    public LinkedListDeque() {
        size = 0;
    }

    public class Node {
        public Node prev;
        public int item;
        public Node next;

        public Node(Node p, int i, Node n) {
            prev = p;
            item = i;
            next = n;
        }

    }

    public void addFirst(int item) {
        //Add first node here
        size ++;
    }

    public void addLast(int item) {
        //Add last node here
        size ++;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public void printDeque() {

    }

    //Why does type erasure occur?
    public int removeFirst() {
        int item = (int) new Object();
        return item;
    }

    public int removeLast() {
        int item = (int) new Object();
        return item;
    }

    public int get(int index) {
        int item = (int) new Object();
        return item;
        // return null if doesn't exist.
    }

}
