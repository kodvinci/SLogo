package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Left extends OneParameterCommand {

    /**
     * the parameter number of this certain command
     */
    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {

        double angle = model.getMyTurtle(turtleNumber).getAngle();
        System.out.println("Original angle: " + angle);
        model.getMyTurtle(turtleNumber).setAngle(angle + getMyValue());
        System.out.println("Final angle: " + model.getMyTurtle(turtleNumber).getAngle());
        return getMyValue();
    }
}
