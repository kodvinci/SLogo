package behavior;

import slogo.Model;

public class ClearStamps extends NoParameterCommand {
    
    public static final int PARAMETER_NUMBER = 0;
    
    public double move (Model model, int turtleNumber) {
        
        model.getController().getView().getTurtleArea().clearStamps();
        return 0;
    }

}
