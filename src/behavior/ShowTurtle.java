package behavior;

import object.Turtle;

public class ShowTurtle implements ICommand {

    @Override
    public void move (Turtle turtle, double distanceOrAngle) throws Exception {

    }

    @Override
    public void move (Turtle turtle, double X, double Y) throws Exception {
       
    }

    @Override
    public void move (Turtle turtle) throws Exception {
        turtle.setVisible();

    }

}