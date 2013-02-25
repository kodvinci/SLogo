package behavior;

import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Left implements ICommand {

    @Override
    public void move (Turtle turtle, double distanceOrAngle) throws Exception {
        double angle = turtle.getMyAngle();
        double deltaAngle = distanceOrAngle * Math.PI / 180;
        turtle.setMyAngle(angle - deltaAngle);
    }

    @Override
    public void move (Turtle turtle, double X, double Y) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void move (Turtle turtle) throws Exception {

    }

}
