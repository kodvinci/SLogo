package slogo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import behavior.ICommand;
import behavior.If;
import behavior.IfElse;
import behavior.Repeat;
import behavior.To;
import exceptions.NoSuchCommandException;
import exceptions.NoSuchVariableException;
import exceptions.ParameterException;
import exceptions.SyntaxException;


/**
 * parse the command
 * 
 * @author Richard Yang
 * Parses input
 * 
 * @author Richard, Jerry
 * 
 */
public class Parser {

    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    private Map<String, ICommand> myUserToCommands = new HashMap<String, ICommand>();

    private Pattern myNumPattern;
    private Pattern myStrPattern;
    private Pattern mySpacePattern;
    private ResourceBundle myResources;
    private ResourceBundle myFlows;
    


    /**
     * constructor
     * Constructs parser
     */
    public Parser () {
        myNumPattern = Pattern.compile("[0-9]*");
        myStrPattern = Pattern.compile("[a-zA-Z]*");
        mySpacePattern = Pattern.compile("[\\s]+");
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");
        myFlows = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "flow");
    }

    /**
     * split the string
     * 
     * @param commands commands we want to split
     * @return splited string
     * Splits commands
     * 
     * @param commands commands
     * @return
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * 
     */

    public List<String[]> split(String s, Model model) {
        List<String> l = new LinkedList<String>();
        int depth=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='['){
                depth += 1;
            }else if(c==']'){
                depth -= 1;
            }else if(c==' ' && depth==0){
                l.add(sb.toString());
                sb = new StringBuilder();
                continue;
            }
            sb.append(c);
        }
        l.add(sb.toString());
        
        for (String g : l) {
            System.out.println("presplit: " + g);
        }
        return addCommands(l, model);
    }
    
    public List<String[]> addCommands(List<String> l, Model model) {
        List<String[]> commandArray = new ArrayList<String[]>();
        for (int i = 0; i < l.size(); i++) {
            String[] simpleCommand = new String[2];
            String[] oneBracketCommand = new String[3];
            String[] twoBracketCommand = new String[4];
            if (l.get(i).equals("IFELSE") || l.get(i).equals("TO")) {
                twoBracketCommand[0] = l.get(i);
                twoBracketCommand[1] = l.get(i + 1);
                twoBracketCommand[2] = l.get(i + 2);
                twoBracketCommand[3] = l.get(i + 3);
                System.out.println(twoBracketCommand[3]);
                commandArray.add(twoBracketCommand);
             }
            else if (l.get(i).equals("REPEAT") || l.get(i).equals("IF")) {
                oneBracketCommand[0] = l.get(i);
                oneBracketCommand[1] = l.get(i+1);
                oneBracketCommand[2] = l.get(i+2);
                System.out.println("did repeat add it? " +oneBracketCommand[2]);
                commandArray.add(oneBracketCommand);
            }
            else if (model.getUserCommands().containsKey(l.get(i))) {
                simpleCommand[0] = l.get(i);
                commandArray.add(simpleCommand);
            }
            else if (myResources.containsKey(l.get(i))) {
                simpleCommand[0] = l.get(i);
                simpleCommand[1] = l.get(i+1);
                commandArray.add(simpleCommand);
            }
//            Class<?> commandClass = null;
//            try {
//                commandClass = Class.forName("behavior." + l.get(i));
//                System.out.println(l.get(i) + "success");
//            }
//            catch (ClassNotFoundException e) {
//                // model.showMessage("class not found");
//            }
//            
//            Method getParameter = commandClass.getMethod("getParameterNumber", null);
//            Object returnValue = getParameter.invoke(null, )
        }
        
        for (int i = 0; i < commandArray.size(); i++) {
            System.out.println("User input: " + Arrays.toString(commandArray.get(i)));
        }
        return commandArray;
    }

    /**
     * build a command through string we got
     * 
     * @param str splited input commands
     * @param model model we want to operate
     * @return command
     * @throws NoSuchCommandException
     * @throws SyntaxException
     * @throws NoSuchVariableException 
     */

    public ICommand buildCommand (String[] str, Model model) throws SyntaxException, NoSuchVariableException, NoSuchCommandException {
        if (model.getUserCommands().containsKey(str[0])) {
            return (ICommand) model.getUserCommands().get(str[0]);
        }
        else if (!myResources.containsKey(str[0].toUpperCase())) {
            throw new NoSuchCommandException();
        }
        else {
            String[] subArray = subStringArray(str);
            String commandName = myResources.getString(str[0].toUpperCase());

            Class<?> commandClass = null;
            try {
                commandClass = Class.forName("behavior." + commandName);
                System.out.println(commandName + "success");
            }
            catch (ClassNotFoundException e) {
                // model.showMessage("class not found");
            }
            Object o = null;
            try {
                o = commandClass.newInstance();
                System.out.println("object success");
            }
            catch (InstantiationException | IllegalAccessException e) {

                // model.showMessage("illegal access");

            }
            ICommand myCommand = (ICommand) o;
            myCommand.initialize(subArray, model);
            return myCommand;

        }
    }

    /**
     * build multiple commands
     * 
     * @param commands command strings
     * @param model mode we want to operate
     * @return
     * @throws SyntaxException
     * @throws NoSuchCommandException
     * @throws NoSuchVariableException 
     */

    public List<ICommand> buildMultipleCommands (List<String[]> commands, Model model)
                                                                                      throws SyntaxException,
                                                                                      NoSuchCommandException, NoSuchVariableException {
        if (commands == null) { return null; }

        List<ICommand> myCommandList = new ArrayList<ICommand>();
        for (int i = 0; i < commands.size(); i++) {
            String[] str = commands.get(i);
                myCommandList.add(buildCommand(str, model));
        }
        
        return myCommandList;
    }
    
   
    
    
    /**
     * delete first element of a string
     * 
     * @param str input string
     */
    public String[] subStringArray (String[] str) {
        int size = str.length;
        String[] subArray = new String[size - 1];
        for (int i = 0; i < size-1; i++) {
            subArray[i] = str[i + 1];
            System.out.println("Subarray: " + subArray[i]);
        }
        
        return subArray;
    }

    /**
     * find brackets that are in pair
     * 
     * @param str input string
     * @param position position of "["
     * @return position of "]"
     * @throws SyntaxException
     */
   
    
    public void parse(String command, List<ICommand> myCommandList, Model model)  throws NoSuchCommandException,
        SyntaxException,
        NoSuchVariableException {
        
        
        myCommandList.addAll(buildMultipleCommands(split(command, model), model));
    }
    

   
}
