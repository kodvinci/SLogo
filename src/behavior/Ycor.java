package behavior;

import slogo.Model;
import view.Canvas;


/**
 * return Y coordinate
 * 
 * @author Jerry
 * 
 */

public class Ycor extends NoParameterCommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        return model.getMyTurtle(turtleNumber).getY() - Canvas.TURTLE_AREA_SIZE.getHeight() / 2;
    }

}
