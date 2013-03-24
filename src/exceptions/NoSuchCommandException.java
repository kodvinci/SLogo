package exceptions;

/**
 * No command exception
 * 
 * @author Richard
 * 
 */
public class NoSuchCommandException extends SyntaxException {

    private static final long serialVersionUID = 1L;

    /**
     * No such command exception
     */
    public NoSuchCommandException () {
        super();
    }

    /**
     * no such command exception with message
     * 
     * @param message the exception message
     */
    public NoSuchCommandException (String message) {
        super(message);
    }

}
