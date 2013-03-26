package behavior;

import slogo.Model;


/**
 * Get pen color
 * 
 * @author Jerry
 * 
 */
public class PenColor extends NoParameterCommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {
        int colorIndex = model.getController().getView().getTurtleArea().getCurrentColorIndex();
        return colorIndex;
    }

}
