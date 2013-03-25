package behavior;

import slogo.Model;


public class Stamp extends NoParameterCommand {

    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {
   
        model.getController().getView().getTurtleArea().createStamp
                           (model.getController().getView().getTurtleArea().getTurtle(turtleNumber));
       return 0;
    }

}
