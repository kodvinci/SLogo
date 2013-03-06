package behavior;

import object.Turtle;
<<<<<<< HEAD
=======
import view.Canvas;
>>>>>>> 7bd5c8816a7f4ca84214b88b0f22592b425a1a74
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class SetXY implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 2) {
            throw new SyntaxException();
        }
        else {
            double newX = parameters[0];
            double newY = parameters[1];
            turtle.setCenter(newX, newY);
            return Math
                    .sqrt(Math.pow(newX - turtle.getX() + Canvas.TURTLE_AREA_SIZE.width / 2, 2) +
                          Math.pow(newY - turtle.getY() + Canvas.TURTLE_AREA_SIZE.height / 2, 2));
        }

    }

}
