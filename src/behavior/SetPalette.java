package behavior;

import slogo.Model;

public class SetPalette extends OneParameterCommand {
    
    public static final int PARAMETER_NUMBER = 1;
    
    public double move (Model model, int turtleNumber) {
        
        model.getController().getView().getTurtleArea().addToColorPalette(int float float float);
        return 0;
    }

}