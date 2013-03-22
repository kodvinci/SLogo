package behavior;

import slogo.Model;
import view.Canvas;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class SetXY extends TwoParameterCommand {
    
    public static final int PARAMETER_NUMBER = 3;

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        double newX = getMyFirstValue() + Canvas.TURTLE_AREA_SIZE.width / 2;
        double newY = getMySecondValue() + Canvas.TURTLE_AREA_SIZE.height / 2;
        model.getMyTurtle(turtleNumber).setCenter(newX, newY);
        return Math.sqrt(Math.pow(newX - model.getMyTurtle(turtleNumber).getX(), 2) +
                         Math.pow(newY - model.getMyTurtle(turtleNumber).getY(), 2));
    }

}
