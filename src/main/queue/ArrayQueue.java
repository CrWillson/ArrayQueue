package queue;

/**
 *
 * @author Caleb Willson
 * @param <E>
 */
public class ArrayQueue<E> {
    E[] data;
    private int top;
    private int size;
    
    /**
     *
     */
    public ArrayQueue() {
        this(10);
    }
    
    /**
     *
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
        top = 0;
        size = 0;
    }
    
    /**
     *
     * @param element
     * @throws InvalidDataException
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
        
        data[(top + size) % data.length] = (E)element;
        size++;
    }
    
    /**
     *
     * @return
     * @throws QueueEmptyException
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
     * @return
     * @throws QueueEmptyException
     */
    public E front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException("Front attempted on empty queue");
        }
        
        return data[top];
    }
    
    /**
     *
     * @return
     */
    public int size() {
        return size;
    }
    
    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
}
