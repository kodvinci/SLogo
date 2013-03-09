package behavior;

import java.util.regex.Pattern;
import slogo.Model;
import exceptions.SyntaxException;

public class Make implements ICommand {

    
    private Pattern myNumPattern = Pattern.compile("[0-9]*");
    private String myVariableName;
    private double myValue;
    
    
    public double move (Model model, int TurtleNumber) throws SyntaxException {
        model.addVariable(myVariableName, myValue);
        return myValue ;
    }

    public void initialize (String[] information, Model model) throws SyntaxException {
        if(information.length != 2) throw new SyntaxException();
        else if (myNumPattern.matcher(information[1]).matches()) throw new SyntaxException();
        myVariableName = information[0].substring(1);
        myValue = Double.parseDouble(information[1]);
    }

}
