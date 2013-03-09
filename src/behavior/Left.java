package behavior;

import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Left extends OneParameterCommand {

    
    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
   
          double angle = model.getMyTurtle(turtleNumber).getMyAngle();
          model.getMyTurtle(turtleNumber).setMyAngle(angle + getMyValue());
          return getMyValue();
    }
}
