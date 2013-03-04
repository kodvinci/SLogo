package behavior;

import object.Turtle;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class SetXY implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 2)
            throw new SyntaxException();
        else {
            double newX = parameters[0];
            double newY = parameters[1];
            turtle.setCenter(newX, newY);
            return Math.sqrt(Math.pow(newX - turtle.getX() + Turtle.DEFAULT_SIZE.width / 2, 2) +
                             Math.pow(newY - turtle.getY() + Turtle.DEFAULT_SIZE.height / 2, 2));
        }

    }

}
