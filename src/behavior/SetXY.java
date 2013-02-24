package behavior;

import object.Turtle;


public class SetXY implements ICommand {

    @Override
    public void move (Turtle turtle, double distanceOrAngle) throws Exception {
        
    }

    @Override
    public void move (Turtle turtle, double x , double y) throws Exception {
         turtle.setCenter(x, y);
    }

}
