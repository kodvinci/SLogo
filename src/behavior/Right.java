package behavior;

import object.Turtle;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Right extends Left {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        double[] inverseParameters = CommandEntities.inverse(parameters);
        super.move(turtle, inverseParameters);
        return parameters[0];
    }
}
