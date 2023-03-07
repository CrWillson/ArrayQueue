package queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Caleb Willson
 */
public class ArrayQueueTest {
    
    public ArrayQueueTest() {
    }
    
    /**
     * Test that the isEmpty method works
     */
    @Test
    public void testIsEmpty() {
        ArrayQueue<Integer> q = new ArrayQueue<>(5);
        q.enqueue(1);
        q.dequeue();
        
        assertTrue(q.isEmpty());
    }
    
    /**
     * Test that the front method works
     */
    @Test
    public void testFront() {
        ArrayQueue<Integer> q = new ArrayQueue<>(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        
        int expected = 1;
        int actual = q.front();
        assertEquals(expected, actual);
    }
    
    /**
     * Test that the size method works
     */
    @Test
    public void testSize() {
        ArrayQueue<Integer> q = new ArrayQueue<>(10);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        
        int expected = 3;
        int actual = q.size();
        assertEquals(expected, actual);
    }
    
    /**
     * Test the queue resizing when full.
     */
    @Test
    public void testResize() {
        ArrayQueue<Integer> q = new ArrayQueue<>(3);
        
        for (int i = 1; i <= 10; i++) {
            q.enqueue(i);
        }
        
        Object expected[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, null};
        Object actual[] = q.data;
        
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
    
    /**
     * Test that the array wraps around.
     */
    @Test
    public void testWrapping() {
        ArrayQueue<Integer> q = new ArrayQueue<>(3);
        
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.enqueue(3);
        q.enqueue(4);
        
        Object expected[] = {4, 2, 3};
        Object actual[] = q.data;
        
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
    
    /**
     * Test that the queue is resized properly after wrapping around.
     */
    @Test
    public void testWrapAndResize() {
        ArrayQueue<Integer> q = new ArrayQueue<>(3);
        
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        
        Object expected[] = {2, 3, 4, 5, null, null};
        Object actual[] = q.data;
        
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
    
    /**
     * Test that an exception is thrown when dequeueing from an empty queue.
     */
    @Test
    public void testQueueEmptyDequeue() {
        ArrayQueue<Integer> q = new ArrayQueue<>(3);
        
        Exception exception = assertThrows(QueueEmptyException.class, () -> {
            q.dequeue();
        });
        
        String expectedMessage = "Dequeue attempted from empty queue";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    /**
     * Test that an exception is thrown when calling front on an empty queue.
     */
    @Test
    public void testQueueEmptyFront() {
        ArrayQueue<Integer> q = new ArrayQueue<>(3);
        
        Exception exception = assertThrows(QueueEmptyException.class, () -> {
            q.front();
        });
        
        String expectedMessage = "Front attempted on empty queue";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    /**
     * Test that an exception is thrown when enqueueing a null element.
     */
    @Test
    public void testEnqueueNull() {
        ArrayQueue<Integer> q = new ArrayQueue<>(3);
        
        Exception exception = assertThrows(InvalidDataException.class, () -> {
            q.enqueue(null);
        });
        
        String expectedMessage = "Null element enqueued";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
