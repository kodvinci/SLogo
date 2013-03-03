package behavior;

import exceptions.SyntaxException;
import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public class ClearScreen implements ICommand {
    
    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if(parameters.length != 0){
            throw new SyntaxException() ; 
        }else{
            turtle.clearTrail();
            turtle.initialize();    
        }
        return Math.sqrt(Math.pow(turtle.getX(),2) + Math.pow( turtle.getY(),2));
    }

}
