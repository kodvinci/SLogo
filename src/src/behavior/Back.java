package behavior;

import slogo.Model;


/**
 * Moves Back
 * 
 * @author Richard Yang
 * 
 */
public class Back extends Forward {

    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {
        inverseMyValue();
        super.move(model, turtleNumber);
        return getMyValue();
    }

}
