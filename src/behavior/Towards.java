package behavior;

import exceptions.SyntaxException;
import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Towards implements ICommand {

   
    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if(parameters.length != 2){
            throw new SyntaxException();        
        }else{
            double x = parameters[0];
            double y = parameters[1];
            double deltaX = x - turtle.getX();
            double deltaY = y - turtle.getY();
            double currentAngle = Math.atan(deltaX / deltaY);
            double difference = currentAngle - turtle.getMyAngle();
            turtle.setMyAngle(currentAngle);
            return difference ;
            
        }
    }

  

}
