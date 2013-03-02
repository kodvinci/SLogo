package behavior;

import exceptions.SyntaxException;
import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public class SetHeading implements ICommand {

    @Override
    public void move (Turtle turtle, double[] parameters) throws SyntaxException {
        if(parameters.length != 1){
            throw new SyntaxException();        
        }else{
            double angle = parameters[0];
            turtle.setMyAngle(angle);
        }
    }

}
