package behavior;

import slogo.Model;


/**
 * Return shape size of turtle
 * 
 * @author Jerry
 * 
 */
public class Shape extends NoParameterCommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {
        
        return model.getController().getView().getTurtleArea().getMyTurtle
                (turtleNumber).getTurtleShapeIndex();
    }

}
