package behavior;

import java.util.regex.Pattern;
import slogo.Model;
import exceptions.SyntaxException;

public abstract class TwoParameterCommand implements ICommand {

    private double myFirstValue;
    private double mySecondValue;
    private Pattern myNumPattern = Pattern.compile("[0-9]*");
    
    @Override
    public double move (Model model, int TurtleNumber) throws SyntaxException {
        return 0;
    }

    @Override
    public void initialize (String[] information, Model model) throws SyntaxException {
        if(information.length != 2 || !myNumPattern.matcher(information[0]).matches() || 
                !myNumPattern.matcher(information[1]).matches()) throw new SyntaxException();
        myFirstValue = Double.parseDouble(information[0]);
        mySecondValue = Double.parseDouble(information[1]);
    }

    public double getMyFirstValue () {
        return myFirstValue;
    }

    public double getMySecondValue () {
        return mySecondValue;
    }
}
