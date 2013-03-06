package behavior;

import object.Turtle;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class And implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 2)
<<<<<<< HEAD
            throw new SyntaxException();
        else if (!((parameters[0] == 1 || parameters[0] == 0) && (parameters[1] == 1 || parameters[1] == 0))) {
            throw new SyntaxException();
        }
=======
            throw new SyntaxException();
        else if (!((parameters[0] == 1 || parameters[0] == 0) 
                && (parameters[1] == 1 || parameters[1] == 0))) {
            throw new SyntaxException();
        }
>>>>>>> 7bd5c8816a7f4ca84214b88b0f22592b425a1a74

        return ((parameters[0] == 1) && (parameters[1] == 1)) ? 1 : 0;
    }
}
