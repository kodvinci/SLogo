package behavior;


import object.Turtle;


public interface ICommand {
    public abstract void move (Turtle turtle , double distanceOrAngle) throws Exception;
}
