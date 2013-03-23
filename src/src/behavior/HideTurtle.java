package behavior;

import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */
public class HideTurtle extends NoParameterCommand {

    public static final int PARAMETER_NUMBER = 0;

    @Override
    public double move (Model model, int turtleNumber) {

        System.out.println("hide turtle successful");
        model.getMyTurtle(turtleNumber).setInvisible();
        return 0;

    }

}
