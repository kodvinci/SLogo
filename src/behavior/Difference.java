package behavior;

import exceptions.SyntaxException;
import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Difference implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 2) {
            throw new SyntaxException();
        }
        return parameters[0] - parameters[1];
    }

}
