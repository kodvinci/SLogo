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

    /**
     * Default dimension size
     */
    public static final Dimension DEFAULT_SIZE = new Dimension(50, 50);

    /**
     * Default Location
     */
    private static final int DEFAULT_LOCATION = 400;
    /**
     * Default turtle image;
     */
    private static final Pixmap TURTLE_IMAGE = new Pixmap("turtle.gif");

    private double myAngle;
    private boolean myLeftTrail;
    private Trail myTrail;
    private boolean myVisible;

    /**
     * Constructs turtle object
     * 
     * @param myLocation myLocation
     * @param angle myAngle
     */
    public Turtle (Location myLocation, double angle) {
        super(TURTLE_IMAGE, myLocation, DEFAULT_SIZE);
        myAngle = angle;
        myTrail = new Trail();
    }

    /**
     * Constructs turtle object with image
     */
    public Turtle () {
        super(TURTLE_IMAGE, new Location(DEFAULT_LOCATION, DEFAULT_LOCATION/2), DEFAULT_SIZE);
        myAngle = 0;
        myTrail = new Trail();
    }

    /**
     * initialize turtle at center
     */
    public void initialize () {
        super.setCenter(new Location(0, 0));
    }

    /**
     * add a trail
     */
    public void addTrail () {
        myTrail.addTrail(new Location(getX(), getY()));
    }

    /**
     * Are there trails left?
     */
    public void leftTrail () {
        myLeftTrail = true;
    }

    /**
     * avoid trail
     */
    public void avoidTrail () {
        myLeftTrail = false;
    }

    /**
     * clear all trails
     */
    public void clearTrail () {
        myTrail.clearTrail();
    }

    /**
     * set visible
     */
    public void setVisible () {
        myVisible = true;
    }

    /**
     * set to invisible
     */
    public void setInvisible () {
        myVisible = false;
    }

    /**
     * get angle
     * 
     * @return myAngle
     */
    public double getMyAngle () {
        return myAngle;
    }

    /**
     * Set angle
     * 
     * @param angle angle to set to
     */
    public void setMyAngle (double angle) {
        myAngle = angle;
    }

    /**
     * Does it leave a trail?
     * 
     * @return leftTrail
     */
    public boolean isLeaveTrail () {
        return myLeftTrail;
    }

    /**
     * is it visible?
     * 
     * @return my visible
     */
    public boolean isVisible () {
        return myVisible;
    }

    /**
     * double to string
     * 
     * @param num number
     * @return to string
     */
    public String toString (double num) {
        return Double.toString(num);
    }

    public Trail getTrail () {
        return myTrail;
    }

}
