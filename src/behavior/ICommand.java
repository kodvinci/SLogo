package behavior;

import object.Turtle;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public interface ICommand {
    public abstract double move (Turtle turtle, double[] parameters) throws SyntaxException;

}
