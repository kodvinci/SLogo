package slogo;

import behavior.ICommand;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Richard Yang & Jerry Li
 * 
 */
public class Interpreter {

    private Parser myParser;

    /**
     * Constructs an interpreter
     */
    public Interpreter () {
        myParser = new Parser();
    }

    /**
     * parse commands  
     * @param command           user input
     * @param myCommandList     list of commands
     * @param model             model
     * @throws Exception        exception
     */
    public void parse (String command, List<ICommand> myCommandList, 
                       Model model) throws Exception {

        myParser.parse(command, myCommandList, model);

    }

    /**
     * process user input
     * @param model             model
     * @param turtleNumber      turtle number
     * @param commands          commands
     * @throws Exception        exception
     */
    public void process (Model model, int turtleNumber, String commands) throws Exception {
        List<ICommand> myCommandList = new ArrayList<ICommand>();

        parse(commands, myCommandList, model);
        // System.out.println(myCommandList.size());
        for (ICommand ic : myCommandList) {

            // System.out.println("list size :" + myCommandList.size());
            ic.move(model, turtleNumber);
        }

    }

}
