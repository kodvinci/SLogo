package behavior;

import object.Turtle;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Or implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 2) {
            throw new SyntaxException();
        }
        else if (!((parameters[0] == 1 || parameters[0] == 0) && (parameters[1] == 1 || parameters[1] == 0))) { throw new SyntaxException(); }
        return ((parameters[0] == 0) && (parameters[1] == 0)) ? 0 : 1;
    }

}
