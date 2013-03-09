package behavior;

import exceptions.SyntaxException;
import slogo.Model;

/**
 * an abstract class for no parameter commands
 * @author Richard Yang
 *
 */
public abstract class NoParameterCommand implements ICommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        return 0;
    }

    @Override
    public void initialize (String[] information, Model model) throws SyntaxException {
        if (information.length != 0) { throw new SyntaxException(); }
    }
}
