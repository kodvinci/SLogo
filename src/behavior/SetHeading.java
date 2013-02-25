package behavior;

import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public class SetHeading implements ICommand {

    @Override
    public void move (Turtle turtle, double distanceOrAngle) throws Exception {
        turtle.setMyAngle(distanceOrAngle);
    }

    @Override
    public void move (Turtle turtle, double X, double Y) throws Exception {

    }

    @Override
    public void move (Turtle turtle) throws Exception {

    }

}
