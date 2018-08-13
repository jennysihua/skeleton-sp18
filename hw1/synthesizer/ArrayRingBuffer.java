// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    private int getNext(int index) {
        if(index == capacity() - 1) {
            return 0;
        }
        return index + 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        public boolean hasNext() {
            return !isEmpty();
        }

        public T next() {
            return dequeue();
        }

    }

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
        first = capacity - 1;
        last = 0;
        fillCount = 0;
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if(isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last] = x;
        last = getNext(last);
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if(isEmpty()) throw new RuntimeException("Ring Buffer Underflow");
        first = getNext(first);
        T removed = rb[first];
        rb[first] = null;
        fillCount--;
        return removed;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if(isEmpty()) return null;
        return rb[getNext(first)];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
