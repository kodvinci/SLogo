package behavior;

import slogo.Model;


public class Stamp extends NoParameterCommand {

    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {
<<<<<<< HEAD

        // TO DO : call method in model to stamp on a turtle
=======
        // TO DO : call method in model to stamp on a turtle    
        model.getController().getView().getTurtleArea().createStamp
                           (model.getController().getView().getTurtleArea().getTurtle(turtleNumber));
>>>>>>> 71f3ab082e100f8fb58c62cc5f71a9bd50bc0bb3
        return 0;
    }

}
