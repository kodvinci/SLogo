package behavior;

import slogo.Model;


public class SetPenSize extends OneParameterCommand {
    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getController().getView().getTurtleArea().editPenWidth((int) getMyValue());
        return 0;
    }

}
