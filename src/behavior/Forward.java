package behavior;

import object.Turtle;



public class Forward implements ICommand {

 
    @Override
    public void move (Turtle turtle, double distanceOrAngle) throws Exception {
        double angle  = turtle.getMyAngle();
        double newX = turtle.getX() + distanceOrAngle * Math.sin(angle);
        double newY = turtle.getY() + distanceOrAngle * Math.cos(angle);
        turtle.setCenter( newX , newY );
    }

    @Override
    public void move (Turtle turtle, double X, double Y) throws Exception {
        
    }

    @Override
    public void move (Turtle turtle) throws Exception {
        
    }

    

}
