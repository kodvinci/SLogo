package behavior;

import slogo.Model;
import exceptions.ParameterException;


/**
 * an abstract class for no parameter commands
 * 
 * @author Richard Yang
 * 
 */
public abstract class NoParameterCommand implements ICommand {

    private static final int PARAMETER_NUMBER = 0;
    
    @Override
    public double move (Model model, int turtleNumber) {
        return 0;
    }

    @Override
    public void initialize (String[] information, Model model) throws ParameterException {
        if (information.length != 0) { throw new ParameterException("parameter not match"); }
    }
    
    public int getParameterNumber() {
        return PARAMETER_NUMBER;
    }
    
}
