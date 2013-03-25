package exceptions;

import slogo.Controller;

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
    private Controller myController;
    /**
     * Syntax exception
     */
    public SyntaxException () {
        super();
        myController = new Controller();
    }

    /**
     * Syntax exception with message
     * 
     * @param message the string message
     */
    public SyntaxException (String message) {
        super(message);
        myController.showMessage(message);
    }

}
