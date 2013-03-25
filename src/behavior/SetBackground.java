package behavior;

import slogo.Model;


public class SetBackground extends OneParameterCommand {

    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getController().getView().getTurtleArea().changeBackgroundColor((int) getMyValue());
        return 0;
    }

}
