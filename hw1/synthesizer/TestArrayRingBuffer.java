package synthesizer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testEnqueueDeque() {
        ArrayRingBuffer arb = new ArrayRingBuffer<Integer>(10);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        assertEquals(arb.dequeue(), 1);
        assertEquals(arb.dequeue(), 2);
        assertEquals(arb.dequeue(), 3);
    }

    @Test
    public void testIterator() {
        ArrayRingBuffer arb1 = new ArrayRingBuffer<Integer>(10);
        arb1.enqueue(1);
        arb1.enqueue(2);
        arb1.enqueue(3);
        ArrayRingBuffer arb2 = new ArrayRingBuffer<Integer>(10);
        arb2.enqueue(1);
        arb2.enqueue(2);
        arb2.enqueue(3);
        for (Object item : arb1) {
            assertEquals(item, arb2.dequeue());
        }
    }

    @Test(expected = RuntimeException.class)
    public void testExceptions() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(3);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
