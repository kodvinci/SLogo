package behavior;

import java.util.regex.Pattern;
import slogo.Model;
import exceptions.ParameterException;


/**
 * abstract class for two parameter commands
 * 
 * @author Richard Yang
 * 
 */
public abstract class TwoParameterCommand implements ICommand {

    private static final int PARAMETER_NUMBER = 2;
    
    private double myFirstValue;
    private double mySecondValue;
    private Pattern myNumPattern = Pattern.compile("[0-9]*");

    @Override
    public double move (Model model, int turtleNumber) {
        return 0;
    }

    @Override
    public void initialize (String[] information, Model model) throws ParameterException {
        if (information.length != PARAMETER_NUMBER || !myNumPattern.matcher(information[0]).matches() ||
            !myNumPattern.matcher(information[1]).matches()) { throw new ParameterException("parameter not match"); }
        myFirstValue = Double.parseDouble(information[0]);
        mySecondValue = Double.parseDouble(information[1]);
    }

    /**
     * get first value
     * 
     * @return
     */
    public double getMyFirstValue () {
        return myFirstValue;
    }

    /**
     * get second value
     * 
     * @return
     */
    public double getMySecondValue () {
        return mySecondValue;
    }
    
    public int getParameterNumber() {
        return PARAMETER_NUMBER;
    }
}
