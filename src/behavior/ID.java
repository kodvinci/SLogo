package behavior;

import slogo.Model;

/**
 * class used to return the ID of turtle
 * @author Richard Yang
 *
 */
public class ID extends NoParameterCommand {

    /**
     * the parameter number of this certain command
     */
    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {
        return turtleNumber;
    }
}
