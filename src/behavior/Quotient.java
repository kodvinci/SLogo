package behavior;

import object.Turtle;
import exceptions.SyntaxException;

/**
 * 
 * @author Richard Yang
 *
 */

public class Quotient implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if(parameters.length != 2){
            throw new SyntaxException();
        }
        int result = (int)parameters[0] * (int)parameters[1];
        return (double)result;
    }

}
