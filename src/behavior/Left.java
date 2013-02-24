package behavior;

import object.Turtle;


public class Left implements ICommand {

    @Override
    public void move (Turtle turtle, double distanceOrAngle) throws Exception {
        double angle = turtle.getMyAngle();
        turtle.setMyAngle(angle);
    }

    @Override
    public void move (Turtle turtle, double X, double Y) throws Exception {
        // TODO Auto-generated method stub
        
    }

  

}
