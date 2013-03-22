package behavior;

import slogo.Model;
import view.Canvas;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Xcor extends NoParameterCommand {
    
    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        return model.getMyTurtle(turtleNumber).getX() - Canvas.TURTLE_AREA_SIZE.getWidth() / 2;
    }

}
