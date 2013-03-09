package slogo;

import behavior.CommandEntities;
import behavior.ICommand;

import exceptions.NoSuchCommandException;
import exceptions.SyntaxException;
import behavior.To;
import java.util.Map;
import behavior.IfElse;
import behavior.Repeat;
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

    private static final int TO_LENGTH = 3;
    private static final int IFELSE_LENGTH = 7;
    private static final String END_BRACKET = "]";

    private CommandEntities myCommands;
    private Pattern myNumPattern;
    private Pattern myStrPattern;
    private Parser myParser;

    private Map<String, ICommand> myUserToCommands = new HashMap<String, ICommand>();

    /**
     * Constructs an interpreter
     */
    public Interpreter () {
        myNumPattern = Pattern.compile("[0-9]*");
        myStrPattern = Pattern.compile("[a-zA-Z]*");
        myParser = new Parser();
    }


   
    
    
    public void parse (String command, List<ICommand> myCommandList) throws SyntaxException, NoSuchCommandException {
        myParser.parseOneBracket(command, myCommandList);
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
    public int parseTo (String command, List<ICommand> myCommandList)
                                                                     throws SyntaxException,
                                                                     NoSuchCommandException {

        int position = command.indexOf("TO");
        if (position == -1) {
            myCommandList.addAll(myParser.buildMultipleCommands(myParser.split(command)));
        }
        else {
            String formerString = command.substring(0, position);
            if (formerString.length() != 0) {
                myCommandList.addAll(myParser.buildMultipleCommands(myParser.split(formerString)));
            }
            int bracketPosition = command.indexOf("[");
            
            String commandName = command.substring(position + TO_LENGTH, bracketPosition);
            String post = command.substring(bracketPosition + 1, command.length());
            String variable = post.substring(0, post.indexOf(END_BRACKET));
            String temp = post.substring(post.indexOf("[") + 1, post.length() - 1);
            String commandsBracket = temp.substring(0, temp.indexOf(END_BRACKET));
            String recurse = temp.substring(temp.indexOf(END_BRACKET)+1, temp.length()-1);
            
            List<String[]> variables = myParser.split(variable);
            List<String[]> commandsFromBracket = myParser.split(commandsBracket);
            
            myCommandList.add(new To(commandName, variables, commandsFromBracket));
            myUserToCommands.put(commandName, new To(commandName, variables, commandsFromBracket));
            if (recurse.length() != 0) {
                parse(recurse, myCommandList);
            }
            if (variables.get(0).length == commandsFromBracket.size()) {
                return 1;
            }
            else {
                return 0;
            }
        }

        return 0;
    }

    /**
     * Parses IFElse statements
     * 
     * @param command the user command
     * @param myCommandList list of commands
     * @throws SyntaxException if syntax is wrong
     * @throws NoSuchCommandException if command is not existent
     */
    public void parseIfElse (String command, List<ICommand> myCommandList) throws SyntaxException,
                                                                          NoSuchCommandException {
        int position = command.indexOf("IFELSE");
        if (position == -1) {
            myCommandList.addAll(myParser.buildMultipleCommands(myParser.split(command)));
        }
        else {
            String formerString = command.substring(0, position);
            if (formerString.length() != 0) {
                myCommandList.addAll(myParser.buildMultipleCommands(myParser.split(formerString)));
            }
            int bracketPosition = command.indexOf("[");
            String value = command.substring(position + IFELSE_LENGTH, bracketPosition);
            String post = command.substring(bracketPosition + 1, command.length());
            String trueCommand = post.substring(0, post.indexOf("]"));
            String temp = post.substring(post.indexOf("[") + 1, post.length() - 1);
            String falseCommand = temp.substring(0, temp.indexOf(END_BRACKET));
            String recurse = temp.substring(temp.indexOf(END_BRACKET)+1, temp.length()-1);
            
            List<String[]> trueCommands = myParser.split(trueCommand);
            List<String[]> falseCommands = myParser.split(falseCommand);
            double doubleValue = Double.parseDouble(value);
            System.out.println(doubleValue);
            ICommand currentIfElse = new IfElse(trueCommands, falseCommands, doubleValue);
            myCommandList.add(currentIfElse);
            if (recurse.length() != 0) {
                parse(recurse, myCommandList);
            }
        }
    }

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
        parseTo(commands, myCommandList);
        System.out.println(myCommandList.size());
        for (ICommand ic : myCommandList) {

            System.out.println(myUserToCommands.size());

            System.out.println("list size :" + myCommandList.size());
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
