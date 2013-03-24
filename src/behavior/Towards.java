package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Towards extends TwoParameterCommand {

    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) {

        double x = getMyFirstValue();
        double y = getMySecondValue();
        double deltaX = x - model.getMyTurtle(turtleNumber).getX();
        double deltaY = y - model.getMyTurtle(turtleNumber).getY();
        double currentAngle = Math.atan(deltaX / deltaY);
        double difference = currentAngle - model.getMyTurtle(turtleNumber).getAngle();
        model.getMyTurtle(turtleNumber).setAngle(currentAngle);
        return difference;
    }

}
