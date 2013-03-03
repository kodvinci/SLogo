package behavior;

import exceptions.SyntaxException;
import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Left implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if(parameters.length != 1){
            throw new SyntaxException();
        }else{
            double angle = parameters[0];
            double deltaAngle = angle * Math.PI / 180;
            turtle.setMyAngle(angle - deltaAngle);
            return angle ;
        }
    }
}
