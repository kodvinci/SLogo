package behavior;

import exceptions.SyntaxException;
import slogo.Model;
import view.Canvas;



/**
 * 
 * @author Richard Yang
 * 
 */

public class Xcor extends NoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        return model.getMyTurtle(turtleNumber).getX() - Canvas.TURTLE_AREA_SIZE.getWidth() / 2;
    }

}
