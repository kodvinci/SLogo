package behavior;

import slogo.Model;
import exceptions.SyntaxException;


public abstract class NoParameterCommand implements ICommand {

    @Override
    public double move (Model model, int TurtleNumber) throws SyntaxException {
        return 0;
    }

    @Override
    public void initialize (String[] information, Model model) throws SyntaxException {
        if (information.length != 0) { throw new SyntaxException(); }
    }
}
