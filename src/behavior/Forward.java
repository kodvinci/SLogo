package behavior;

import slogo.Model;
import util.Location;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Forward extends OneParameterCommand {

    /**
     * the parameter number of this ceratin command
     */

    public static final int PARAMETER_NUMBER = 1;

    /**
     * the parameter number of pi
     */
    public static final int CIRCLE_CONSTANT = 180;

    @Override
    public double move (Model model, int turtleNumber) {
        double currentX = model.getMyTurtle(turtleNumber).getX();
        double currentY = model.getMyTurtle(turtleNumber).getY();
        double angle = model.getMyTurtle(turtleNumber).getAngle();
        double angleInDegrees = (angle * Math.PI) / CIRCLE_CONSTANT;
        Location newLocation =
                new Location(currentX - getMyValue() * (Math.sin(angleInDegrees)),
                             currentY + (-1 * getMyValue()) *
                                     Math.cos(angleInDegrees));
        model.getMyTurtle(turtleNumber).setCenter(newLocation);
        return getMyValue();

    }
}
