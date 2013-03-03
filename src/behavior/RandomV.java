package behavior;

import exceptions.SyntaxException;
import java.util.Random;
import object.Turtle;



/**
 * 
 * @author Richard Yang
 * 
 */

public class RandomV implements ICommand {

    @Override
    public double move (Turtle turtle, double[] parameters) throws SyntaxException {
        if (parameters.length != 1) {
            throw new SyntaxException();
        }
        Random myRandom = new Random();
        int maxValue = (int) Math.floor(parameters[0]);
        int result = myRandom.nextInt() % maxValue;
        return result;
    }

}
