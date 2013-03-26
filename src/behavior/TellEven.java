package behavior;

import java.util.ArrayList;
import slogo.Model;
import exceptions.ParameterException;


/**
 * Tell even turtles
 * 
 * @author Richard Yang
 * 
 */
public class TellEven extends Tell {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 0;

    @Override
    public void initialize (String[] information, Model model) throws Exception {
        if (information.length != PARAMETER_NUMBER) { throw new ParameterException(
                                                                                   "Parameter doesn't match"); }
        myActivatedTurtles = new ArrayList<Integer>();
        int turtleNumber = model.getMyTurtles().size();
        for (int i = 0; i < turtleNumber; i++) {
            if (i % 2 == 0) {
                myActivatedTurtles.add(i);
            }
        }
        System.out.println("activated turtle number :" + myActivatedTurtles.size());
    }

}
