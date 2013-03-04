package behavior;

import exceptions.SyntaxException;
import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Remainder implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 2) { throw new SyntaxException(); }
        int result = (int) parameters[0] % (int) parameters[1];
        return result;
    }

}
