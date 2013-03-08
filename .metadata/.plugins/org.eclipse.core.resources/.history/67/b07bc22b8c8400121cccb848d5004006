package behavior;

import object.Turtle;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class SetHeading implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 1)
            throw new SyntaxException();
        else {
            double angle = parameters[0];
            turtle.setMyAngle(angle);
            return angle - turtle.getMyAngle();
        }
    }

}
