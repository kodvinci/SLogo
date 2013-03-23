package behavior;

import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Left extends OneParameterCommand {

    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        double angle = model.getMyTurtle(turtleNumber).getAngle();
        System.out.println("Original angle: " + angle);
        model.getMyTurtle(turtleNumber).setAngle(angle + getMyValue());
        System.out.println("Final angle: " + model.getMyTurtle(turtleNumber).getAngle());
        return getMyValue();
    }
}
