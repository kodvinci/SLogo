package slogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
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
import exceptions.ParameterException;
import exceptions.SyntaxException;


/**
<<<<<<< HEAD
 * parse the command
 * 
 * @author Richard Yang
=======
>>>>>>> 0b9ccc6ce78591a46d0a6f2849f954e9db33bc8e
 * Parses input
 * 
 * @author Richard, Jerry
 * 
 */
public class Parser {

    private static final int TO_LENGTH = 3;
    private static final int IFELSE_LENGTH = 7;
    private static final String LEFT_BRACKET = "[";
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    private Map<String, ICommand> myUserToCommands = new HashMap<String, ICommand>();

    private Pattern myNumPattern;
    private Pattern myStrPattern;
    private Pattern mySpacePattern;
    private ResourceBundle myResources;
    private ResourceBundle myFlows;

    /**
<<<<<<< HEAD
     * constructor
=======
>>>>>>> 0b9ccc6ce78591a46d0a6f2849f954e9db33bc8e
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
<<<<<<< HEAD
     * Splits commands
     * 
     * @param commands commands
     * @return
=======
     * 
>>>>>>> 0b9ccc6ce78591a46d0a6f2849f954e9db33bc8e
     */

    public List<String[]> split(String s){
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
        
        for (int i = 0; i < l.size(); i++ )
        {
            System.out.println("presplit: " + l.get(i));
        }
        return addCommands(l);
    }
    
    public List<String[]> addCommands(List<String> l) {
        List<String[]> commandArray = new ArrayList<String[]>();
        
        for (int i = 0; i < l.size(); i++) {
            String[] simpleCommand = new String[2];
            String[] oneBracketCommand = new String[3];
            String[] twoBracketCommand = new String[4];
            if (myResources.containsKey(l.get(i))) {
                simpleCommand[0] = l.get(i);
                simpleCommand[1] = l.get(i+1);
                commandArray.add(simpleCommand);
            }
            else if (l.get(i).equals("IFELSE") || l.get(i).equals("TO")) {
                twoBracketCommand[0] = l.get(i);
                twoBracketCommand[1] = l.get(i + 1);
                twoBracketCommand[2] = l.get(i + 2);
                twoBracketCommand[3] = l.get(i + 3);
                commandArray.add(twoBracketCommand);
             }
        }
//        System.out.println("comandArray size: " + commandArray.size());
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
     */

    public ICommand buildCommand (String[] str, Model model) throws NoSuchCommandException,
                                                            SyntaxException {
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
                // model.showMessage("class not found");
            }
            Object o = null;
            try {
                o = commandClass.newInstance();
            }
            catch (InstantiationException | IllegalAccessException e) {

                // model.showMessage("illegal access");

            }
            ICommand myCommand = (ICommand) o;
            myCommand.initialize(subArray, null);
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
     */

    public List<ICommand> buildMultipleCommands (List<String[]> commands, Model model)
                                                                                      throws SyntaxException,
                                                                                      NoSuchCommandException {
        if (commands == null) { return null; }

        List<ICommand> myCommandList = new ArrayList<ICommand>();
        for (int i = 0; i < commands.size(); i++) {
            String[] str = commands.get(i);
            if (str[0].equals("IFELSE")) {
                parseIfElse(str[0], str[1], str[2], str[3], myCommandList, model);
                i += 3;
            }
            else if (str[0].equals("TO")) {
                parseTo(str[0], str[1], str[2], str[3], myCommandList, model);
            }
            else if (str[0].equals("REPEAT") || str[0].equals("IF")) {
              
            }
            else if (myResources.containsKey(str[0].toUpperCase())) {
                myCommandList.add(buildCommand(str, model));
            }
            
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
        for (int i = 0; i < size - 1; i++) {
            subArray[i] = str[i + 1];
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
        
        myCommandList.addAll(buildMultipleCommands(split(command), model));
       
    }
    

    /**
     * parse commands that need one bracket
     * 
     * @param command command we want to parse
     * @param myCommandList our commandlist, used for recursion
     * @param model model we want to operation
     * @throws NumberFormatException
     * @throws NoSuchCommandException
     * @throws SyntaxException
     * @throws NoSuchVariableException
     */
    public void parseOneBracket (String command, List<ICommand> myCommandList, Model model)
                                                                                           throws NoSuchCommandException,
                                                                                           SyntaxException,
                                                                                           NoSuchVariableException {

      
    }

    /**
     * Parses TO command
     * 
     * @param command String command
     * @param myCommandList command LIst
     * @return
     * @throws SyntaxException Syntax Exception
     * @throws NoSuchCommandException No command exception
     */
   
    
    public int parseTo (String name, String value, String firstBracket, String secondBracket, 
                        List<ICommand> myCommandList, Model model) throws NoSuchCommandException, SyntaxException {
        To currentTo = new To(name, value, firstBracket, secondBracket, model);
        myCommandList.add(currentTo);
        myUserToCommands.put(currentTo.getName(), currentTo);
        return currentTo.checkLength();
    }

    /**
     * parse ifelse statements
     * 
     * @param command Command
     * @param myCommandList command list
     * @throws SyntaxException Syntax Exeception
     * @throws NoSuchCommandException NoCommand exceptoin
     */

    public void parseIfElse (String command, String value, String firstBracket, String secondBracket, List<ICommand> myCommandList, Model model)
                                                                                       throws SyntaxException,
                                                                                       NoSuchCommandException {
       IfElse currentIfElse = new IfElse(command, value, firstBracket, secondBracket, model);
       myCommandList.add(currentIfElse);
       
    }


    /**
     * find first flow word in a string
     * 
     * @param command input command
     * @return position of first flow string
     */
  
}
