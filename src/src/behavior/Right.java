package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Right extends Left {

    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {
        inverseMyValue();
        super.move(model, turtleNumber);
        return getMyValue();
    }
}
