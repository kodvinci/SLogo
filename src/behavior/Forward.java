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

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        double currentX = model.getMyTurtle(turtleNumber).getX();
        double currentY = model.getMyTurtle(turtleNumber).getY();
        double angle = model.getMyTurtle(turtleNumber).getMyAngle();
        Location newLocation =
                new Location(currentX + getMyValue() * Math.sin(angle), currentY + getMyValue() *
                                                                        Math.cos(angle));
        model.getMyTurtle(turtleNumber).setCenter(newLocation);
        return getMyValue();

    }
}