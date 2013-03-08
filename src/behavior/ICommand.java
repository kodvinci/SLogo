package behavior;

import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public interface ICommand {

    /**
     * Move the turtle
     * 
     * @param turtle The turtle object
     * @param parameters the parameters
     * @return return command
     * @throws SyntaxException syntax exception
     */
    public abstract double move (Model model, int TurtleNumber) throws SyntaxException;

}
