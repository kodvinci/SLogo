package util;

import java.awt.geom.Point2D;


/**
 * This class represents a Location (in pixels) on the screen and
 * adds some utility functions to the Point2D class.
 * 
 * Note, this might be overkill, it was just annoying that Point2D
 * did not implement translate :(
 * 
 * @author Robert C. Duvall
 */
public class Location extends Point2D.Double {
    // default serialization ID
    private static final long serialVersionUID = 1L;

    /**
     * Create a location at the origin.
     */
    public Location () {
        super(0, 0);
    }

    /**
     * Create a location at given (x, y) coordinates.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Location (double x, double y) {
        super(x, y);
    }

    /**
     * Create a location that is identical to the given other location.
     * 
     * @param source the source
     */
    public Location (Point2D source) {
        super(source.getX(), source.getY());
    }

    /**
     * Reset this location to origin.
     */
    public void reset () {
        setLocation(0, 0);
    }


}
