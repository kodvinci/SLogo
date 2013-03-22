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
        Location newLocation =
                new Location(currentX + getMyValue() * Math.sin(angle), currentY + getMyValue() *
                                                                        Math.cos(angle));
        model.getMyTurtle(turtleNumber).setCenter(newLocation);
        return getMyValue();

    }
}
