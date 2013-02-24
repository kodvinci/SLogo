package behavior;

import object.Turtle;


public class Towards implements ICommand {

    @Override
    public void move (Turtle turtle, double distanceOrAngle) throws Exception {
    
    }

    @Override
    public void move (Turtle turtle, double x, double y) throws Exception {
        double deltaX = x - turtle.getX();
        double deltaY = y - turtle.getY();
        turtle.setMyAngle(Math.atan(deltaX/deltaY));
    }

    @Override
    public void move (Turtle turtle) throws Exception {
        
        
    }

}
