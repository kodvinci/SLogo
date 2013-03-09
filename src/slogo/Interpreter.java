package slogo;

import behavior.CommandEntities;
import behavior.ICommand;

import exceptions.NoSuchCommandException;
import exceptions.NoSuchVariableException;
import exceptions.SyntaxException;
import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;
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


   
    
    
    public void parse (String command, List<ICommand> myCommandList, Model model) throws SyntaxException, NoSuchCommandException, NumberFormatException, NoSuchVariableException {
        
       int index = myParser.findFirstFlow(command);
       if (index < 0) {
          myParser.parseTo(command, myCommandList, model);
       }
       System.out.println("index" + index);
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
     * @throws NoSuchVariableException 
     * @throws NumberFormatException 
     */
    public void process (Model model, int turtleNumber, String commands) throws SyntaxException,
                                                                        NoSuchCommandException, NumberFormatException, NoSuchVariableException {

        List<ICommand> myCommandList = new ArrayList<ICommand>();

        parse(commands,myCommandList,model);
        //System.out.println(myCommandList.size());
        for (ICommand ic : myCommandList) {


           // System.out.println("list size :" + myCommandList.size());
            ic.move(model, turtleNumber);
        }

    }


}
