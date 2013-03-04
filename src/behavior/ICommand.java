package behavior;

import exceptions.SyntaxException;
import object.Turtle;


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
    public abstract double move (Turtle turtle, double[] parameters) throws SyntaxException;

}
