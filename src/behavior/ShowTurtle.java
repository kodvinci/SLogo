package behavior;

import object.Turtle;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class ShowTurtle implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 0) {
            throw new SyntaxException();
        }
        else {
            turtle.setVisible();
            return 1;
        }

    }

}
