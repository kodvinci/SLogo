package behavior;

import java.util.regex.Pattern;
import object.Turtle;
import slogo.Model;
import util.Location;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Forward implements ICommand {

    private double myDistance;
    private Pattern myNumPattern = Pattern.compile("[0-9]*");
    
    @Override
    public void initialize(String[] information)throws SyntaxException{
        if(information.length != 1 || !myNumPattern.matcher(information[0]).matches()) throw new SyntaxException();
        myDistance = Double.parseDouble(information[0]);
        
    }

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        double currentX = model.getMyTurtle(turtleNumber).getX();
        double currentY = model.getMyTurtle(turtleNumber).getY();
        double angle = model.getMyTurtle(turtleNumber).getMyAngle();
        Location newLocation = new Location(currentX+ myDistance * Math.sin(angle), currentY + myDistance * Math.cos(angle));
        model.getMyTurtle(turtleNumber).setCenter(newLocation);
        return myDistance;
        
    }
}