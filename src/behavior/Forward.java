package behavior;

import exceptions.SyntaxException;
import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Forward implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 1) {
            throw new SyntaxException();
        }
        else {
            double distance = parameters[0];
            double angle = turtle.getMyAngle();
            double newX = turtle.getX() + distance * Math.sin(angle);
            double newY = turtle.getY() + distance * Math.cos(angle);
            turtle.setCenter(newX, newY);
            return distance;
        }
    }

}
