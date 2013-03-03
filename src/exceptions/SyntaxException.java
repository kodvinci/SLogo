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

    public SyntaxException () {
        super();
    }

    public SyntaxException (String message) {
        super(message);
    }

}
