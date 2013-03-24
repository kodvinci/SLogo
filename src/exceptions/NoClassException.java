package exceptions;

/**
 * Syntax exceptions when wrong commands are typed
 * 
 * @author Richard Yang
 * 
 */

public class NoClassException extends Exception {

    /**
     * set serial version ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Syntax exception
     */
    public NoClassException () {
        super();
    }

    /**
     * Syntax exception with message
     * 
     * @param message the string message
     */
    public NoClassException (String message) {
        super(message);
    }

}
