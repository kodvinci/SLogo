package exceptions;

import slogo.Controller;

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
    private Controller myController;

    /**
     * Syntax exception
     */
    public NoClassException () {
        super();
        myController = new Controller();
    }

    /**
     * Syntax exception with message
     * 
     * @param message the string message
     */
    public NoClassException (String message) {
        super(message);
        myController.showMessage(message);
    }

}
