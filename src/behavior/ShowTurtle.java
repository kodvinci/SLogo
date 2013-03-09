package behavior;

import exceptions.SyntaxException;
import slogo.Model;



/**
 * 
 * @author Richard Yang
 * 
 */

public class ShowTurtle extends NoParameterCommand {

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        model.getMyTurtle(turtleNumber).setVisible();
        return 1;

    }

}
