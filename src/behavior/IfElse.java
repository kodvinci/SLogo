package behavior; 

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import slogo.Model;
import slogo.Parser;
import exceptions.NoSuchCommandException;
import exceptions.SyntaxException;
import behavior.ICommand;

public class IfElse implements ICommand {
    
    private List<String[]> myStringTrueCommands;
    private List<String[]> myStringFalseCommands;
    private List<ICommand> myTrueCommands;
    private List<ICommand> myFalseCommands;
    private Parser myParser = new Parser();
    private double myValue;
    private double myFinalValue;
    
    private ResourceBundle myResources;
    
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";  
    
    public IfElse (List<String[]> trueCommands, List<String[]> falseCommands, double Value) throws NoSuchCommandException, SyntaxException{
        
        myStringTrueCommands = trueCommands;
        myStringFalseCommands = falseCommands;
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");
        myTrueCommands = new ArrayList<ICommand>();
        myFalseCommands = new ArrayList<ICommand>();
        myValue = Value;
        map(trueCommands, falseCommands);
    }
    
    public double getMyFinalValue() {
        return myFinalValue;
    }
    
    public void map(List<String[]> trueCommands, List<String[]> falseCommands) throws NoSuchCommandException, SyntaxException {
        myTrueCommands = buildCommands(trueCommands);
        myFalseCommands = buildCommands(falseCommands);
    }
    
    public List<ICommand> buildCommands(List<String[]> commands) throws NoSuchCommandException, SyntaxException {
        List<ICommand> theCommands = new ArrayList<ICommand>();
        for (int i =0; i < commands.size(); i++) {
            String[] command = commands.get(i);
            ICommand myCommand = myParser.buildCommand(command);
            theCommands.add(myCommand);
        }
        return theCommands;
    }
    
    
    public double move (Model model, int turtleNumber) throws SyntaxException {
        myFinalValue = move(model, turtleNumber, myValue);
        return myFinalValue;
    }
    
    public double move(Model model, int turtleNumber, double value) throws SyntaxException {
        if (value == 0) {
            for (int i = 0; i < myFalseCommands.size(); i++) {
                myFalseCommands.get(i).move(model, turtleNumber);
            }
            double myLastValue = Double.parseDouble(myStringTrueCommands.get(myStringTrueCommands.size()-1)[1]);
            return myLastValue;
        }
        else {
            for (int i = 0; i < myTrueCommands.size(); i++) {
                myTrueCommands.get(i).move(model, turtleNumber);
            }
            double myLastValue = Double.parseDouble(myStringFalseCommands.get(myStringFalseCommands.size()-1)[1]);
            return myLastValue;
        }
        
        
    }
    
    public void initialize(String[] string) {
        
    }
    
    
}