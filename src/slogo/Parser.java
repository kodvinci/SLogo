package slogo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import behavior.ICommand;
import behavior.flow.If;
import behavior.flow.IfElse;
import behavior.flow.Repeat;
import behavior.flow.To;
import exceptions.NoSuchCommandException;
import exceptions.NoSuchVariableException;
import exceptions.SyntaxException;


public class Parser {

    private static final int TO_LENGTH = 3;
    private static final int IFELSE_LENGTH = 7;
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    private Map<String, ICommand> myUserToCommands = new HashMap<String, ICommand>();

    private Pattern myNumPattern;
    private Pattern myStrPattern;
    private Pattern mySpacePattern;
    private ResourceBundle myResources;
    private ResourceBundle myFlows;

    public Parser () {
        myNumPattern = Pattern.compile("[0-9]*");
        myStrPattern = Pattern.compile("[a-zA-Z]*");
        mySpacePattern = Pattern.compile("[\\s]+");
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");
        myFlows = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "flow");
    }

    public ArrayList<String[]> split (String commands) {

        if (commands == null) { return null; }

        ArrayList<String[]> allCommands = new ArrayList<String[]>();
        ArrayList<StringBuffer> allBuffers = new ArrayList<StringBuffer>();

        for (int i = 0; i < commands.length(); i++) {
            if (commands.charAt(i) != ' ') {
                commands = commands.substring(i);
                break;
            }
        }

        String[] cutBySpace = mySpacePattern.split(commands);
        if (cutBySpace.length == 0) { return null; }
        StringBuffer buffer = new StringBuffer();
        buffer.append(cutBySpace[0]);
        for (int i = 1; i < cutBySpace.length; i++) {
            if (myStrPattern.matcher(cutBySpace[i]).matches()) {

                allBuffers.add(buffer);
                buffer = new StringBuffer();
                buffer.append(cutBySpace[i]);
            }
            else if (myNumPattern.matcher(cutBySpace[i]).matches()) {
                buffer.append(" ");
                buffer.append(cutBySpace[i]);
            }
        }
        allBuffers.add(buffer);

        for (int i = 0; i < allBuffers.size(); i++) {
            String[] str = mySpacePattern.split(allBuffers.get(i).toString());
            allCommands.add(str);
            str = null;
        }

        return allCommands;
    }

    public ICommand buildCommand (String[] str, Model model) throws NoSuchCommandException, SyntaxException {
        if (!myResources.containsKey(str[0].toUpperCase())) {
            throw new NoSuchCommandException();
        }
        else {
            String[] subArray = subStringArray(str);
            System.out.println(str[0]);
            String commandName = myResources.getString(str[0].toUpperCase());
            
            Class<?> commandClass = null;
            try {
                commandClass = Class.forName("behavior." + commandName);
            }
            catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Object o = null;
            try {
                o = commandClass.newInstance();
            }
            catch (InstantiationException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ICommand myCommand = (ICommand) o;
            myCommand.initialize(subArray, null);
            return myCommand;

        }
    }

    public List<ICommand> buildMultipleCommands (List<String[]> commands, Model model) throws SyntaxException,
                                                                         NoSuchCommandException {
        if (commands == null) { return null; }

        List<ICommand> myCommandList = new ArrayList<ICommand>();
        for (String[] str : commands) {
            myCommandList.add(buildCommand(str, model));
        }
        return myCommandList;
    }

    public String[] subStringArray (String[] str) {
        int size = str.length;
        String[] subArray = new String[size - 1];
        for (int i = 0; i < size - 1; i++) {
            subArray[i] = str[i + 1];
        }

        return subArray;
    }

    public int findRelatedBrackets (String str, int position) throws SyntaxException {
        if (str.charAt(position) != '[') {
            throw new SyntaxException();
        }
        else {
            int priority = 0;
            int i = position;
            for (i = position + 1; i < str.length(); i++) {
                if (priority == 0 && str.charAt(i) == ']') {
                    break;
                }
                else if (str.charAt(i) == '[') {
                    priority++;
                }
                else if (str.charAt(i) == ']') {
                    priority--;
                }
            }
            return i;
        }
    }

    public void parseOneBracket (String command, List<ICommand> myCommandList, Model model)
                                                                              throws NumberFormatException,
                                                                              NoSuchCommandException,

                                                                              SyntaxException, NoSuchVariableException{
        
        
        int position = findFirstFlow(command);

        if (position == -1) {
            myCommandList.addAll(buildMultipleCommands(split(command), model));
        }
        else {
            String formerString = command.substring(0, position);
            if (formerString.length() != 0 && !mySpacePattern.matcher(formerString).matches()) {
                myCommandList.addAll(buildMultipleCommands(split(formerString), model));
            }
            int bracketPosition = command.indexOf("[");
            int end = findRelatedBrackets(command, bracketPosition);

            String postString = "";

            if (end != command.length()) {
                postString = command.substring(end + 1);
            }

            String repeatString = command.substring(position, bracketPosition);

            List<String[]> repeatBuffer = split(repeatString);
            String flowName = repeatBuffer.get(0)[0].toUpperCase();
            String recursionString = command.substring(bracketPosition + 1, end - 1);
            System.out.println("recursionString : " + recursionString);
            if (flowName.equals("REPEAT")){
                myCommandList.add(new Repeat(recursionString, Integer.parseInt(repeatBuffer.get(0)[1]),model));
            }else if (flowName.equals("IF")){
                myCommandList.add(new If(recursionString, Integer.parseInt(repeatBuffer.get(0)[1]),model));
            }
            if (postString.length() != 0 && !mySpacePattern.matcher(postString).matches()) {
                parseOneBracket(postString, myCommandList, model);
            }

        }
    }
    
    /**
     * Parses TO command
     * @param command                   String command
     * @param myCommandList             command LIst
     * @return
     * @throws SyntaxException             Syntax Exception
     * @throws NoSuchCommandException       No command exception
     */
    public int parseTo (String command, List<ICommand> myCommandList, Model model)
            throws SyntaxException,
            NoSuchCommandException {
        int position = command.indexOf("TO");
        if (position == -1) {
            myCommandList.addAll(buildMultipleCommands(split(command), model));
        }
        else {
            String formerString = command.substring(0, position);
            if (formerString.length() != 0) {
                myCommandList.addAll(buildMultipleCommands(split(formerString), model));
            }
            int bracketPosition = command.indexOf("[");
            String commandName = command.substring(position + TO_LENGTH, bracketPosition);
            String post = command.substring(bracketPosition + 1, command.length());
           // System.out.println("This is after the command: " + post);
            String variable = post.substring(0, post.indexOf("]"));
           // System.out.println("This is the variables: " + variable);
            String temp = post.substring(post.indexOf("[") + 1, post.length());
           // System.out.println("This is everything after the variable: " + temp);
            String commandsBracket = temp.substring(0, temp.indexOf("]"));
           // System.out.println("This is the commands: " + commandsBracket);
            String recurse = temp.substring(temp.indexOf("]") + 1, temp.length());
           // System.out.println("This is the stuff after: " + recurse);

            List<String[]> variables = split(variable);
            List<String[]> commandsFromBracket = split(commandsBracket);

            myCommandList.add(new To(commandName, variables, commandsFromBracket, model));
            myUserToCommands.put(commandName, new To(commandName, variables, commandsFromBracket, model));
            if (recurse.length() != 0) {
                parseTo(recurse, myCommandList, model);
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
     * parse ifelse statements
     * @param command                   Command
     * @param myCommandList             command list
     * @throws SyntaxException          Syntax Exeception
     * @throws NoSuchCommandException   NoCommand exceptoin
     */
    public void parseIfElse (String command, List<ICommand> myCommandList, Model model) throws SyntaxException,
                                                                          NoSuchCommandException {
        int position = command.indexOf("IFELSE");
        if (position == -1) {
            myCommandList.addAll(buildMultipleCommands(split(command), model));
        }
        else {
            String formerString = command.substring(0, position);
            if (formerString.length() != 0) {
                myCommandList.addAll(buildMultipleCommands(split(formerString), model));
            }
            int bracketPosition = command.indexOf("[");
            String value = command.substring(position + IFELSE_LENGTH, bracketPosition);
            String post = command.substring(bracketPosition + 1, command.length());
           // System.out.println("This is after the command: " + post);
            String trueCommand = post.substring(0, post.indexOf("]"));
           // System.out.println("THis is true commands: " + trueCommand);
            String temp = post.substring(post.indexOf("[") + 1, post.length());
           // System.out.println("This is everything after true COmmand: " + temp);
            String falseCommand = temp.substring(0, temp.indexOf("]"));
           // System.out.println("This is false command " + falseCommand);
            String recurse = temp.substring(temp.indexOf("]") + 1, temp.length());
           // System.out.println("THis is eveyrhting after: " + recurse);

            List<String[]> trueCommands = split(trueCommand);
            List<String[]> falseCommands = split(falseCommand);
            double doubleValue = Double.parseDouble(value);
            System.out.println(doubleValue);
            ICommand currentIfElse = new IfElse(trueCommands, falseCommands, doubleValue, model);
            myCommandList.add(currentIfElse);
            if (recurse.length() != 0) {
                parseIfElse(recurse, myCommandList, model);
            }
        }
    }
    public int findFirstFlow(String command){

        int toAndIf = 0;
        int repeatAndIfElse = 0;
        for(int i = 0 ; i< command.length()-1 ; i++){
            if(myFlows.containsKey(command.substring(i, i+2).toUpperCase())){
                toAndIf = i;
            }
        }
        for(int i = 0 ; i< command.length()-5 ; i++){
            if(myFlows.containsKey(command.substring(i, i+6).toUpperCase())){
                repeatAndIfElse = i;
            }
        }
        if(toAndIf < repeatAndIfElse){
            return toAndIf;
        }else if (toAndIf > repeatAndIfElse){
 
            return toAndIf;
        }else return -1;
    }

}
