package behavior;

import slogo.Model;
import util.Location;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Forward extends OneParameterCommand {

    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        double currentX = model.getMyTurtle(turtleNumber).getX();
        double currentY = model.getMyTurtle(turtleNumber).getY();
        double angle = model.getMyTurtle(turtleNumber).getAngle();
        double angleInDegrees = (angle * Math.PI) / 180;
        Location newLocation =
                new Location(currentX - getMyValue() * (Math.sin(angleInDegrees)),
                             currentY + (-1 * getMyValue()) *
                                     Math.cos(angleInDegrees));
        model.getMyTurtle(turtleNumber).setCenter(newLocation);
        System.out.println("final value of back: " + getMyValue());
        return getMyValue();

    }
}
