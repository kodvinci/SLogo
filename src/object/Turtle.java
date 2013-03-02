package object;

import java.awt.Dimension;
import util.Location;
import util.Pixmap;
import util.Sprite;


/**
 * 
 * @author Richard Yang
 * 
 */

public class Turtle extends Sprite {

    private static final Pixmap TURTLE_IMAGE = new Pixmap("turtle.gif");
    public static final Dimension DEFAULT_SIZE = new Dimension(50, 50);

    private static final Dimension TURTLE_AREA = new Dimension(800, 600);

    private double myAngle;

    private boolean leftTrail;

    private Trail myTrail;

    private boolean visible;

    public Turtle (Location myLocation, double angle) {
        super(TURTLE_IMAGE, myLocation, DEFAULT_SIZE);
        myAngle = angle;
        myTrail = new Trail();
    }

    public Turtle () {
        super(TURTLE_IMAGE, new Location(200, 200), DEFAULT_SIZE);
        myAngle = 0;
        myTrail = new Trail();
    }

    public void initialize () {
        super.setCenter(new Location(0, 0));
    }

    public void addTrail () {
        myTrail.addTrail(new Location(getX(), getY()));
    }

    public void leftTrail () {
        leftTrail = true;
    }

    public void avoidTrail () {
        leftTrail = false;
    }

    public void clearTrail () {
        myTrail.clearTrail();
    }

    public void setVisible () {
        visible = true;
    }

    public void setInvisible () {
        visible = false;
    }

    public double getMyAngle () {
        return myAngle;
    }

    public void setMyAngle (double myAngle) {
        this.myAngle = myAngle;
    }

    public boolean isLeaveTrail () {
        return leftTrail;
    }

    public boolean isVisible () {
        return visible;
    }

    public String toString (double num) {
        return Double.toString(num);
    }

}
