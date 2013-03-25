package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class PenUp extends NoParameterCommand {

    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        // model.getController().getView().getTurtleArea().penUp();
        return 0;

    }

}
