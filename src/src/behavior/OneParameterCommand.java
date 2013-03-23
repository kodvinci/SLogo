package behavior;

import java.util.regex.Pattern;
import slogo.Model;
import exceptions.ParameterException;


/**
 * an abstract class for one parameter command
 * 
 * @author Richard Yang
 * 
 */
public abstract class OneParameterCommand implements ICommand {

    private static final int PARAMETER_NUMBER = 1;
    
    private double myValue;
    private Pattern myNumPattern = Pattern.compile("[0-9]*");

    @Override
    public double move (Model model, int turtleNumber) {
        return 0;
    }

    @Override
    public void initialize (String[] information, Model model) throws ParameterException {
        if (information.length != 1 || !myNumPattern.matcher(information[0]).matches()) { throw new ParameterException("parameter not match"); }
        myValue = Double.parseDouble(information[0]);
    }

    /**
     * getter for myvalue
     * 
     * @return
     */
    public double getMyValue () {
        return myValue;
    }

    /**
     * inverse parameter
     */
    public void inverseMyValue () {
        myValue = -myValue;
        System.out.println("Did it inverse correctly? " + myValue);
    }
    
    public int getParameterNumber() {
        return PARAMETER_NUMBER;
    }

}
