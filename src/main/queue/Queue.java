package queue;

/**
 *
 * @author Caleb Willson
 */
public interface Queue<E> { 
    public void enqueue (E element) throws InvalidDataException; 
    public E dequeue () throws QueueEmptyException; 
    public E front () throws QueueEmptyException; 
    public int size(); 
    public boolean isEmpty(); 
} 
