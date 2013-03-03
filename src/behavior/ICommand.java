package behavior;

import exceptions.SyntaxException;
import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public interface ICommand {
    public abstract double move (Turtle turtle, double[] parameters) throws SyntaxException;

    

}
