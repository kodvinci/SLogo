package behavior;

import slogo.Model;


public class SetPenColor extends OneParameterCommand {

    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getController().getView().getTurtleArea().setPenColor((int) getMyValue());
        return 0;
    }
}
