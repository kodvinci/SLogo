package behavior;

import exceptions.SyntaxException;
import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public class ShowingP implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 0) {
            throw new SyntaxException();
        }
        return turtle.isVisible() ? 1 : 0;
    }

}
