package behavior;

import object.Turtle;

public class Right extends Left {

    
    @Override
    public void move(Turtle turtle , double distanceOrAngle){
        try {
            super.move(turtle, -distanceOrAngle);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
