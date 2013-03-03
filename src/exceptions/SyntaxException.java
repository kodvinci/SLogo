package exceptions;

/**
 * Syntax exceptions when wrong commands are typed
 * 
 * @author Richard Yang
 * 
 */

public class SyntaxException extends Exception {

    /**
     * set serial version ID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Syntax exception
     */
    public SyntaxException () {
        super();
    }
    
    /**
     * Syntax exception with message
     * @param message   the string message
     */
    public SyntaxException (String message) {
        super(message);
    }

}
