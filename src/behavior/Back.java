package behavior;

import object.Turtle;
import exceptions.SyntaxException;


/**
 * Moves Back
 * 
 * @author Richard Yang
 * 
 */
public class Back extends Forward {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        double[] inverseParameters = CommandEntities.inverse(parameters);
        super.move(turtle, inverseParameters);
        return parameters[0];
    }

}
