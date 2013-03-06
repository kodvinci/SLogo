package exceptions;

public class NoSuchCommandException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * No such variable exception
     */
    public NoSuchCommandException () {
        super();
    }

    /**
     * no such variable exception with message
     * 
     * @param message the exception message
     */
    public NoSuchCommandException (String message) {
        super(message);
    }
}
