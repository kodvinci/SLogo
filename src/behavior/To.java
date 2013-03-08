package behavior;

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

public class To implements ICommand {
    
    private List<ICommand> myCommandList;
    private List<String[]> myVariables;
    private List<String[]> myCommands;
    private String myName;
    private Parser myParser = new Parser();
    
    private ResourceBundle myResources;
    
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";  
    
    public To (String name, List<String[]> variables, List<String[]> commands) throws NoSuchCommandException, SyntaxException{
        
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");

        
        myVariables = variables;
        myCommands = commands;
        myName = name;
        System.out.println(myVariables.get(0).length + " " + myCommands.size());
        map(variables, commands);
    }
    
    public String getName() {
        return myName;
    }
    
    public void map(List<String[]> variables, List<String[]> commands) throws NoSuchCommandException, SyntaxException {
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
    
    public void initialize(String[] string) {
        
    }
    
    
}