package exceptions;

/**
 * 
 * @author Richard
 * 
 */
public class ParameterException extends Exception {

    /**
     * set serial version ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Throws Parameter exception
     */
    public ParameterException () {

    }

    /**
     * Throws parameter exception with message
     * 
     * @param message The exception message
     */

    public ParameterException (String message) {
        super(message);
    }

}
