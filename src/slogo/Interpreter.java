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
<<<<<<< HEAD
     * 
     * @param command
     * @param myCommandList
     * @param model
     * @throws SyntaxException
     * @throws NoSuchCommandException
     * @throws NumberFormatException
     * @throws NoSuchVariableException
     */

=======
     * @param command               Command
     * @param myCommandList         command list
     * @param model                     model
     * @throws SyntaxException              exception   
     * @throws NoSuchCommandException          exception    
     * @throws NumberFormatException            exception
     * @throws NoSuchVariableException      exception
     */
>>>>>>> 0124c9c34bf406d2012bea16f1f0d42f7c1c9dec
    public void parse (String command, List<ICommand> myCommandList, Model model)
                                                                                 throws SyntaxException,
                                                                                 NoSuchCommandException,
                                                                                 NumberFormatException,
                                                                                 NoSuchVariableException {

<<<<<<< HEAD
        myParser.parseOneBracket(command, myCommandList, model);

        // int repeatIndex = myParser.findFirstFlow(command, "REPEAT");
        // int toIndex = myParser.findFirstFlow(command, "TO");
        // int ifIndex = myParser.findFirstFlow(command, "IF");
        // int elseifIndex = myParser.findFirstFlow(command, "ELSEIF");
        //
        // myFlowMap.put(repeatIndex, "REPEAT");
        // myFlowMap.put(toIndex, "TO");
        // myFlowMap.put(ifIndex, "IF");
        // myFlowMap.put(elseifIndex, "ELSEIF");
        // myFlowOrder.add(repeatIndex);
        // myFlowOrder.add(toIndex);
        // myFlowOrder.add(ifIndex);
        // myFlowOrder.add(elseifIndex);
        //
        // Collections.sort(myFlowOrder);
        //
        // for (int i = 0; i < myFlowOrder.size(); i++) {
        // if (myFlowMap.get(myFlowOrder.get(i)).equals("REPEAT")) {
        // parseOneBracket(command, myCommandList, model)
        // }
        // }

        // myParser.parseTo(command, myCommandList, model);

        // int index = myParser.findFirstFlow(command);
        // if (index < 0) {
        // myParser.parseTo(command, myCommandList, model);
        // }
        // System.out.println("index" + index);
=======
        if (command.contains("REPEAT")) {
            myParser.parseOneBracket(command, myCommandList, model);
        }
        else if (command.contains("IFELSE")) {
            myParser.parseIfElse(command, myCommandList, model);
        }
        else if (command.contains("IF")) {
            myParser.parseOneBracket(command, myCommandList, model);
        }
        else if (command.contains("TO")) {
            myParser.parseTo(command, myCommandList, model);
        }
        else {
            myParser.parseOneBracket(command, myCommandList, model);
        }
        
>>>>>>> 0124c9c34bf406d2012bea16f1f0d42f7c1c9dec

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
                                                                        NoSuchCommandException,
                                                                        NumberFormatException,
                                                                        NoSuchVariableException {

        List<ICommand> myCommandList = new ArrayList<ICommand>();

        parse(commands, myCommandList, model);
        // System.out.println(myCommandList.size());
        for (ICommand ic : myCommandList) {

            // System.out.println("list size :" + myCommandList.size());
            ic.move(model, turtleNumber);
        }

    }

}
