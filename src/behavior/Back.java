package behavior;

import object.Turtle;

public class Back extends Forward {
   
    
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
