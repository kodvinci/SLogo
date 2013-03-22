package slogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import behavior.CommandEntities;
import behavior.ICommand;
import exceptions.NoSuchCommandException;
import exceptions.NoSuchVariableException;
import exceptions.ParameterException;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang & Jerry Li
 * 
 */
public class Interpreter {

    private CommandEntities myCommands;
    private Pattern myNumPattern;
    private Pattern myStrPattern;
    private Parser myParser;

    private Map<Integer, String> myFlowMap = new TreeMap<Integer, String>();
    private List<Integer> myFlowOrder = new ArrayList<Integer>();

    /**
     * Constructs an interpreter
     */
    public Interpreter () {
        myNumPattern = Pattern.compile("[0-9]*");
        myStrPattern = Pattern.compile("[a-zA-Z]*");
        myParser = new Parser();
    }

    /**
     * parse user input
     * 
     * @param command command we want to parse
     * @param myCommandList command list after parsed
     * @param model model we want to operate
     * @throws SyntaxException
     * @throws NoSuchCommandException
     * @throws NoSuchVariableException
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     * @throws ParameterException 
     */

    public void parse (String command, List<ICommand> myCommandList, Model model)
                                                                                 throws SyntaxException,
                                                                                 NoSuchCommandException,
                                                                                 NoSuchVariableException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        myParser.parse(command, myCommandList, model);
      
        



     

    }

    /**
     * this method can finish the process of input commands.
     * 
     * @param model the model
     * @param commands input of user
     * @throws SyntaxException Syntax exception
     * @throws NoSuchCommandException
     * @throws NoSuchVariableException
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public void process (Model model, int turtleNumber, String commands) throws SyntaxException,
                                                                        NoSuchCommandException,
                                                                        NoSuchVariableException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        List<ICommand> myCommandList = new ArrayList<ICommand>();

        parse(commands, myCommandList, model);
        // System.out.println(myCommandList.size());
        for (ICommand ic : myCommandList) {

            // System.out.println("list size :" + myCommandList.size());
            ic.move(model, turtleNumber);
        }

    }

}
