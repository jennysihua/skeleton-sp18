public class ArrayDeque<T> {
    private int size;
    private T[] items;
    double resizeBoundaryLow = .25;
    double resizeBoundaryHigh = .75;
    double rFactorLow = .5;
    double rFactorHigh = 1.5;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
    }

    public T get(int index) {
        return items[index];
    }

    public T add(T item) {
        if (size / items.length > resizeBoundaryHigh) {
            resize((int) rFactorHigh * items.length);
        }
        items[size] = item;
        size ++;
        return item;
    }

    public T remove() {
        if (size / items.length < resizeBoundaryLow) {
            resize((int) rFactorLow * items.length);
        }
        T item = items[size];
        size --;
        items[size] = null;
        return item;
    }

    public int size() {
        return size;
    }

    public void resize(int newSize) {
        T[] newItems = (T[]) new Object[newSize];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }
}