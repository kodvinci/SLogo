package behavior;

import java.util.Random;
import slogo.Model;


/**
 * Get random number
 * 
 * @author Richard Yang
 * 
 */

public class RandomV extends OneParameterCommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {

        Random myRandom = new Random();
        int maxValue = (int) Math.floor(getMyValue());
        int result = myRandom.nextInt() % maxValue;
        return result;
    }

}
