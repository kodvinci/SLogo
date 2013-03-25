package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class PenDown extends NoParameterCommand {

    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        // model.getController().getView().getTurtleArea().penDown();
        return 1;

    }

}
