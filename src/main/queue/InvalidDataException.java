package queue;

/**
 *
 * @author Caleb Willson
 */
public class InvalidDataException extends RuntimeException {
    public InvalidDataException (String err) {
        super(err);
    }
}
