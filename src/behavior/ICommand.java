package behavior;

import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */

public interface ICommand {
    public abstract void move (Turtle turtle, double distanceOrAngle) throws Exception;

    public abstract void move (Turtle turtle, double X, double Y) throws Exception;

    public abstract void move (Turtle turtle) throws Exception;

}
