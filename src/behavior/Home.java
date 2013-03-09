package behavior;

import slogo.Model;
import view.Canvas;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Home extends NoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        model.getMyTurtle(turtleNumber).initialize();
        return Math.sqrt(Math.pow(model.getMyTurtle(turtleNumber).getX() -
                                          Canvas.TURTLE_AREA_SIZE.getWidth() / 2, 2) +
                         Math.pow(model.getMyTurtle(turtleNumber).getY() -
                                          Canvas.TURTLE_AREA_SIZE.getHeight() / 2, 2));
    }

}
