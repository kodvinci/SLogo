package behavior;

import java.util.Random;
import slogo.Model;


/**
 * 
 * @author Richard Yang
 * 
 */

public class RandomV extends OneParameterCommand {

    public static final int PARAMETER_NUMBER = 1;

    @Override
    public double move (Model model, int turtleNumber) {

        Random myRandom = new Random();
        int maxValue = (int) Math.floor(getMyValue());
        int result = myRandom.nextInt() % maxValue;
        return result;
    }

}
