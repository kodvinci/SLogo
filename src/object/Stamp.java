package object;

import java.awt.Dimension;
import util.Animal;


/**
 * @author Alan
 * @author Leonard
 * 
 */
public class Stamp extends Animal {
    /**
     * 
     */
    public static final Dimension DEFAULT_SIZE = new Dimension(50, 50);
    private boolean myVisibility = true;

    /**
     * Constructor that creates stamp at turtle image and location
     * @param t turtle
     */
    public Stamp (Turtle t) {
        super(t.getTurtleImage(), t.getCenter(), DEFAULT_SIZE);
    }

    /**
     * Checks if stamp is visible
     */
    public boolean isVisible () {
        return myVisibility;
    }

    /**
     * Sets visible to false
     */
    public void makeInvisible () {
        myVisibility = false;
    }

    /**
     * Sets visible to true
     */
    public void makeVisible () {
        myVisibility = true;
    }
}
