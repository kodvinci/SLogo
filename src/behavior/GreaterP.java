package behavior;

import object.Turtle;
import exceptions.SyntaxException;

public class GreaterP implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if(parameters.length != 2){
            throw new SyntaxException();
        }
        return (parameters[0] > parameters[1]) ? 1:0 ;
    }

}
