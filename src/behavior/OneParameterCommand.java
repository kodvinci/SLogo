package behavior;

import java.util.regex.Pattern;
import slogo.Model;
import exceptions.SyntaxException;

public abstract class OneParameterCommand implements ICommand {

    private double myValue;
    private Pattern myNumPattern = Pattern.compile("[0-9]*");
    
    @Override
    public double move (Model model, int TurtleNumber) throws SyntaxException {
        return 0;
    }

    @Override
    public void initialize (String[] information, Model model) throws SyntaxException {
        if(information.length != 1 || !myNumPattern.matcher(information[0]).matches()) throw new SyntaxException();
        myValue = Double.parseDouble(information[0]);
    }

    public double getMyValue () {
        return myValue;
    }

    public void inverseMyValue(){
        myValue = - myValue ;
    }
    
    
    
}
