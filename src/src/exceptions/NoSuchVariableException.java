package exceptions;

/**
 * 
 * @author Richard Yang
 * 
 */

public class NoSuchVariableException extends SyntaxException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * No such variable exception
     */
    public NoSuchVariableException () {
        super();
    }

    /**
     * no such variable exception with message
     * 
     * @param message the exception message
     */
    public NoSuchVariableException (String message) {
        super(message);
    }

}
