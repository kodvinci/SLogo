package behavior;

import exceptions.SyntaxException;
import java.util.regex.Pattern;
import slogo.Model;


/**
 * abstract class for two parameter commands
 * 
 * @author Richard Yang
 * 
 */
public abstract class TwoParameterCommand implements ICommand {

    private double myFirstValue;
    private double mySecondValue;
    private Pattern myNumPattern = Pattern.compile("[0-9]*");

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        return 0;
    }

    @Override
    public void initialize (String[] information, Model model) throws SyntaxException {
        if (information.length != 2 || !myNumPattern.matcher(information[0]).matches() ||
            !myNumPattern.matcher(information[1]).matches()) { throw new SyntaxException(); }
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
}
