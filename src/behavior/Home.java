package behavior;

import exceptions.SyntaxException;
import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Home implements ICommand {

    @Override
    public void move (Turtle turtle, double[] parameters) throws SyntaxException {
        if(parameters.length != 0){
            throw new SyntaxException() ; 
        }else{
        turtle.initialize();
        }
    }

}
