package slogo;

import behavior.CommandEntities;
import behavior.ICommand;

import exceptions.NoSuchCommandException;
import exceptions.SyntaxException;
import behavior.To;
import java.util.Map;
import behavior.IfElse;
import behavior.To;
import exceptions.NoSuchCommandException;
import exceptions.SyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


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


    /**
     * Constructs an interpreter
     */
    public Interpreter () {
        myNumPattern = Pattern.compile("[0-9]*");
        myStrPattern = Pattern.compile("[a-zA-Z]*");
        myParser = new Parser();
    }


   
    
    
    public void parse (String command, List<ICommand> myCommandList) throws SyntaxException, NoSuchCommandException {
        myParser.parseIfElse(command, myCommandList);
    }

    /**
     * Parses to
     * 
     * @param command The user input
     * @param myCommandList list of I command
     * @return
     * @throws SyntaxException if synatx is wrong
     * @throws NoSuchCommandException if no command exists
     */
   
    /**
     * this method can finish the process of input commands.
     * 
     * @param model the model
     * @param commands input of user
     * @throws SyntaxException Syntax exception
     * @throws NoSuchCommandException
     */
    public void process (Model model, int turtleNumber, String commands) throws SyntaxException,
                                                                        NoSuchCommandException {

        List<ICommand> myCommandList = new ArrayList<ICommand>();

        parse(commands,myCommandList);
        //System.out.println(myCommandList.size());
        for (ICommand ic : myCommandList) {


           // System.out.println("list size :" + myCommandList.size());
            ic.move(model, turtleNumber);
        }

    }

    /**
     * Makes a variable from user input
     * 
     * @param model the slogo model
     * @param currentCommand current command
     * @throws SyntaxException syntax exception
     */
    public void makeVariable (Model model, String[] currentCommand) throws SyntaxException {

        if (currentCommand.length < 2) { throw new SyntaxException(); }
        String name = currentCommand[0];
        String value = currentCommand[1];
        if (!(myStrPattern.matcher(name).matches() && myNumPattern.matcher(value).matches())) {
            throw new SyntaxException();
        }
        else {
            model.addVariable(name, Double.parseDouble(value));
        }
    }

}
