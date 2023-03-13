package queue;

/**
 * Implementation of the queue interface using an array
 * @author Caleb Willson
 * @param <E> The type of element to be stored
 */
public class ArrayQueue<E> {
    E[] data;
    private int top;
    private int size;
    
    /**
     * Constructor for a default size of 10
     */
    public ArrayQueue() {
        this(10);
    }
    
    /**
     * Constructor
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
        top = 0;
        size = 0;
    }
    
    /**
     * 
     * @param element to be enqueued
     * @throws InvalidDataException when a null element is enqueued
     */
    public void enqueue(E element) throws InvalidDataException {
        if (element == null) {
            throw new InvalidDataException("Null element enqueued");
        }
        
        if (size == data.length) {
            E[] newData = (E[]) new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[(top + i) % data.length];
            }
            data = newData;
            top = 0;
        }
        
        data[(top + size) % data.length] = (E) element;
        size++;
    }
    
    /**
     *
     * @return the front element of the queue and removes that element from the queue
     * @throws QueueEmptyException when the queue is empty
     */
    public E dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException("Dequeue attempted from empty queue");
        }
        
        E poppedData = data[top];
        data[top++] = null;
        size--;
        
        return poppedData;
    }
    
    /**
     *
     * @return the front element of the queue
     * @throws QueueEmptyException when the queue is empty
     */
    public E front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException("Front attempted on empty queue");
        }
        
        return data[top];
    }
    
    /**
     *
     * @return the size of the queue
     */
    public int size() {
        return size;
    }
    
    /**
     *
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
}
