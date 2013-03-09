package behavior.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import slogo.Model;
import slogo.Parser;
import behavior.ICommand;
import exceptions.NoSuchCommandException;
import exceptions.SyntaxException;


/**
 * Implements TO command
 * 
 * @author Jerry
 * 
 */
public class To implements ICommand {

    private List<ICommand> myCommandList = new ArrayList<ICommand>();
    private List<String[]> myVariables;
    private List<String[]> myCommands;
    private String myName;
    private Parser myParser = new Parser();

    private ResourceBundle myResources;

    /**
     * resources of commands
     */
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";

    /**
     * Initializes TO command
     * 
     * @param name name
     * @param variables variables
     * @param commands commands
     * @throws NoSuchCommandException No command exception
     * @throws SyntaxException Wrong syntax exception
     */
    public To (String name, List<String[]> variables, List<String[]> commands, Model model)
                                                                                           throws NoSuchCommandException,
                                                                                           SyntaxException {

        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");
        myVariables = variables;
        myCommands = commands;
        myName = name;
        System.out.println(myVariables.get(0).length + " " + myCommands.size());
        map(variables, commands, model);
    }

    /**
     * return name
     * 
     * @return
     */
    public String getName () {
        return myName;
    }

    /**
     * Maps stuff in brackets to respective lists
     * 
     * @param variables variables
     * @param commands commands
     * @throws NoSuchCommandException NoSuchCommandException
     * @throws SyntaxException SyntaxException
     */
    public void map (List<String[]> variables, List<String[]> commands, Model model)
                                                                                    throws NoSuchCommandException,
                                                                                    SyntaxException {
        for (int i = 0; i < commands.size(); i++) {
            String[] command = commands.get(i);
            System.out.println(Arrays.toString(command));
            String[] variable = variables.get(0);
            System.out.println(Arrays.toString(variable));
            String var = variable[i];
            String[] str = { command[0], var };
            ICommand myCommand = myParser.buildCommand(str, model);
            myCommandList.add(myCommand);
            System.out.println(myCommandList.size());
        }
    }

    /**
     * Move
     * 
     * @param model the model
     * @param turtleNumber the turtle
     * @throws SyntaxException SyntaxException
     */
    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        for (int i = 0; i < myCommandList.size(); i++) {
            myCommandList.get(i).move(model, turtleNumber);
        }

        return myCommandList.size();
    }

    @Override
    public void initialize (String[] information, Model model) throws SyntaxException {

    }

}
