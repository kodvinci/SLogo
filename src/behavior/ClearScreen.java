package behavior;

import object.Turtle;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class ClearScreen implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 0) {
            throw new SyntaxException();
        }
        else {
            turtle.clearTrail();
            turtle.initialize();
        }
        return Math.sqrt(Math.pow(turtle.getX() - (Turtle.DEFAULT_SIZE.width / 2), 2) +
                         Math.pow(turtle.getY() - Turtle.DEFAULT_SIZE.height / 2, 2));
    }

}
