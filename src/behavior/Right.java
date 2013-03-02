package behavior;

import exceptions.SyntaxException;
import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Right extends Left {

    @Override
    public void move(Turtle turtle, double[] parameters)throws SyntaxException {
        double[] inverseParameters = CommandEntities.inverse(parameters);
        super.move(turtle , inverseParameters);
    }
}
