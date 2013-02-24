package object;

import java.awt.Dimension;
import util.Location;
import util.Pixmap;
import util.Sprite;

public class Turtle extends Sprite {

    private static final Pixmap TURTLE_IMAGE = new Pixmap("turtle.gif");
    
    private static final Dimension TURTLE_AREA = new Dimension(800,600);
    
    private double myAngle;
    
    private boolean leaveTrail;
    
    public Turtle(Location myLocation, double angle){
        super(TURTLE_IMAGE, myLocation,TURTLE_AREA);
        myAngle = angle;
    }
    
    public Turtle(){
        super(TURTLE_IMAGE,new Location(0,0),TURTLE_AREA);
        myAngle = 0;
    }

    public double getMyAngle () {
        return myAngle;
    }

    public void setMyAngle (double myAngle) {
        this.myAngle = myAngle;
    }
    
    
    
    
    
}
