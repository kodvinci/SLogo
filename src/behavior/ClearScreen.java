package behavior;

import slogo.Model;
import view.Canvas;


/**
 * Clears the Screen
 * 
 * @author Richard Yang
 * 
 */

public class ClearScreen extends Home {

    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getMyTurtle(turtleNumber).clearTrail();
        model.getMyTurtle(turtleNumber).initialize();
        return Math.sqrt(Math.pow(model.getMyTurtle(turtleNumber).getX() -
                                  Canvas.TURTLE_AREA_SIZE.getWidth() / 2, 2) +
                         Math.pow(model.getMyTurtle(turtleNumber).getY() -
                                  Canvas.TURTLE_AREA_SIZE.getHeight() / 2, 2));
    }

}
