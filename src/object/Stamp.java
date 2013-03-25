package object;

import java.awt.Dimension;
import util.Animal;


public class Stamp extends Animal {
    public static final Dimension DEFAULT_SIZE = new Dimension(50, 50);
    private boolean visible = true;

    /*
     * =======
     * /**
     * >>>>>>> 71f3ab082e100f8fb58c62cc5f71a9bd50bc0bb3
     * Constructor that creates stamp at turtle image and location
     */
    public Stamp (Turtle t) {
        super(t.getTurtleImage(), t.getCenter(), DEFAULT_SIZE);
    }

    /*
     * =======
     * /**
     * >>>>>>> 71f3ab082e100f8fb58c62cc5f71a9bd50bc0bb3
     * Checks if stamp is visible
     */
    public boolean isVisible () {
        return visible;
    }

    /*
     * =======
     * /**
     * >>>>>>> 71f3ab082e100f8fb58c62cc5f71a9bd50bc0bb3
     * Sets visible to false
     */
    public void makeInvisible () {
        visible = false;
    }

    /*
     * =======
     * /**
     * >>>>>>> 71f3ab082e100f8fb58c62cc5f71a9bd50bc0bb3
     * Sets visible to true
     */
    public void makeVisible () {
        visible = true;
    }
}
