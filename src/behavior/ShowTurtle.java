package behavior;

import slogo.Model;
import exceptions.SyntaxException;


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
