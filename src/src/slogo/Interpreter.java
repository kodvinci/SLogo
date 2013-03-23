package slogo;

import java.util.ArrayList;
import java.util.List;
import behavior.ICommand;


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
     * parse user input
     * 
     * @param command command we want to parse
     * @param myCommandList command list after parsed
     * @param model model we want to operate
     * @throws Exception 
     * @throws ParameterException
     */

    public void parse (String command, List<ICommand> myCommandList, Model model) throws Exception {

        myParser.parse(command, myCommandList, model);

    }

    /**
     * this method can finish the process of input commands.
     * 
     * @param model the model
     * @param commands input of user
     * @throws Exception 
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
