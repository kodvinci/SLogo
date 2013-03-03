package behavior;

import object.Turtle;
import exceptions.SyntaxException;

public class Ycor implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if(parameters.length != 0){
            throw new SyntaxException();
        }
        return turtle.getX() -Turtle.DEFAULT_SIZE.height/2;
    }

}
