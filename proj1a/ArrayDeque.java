import java.util.Arrays;

public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;
    double resizeBoundaryLow = .25;
    double resizeBoundaryHigh = .6;
    double USAGE_FACTOR = .5;
    double RESIZE_FACTOR = 2;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 0;
    }

    public T get(int index) {
        return items[index];
    }

    public T addFirst(T item) {
        if ((size / (double) items.length) > resizeBoundaryHigh) {
            resize((int) (RESIZE_FACTOR * items.length));
        }

        if (nextFirst == nextLast) {
            nextLast = getNext(nextLast);
        }

        items[nextFirst] = item;
        size ++;
        nextFirst = getPrev(nextFirst);
        return item;
    }

    public T addLast(T item) {
        if ((size / (double) items.length) > resizeBoundaryHigh) {
            resize((int) (RESIZE_FACTOR * items.length));
        }

        if (nextFirst == nextLast) {
            nextFirst = getPrev(nextFirst);
        }

        items[nextLast] = item;
        size ++;
        nextLast = getNext(nextLast);
        return item;
    }

    public T removeFirst() {
        if (size / (double) items.length < resizeBoundaryLow) {
            resize((int) (USAGE_FACTOR * items.length));
        }

        T item = items[getNext(nextFirst)];
        size --;
        items[getNext(nextFirst)] = null;
        nextFirst = getNext(nextFirst);
        return item;
    }

    public T removeLast() {
        if (size / (double) items.length < resizeBoundaryLow) {
            resize((int) (USAGE_FACTOR * items.length));
        }
        T item = items[getPrev(nextLast)];
        items[getPrev(nextLast)] = null;
        nextLast = getPrev(nextLast);
        size --;
        return item;
    }

    public int getNext(int index) {
        return ((index + 1) % items.length + items.length) % items.length;
    }

    public int getPrev(int index) {
        return ((index - 1) % items.length + items.length) % items.length;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        String deque = "";
        int counter = 0;
        while(counter != size) {
            deque += items[(nextFirst + 1 + counter) % items.length].toString();
            counter ++;
        }
    }

    public void resize(int newSize) {
        T[] newItems = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(getNext(nextFirst) + i) % items.length];
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public static void main (String[] args) {
        ArrayDeque test = new ArrayDeque();
        for(int i = 0; i < 3; i++) {
            test.addFirst(i);
            System.out.println(Arrays.toString(test.items));
        }
        for(int i = 3; i < 8; i++) {
            test.addLast(i);
            System.out.println(Arrays.toString(test.items));
        }
        for(int i = 0; i < 3; i++) {
            test.removeFirst();
            System.out.println(Arrays.toString(test.items));
        }
        for(int i = 0; i < 3; i++) {
            test.removeLast();
            System.out.println(Arrays.toString(test.items));
        }

    }

    //getRecursive
}