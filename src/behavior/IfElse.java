
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import slogo.Model;
import slogo.Parser;
import exceptions.NoSuchCommandException;
import exceptions.SyntaxException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;
import behavior.ICommand;

public class IfElse implements ICommand {
    
    private List<ICommand> myCommandList = new ArrayList<ICommand>();
    private List<String[]> myTrueCommands;
    private List<String[]> myFalseCommands;
    private String myName;
    private Parser myParser = new Parser();
    
    private ResourceBundle myResources;
    
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";  
    
    public IfElse (String name, List<String[]> trueCommands, List<String[]> falseCommands, double Value) throws NoSuchCommandException, SyntaxException{
        
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");
        myTrueCommands = trueCommands;
        myFalseCommands = falseCommands;
        myName = name;
        System.out.println(myTrueCommands.size() + " " + myFalseCommands.size());
        map(myTrueCommands, myFalseCommands);
    }
    
    public String getName() {
        return myName;
    }
    
    public void map(List<String[]> trueCommands, List<String[]> falseCommands) throws NoSuchCommandException, SyntaxException {
        for (int i =0; i < commands.size(); i++) {
            String[] command = commands.get(i);
            System.out.println(Arrays.toString(command));
            String[] variable = variables.get(0);
            System.out.println(Arrays.toString(variable));
            String var = variable[i];
            String[] str = {command[0], var};
            ICommand myCommand = myParser.buildCommand(str);
            myCommandList.add(myCommand);
            System.out.println(myCommandList.size());
            }
    }
    
    public double move (Model model, int turtleNumber) throws SyntaxException {
        for (int i = 0; i < myCommandList.size(); i++) {
            myCommandList.get(i).move(model, turtleNumber);
        }
        
        return myCommandList.size();
    }
    
    public void initialize(String[] string, Model model) {
        
    }
    
    
}