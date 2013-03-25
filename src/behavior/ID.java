package behavior;

import slogo.Model;


public class ID extends NoParameterCommand {

    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {
        return turtleNumber;
    }
}
