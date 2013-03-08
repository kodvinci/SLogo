package behavior;

import object.Turtle;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Left implements ICommand {

    private final int myDelt = 180;

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 1) {
            throw new SyntaxException();
        }
        else {
            double angle = parameters[0];
            double deltaAngle = angle * Math.PI / myDelt;
            turtle.setMyAngle(angle - deltaAngle);
            return angle;
        }
    }
}
