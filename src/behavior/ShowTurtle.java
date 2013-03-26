package behavior;

import slogo.Model;


/**
 * Show turtle on display
 * @author Richard Yang
 * 
 */

public class ShowTurtle extends NoParameterCommand {
    
    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getMyTurtle(turtleNumber).setVisible();
        return 1;

    }

}
