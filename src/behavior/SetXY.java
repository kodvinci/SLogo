package behavior;

import exceptions.SyntaxException;
import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public class SetXY implements ICommand {
    
    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if(parameters.length != 2){
            throw new SyntaxException();        
        }else{
            double newX = parameters[0];
            double newY = parameters[1];
            turtle.setCenter(newX, newY);
            return Math.sqrt(Math.pow(newX-turtle.getX() , 2)+Math.pow(newY-turtle.getY(), 2));
        }
        
    }

    

}
