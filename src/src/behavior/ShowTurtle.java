package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class ShowTurtle extends NoParameterCommand {

    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getMyTurtle(turtleNumber).setVisible();
        return 1;

    }

}
