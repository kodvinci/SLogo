package behavior;

import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */
public class HideTurtle extends NoParameterCommand {

    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        System.out.println("hide turtle successful");
        model.getMyTurtle(turtleNumber).setInvisible();
        return 0;

    }

}
