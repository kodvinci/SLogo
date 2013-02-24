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
    
    private Trail myTrail;
    
    private boolean visible;
    
    public Turtle(Location myLocation, double angle){
        super(TURTLE_IMAGE, myLocation,TURTLE_AREA);
        myAngle = angle;
        myTrail = new Trail();
    }
    
    public Turtle(){
        super(TURTLE_IMAGE,new Location(0,0),TURTLE_AREA);
        myAngle = 0;
        myTrail = new Trail();
    }

    public void addTrail(){
        myTrail.addTrail(new Location(this.getX(), this.getY()));
    }
    
    public void leaveTrail(){
        leaveTrail = true ;
    }
    
    public void avoidLeaveTrail(){
        leaveTrail = false ;
    }
    
    public void clearTrail(){
        myTrail.clearTrail();
    }
    
    public void setVisible(){
        visible = true ;
    }
    
    public void setInvisible(){
        visible = false ;
    }
    
    public double getMyAngle () {
        return myAngle;
    }

    public void setMyAngle (double myAngle) {
        this.myAngle = myAngle;
    }

    public boolean isLeaveTrail () {
        return leaveTrail;
    }

    public boolean isVisible () {
        return visible;
    }
    
    
    
    
    
}
