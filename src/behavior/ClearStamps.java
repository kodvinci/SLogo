package behavior;

import slogo.Model;


public class ClearStamps extends NoParameterCommand {

    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {
        // TO DO : call method in model to clear all the stamps       
        model.getController().getView().getTurtleArea().clearStamps();
        return 0;
    }

}
