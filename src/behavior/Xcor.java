package behavior;

import object.Turtle;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Xcor implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 0) { throw new SyntaxException(); }
        return turtle.getX() - Turtle.DEFAULT_SIZE.width / 2;
    }

}
