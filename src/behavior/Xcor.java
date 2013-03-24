package behavior;

import slogo.Model;
import view.Canvas;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Xcor extends NoParameterCommand {

    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        return model.getMyTurtle(turtleNumber).getX() - Canvas.TURTLE_AREA_SIZE.getWidth() / 2;
    }

}
