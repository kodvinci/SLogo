package behavior;

import slogo.Model;


public class PenColor extends NoParameterCommand {

    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {     
        int colorIndex = model.getController().getView().getTurtleArea().getCurrentColorIndex();
        return (double) colorIndex;
    }

}
