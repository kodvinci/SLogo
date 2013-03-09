package behavior;

import slogo.Model;
import view.Canvas;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Ycor extends NoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        return model.getMyTurtle(turtleNumber).getY() - Canvas.TURTLE_AREA_SIZE.getHeight() / 2;
    }

}
