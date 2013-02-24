package behavior;

import object.Turtle;

public class ClearScreen implements ICommand {

    @Override
    public void move (Turtle turtle, double distanceOrAngle) throws Exception {

    }

    @Override
    public void move (Turtle turtle, double X, double Y) throws Exception {

    }

    @Override
    public void move (Turtle turtle) throws Exception {
        turtle.clearTrail();
        turtle.initialize();
    }

}
