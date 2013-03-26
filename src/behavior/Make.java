package behavior;

import slogo.Model;
import slogo.Parser;
import exceptions.ParameterException;
import exceptions.SyntaxException;


/**
 * Make a variable
 * 
 * @author Richard Yang
 * 
 */

public class Make implements ICommand {

    /**
     * the parameter number of this certain command
     */
    public static final int PARAMETER_NUMBER = 2;

    private Parser myParser = new Parser();
    private String myVariableName;
    private String myValueString;
    private Double myValue;

    @Override
    public double move (Model model, int turtleNumber) {
        model.addVariable(myVariableName, myValueString);
        return myValue;
    }

    @Override
    public void initialize (String[] information, Model model) throws SyntaxException {
        if (information.length != 2) {
            throw new SyntaxException("Syntax Error");
        }
        else if (!myParser.getNumPattern().matcher(information[1]).matches()) { 
            throw new SyntaxException("variable value must be number"); 
        }
        else if (information[0].charAt(0) != ':') {
            throw new SyntaxException("variable name must start with semi colon");
        }

        myVariableName = information[0];
        myValueString = information[1];
        myValue = Double.parseDouble(information[1]);
    }

}
