package object;

import java.util.ArrayList;
import java.util.List;
import util.Location;

/**
 * 
 * @author Richard Yang
 * 
 */

public class Trail {
    private List<Location> myTrails;

    /**
     * Construct a list of trails
     */
    public Trail () {
        myTrails = new ArrayList<Location>();
    }

    /**
     * add trails
     * 
     * @param newTrail the trail to add
     */
    public void addTrail (Location newTrail) {
        myTrails.add(newTrail);
    }

    /**
     * remove trails
     * 
     * @param removeTrail the trail to remove
     */
    public void removeTrail (Location removeTrail) {
        myTrails.remove(removeTrail);
    }

    /**
     * remove trail at index
     * 
     * @param index the index
     */
    public void removeTrail (int index) {
        myTrails.remove(index);
    }

    /**
     * clear list of trails of all objects
     */
    public void clearTrail () {
        myTrails.clear();
    }

    /**
     * returns the list of trails;
     */
    public List<Location> getTrails () {
        return myTrails;
    }
}
