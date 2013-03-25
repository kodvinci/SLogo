package object;

import java.awt.Dimension;
import util.Animal;


public class Stamp extends Animal {
    public static final Dimension DEFAULT_SIZE = new Dimension(50, 50);
    private boolean visible = true;

    /**
     * Constructor that creates stamp at turtle image and location
     */
    public Stamp (Turtle t) {
        super(t.getTurtleImage(), t.getCenter(), DEFAULT_SIZE);
    }

    /**
     * Checks if stamp is visible
     */
    public boolean isVisible () {
        return visible;
    }

    /**
     * Sets visible to false
     */
    public void makeInvisible () {
        visible = false;
    }

    /**
     * Sets visible to true
     */
    public void makeVisible () {
        visible = true;
    }
}
