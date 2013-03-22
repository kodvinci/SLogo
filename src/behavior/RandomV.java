package behavior;

import java.util.Random;
import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class RandomV extends OneParameterCommand {
    
    public static final int PARAMETER_NUMBER = 2;

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {

        Random myRandom = new Random();
        int maxValue = (int) Math.floor(getMyValue());
        int result = myRandom.nextInt() % maxValue;
        return result;
    }

}
