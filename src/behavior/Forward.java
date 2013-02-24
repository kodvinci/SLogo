package behavior;

import object.Turtle;


public class Forward implements ICommand {

  

    @Override
    public void move (Turtle turtle, double distanceOrAngle) throws Exception {
        angle  = turtle.getMyAngle();
        
    }

}
