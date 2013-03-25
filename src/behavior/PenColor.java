package behavior;

import slogo.Model;


public class PenColor extends NoParameterCommand {

    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {
<<<<<<< HEAD

        // TO DO : call method in model to get the pen color
        return 0;
=======
        // TO DO : call method in model to get the pen color
        //return 0;      
        int colorIndex = model.getController().getView().getTurtleArea().getCurrentColorIndex();
        return (double) colorIndex;
>>>>>>> 71f3ab082e100f8fb58c62cc5f71a9bd50bc0bb3
    }

}
