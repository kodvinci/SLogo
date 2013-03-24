package behavior;

import slogo.Model;

public class SetPenColor extends OneParameterCommand {

    public static final int PARAMETER_NUMBER = 1;
    
    public double move (Model model, int turtleNumber) {
        
        model.getController().getView().getTurtleArea().setTrailColor((int) getMyValue());
        return 0;
    }
}
