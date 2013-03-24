package exceptions;

public class TurtleOutOfBoundaryException extends SyntaxException {

   
    /**
     * 
     */
    private static final long serialVersionUID = -6345483386568318198L;

    /**
     * Throws Parameter exception
     */
    public TurtleOutOfBoundaryException() {

    }

    /**
     * Throws parameter exception with message
     * 
     * @param message The exception message
     */

    public TurtleOutOfBoundaryException (String message) {
        super(message);
    }
}
