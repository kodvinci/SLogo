package behavior.flow;

import java.util.ArrayList;
import java.util.List;
import slogo.Model;
import slogo.Parser;
import behavior.ICommand;
import exceptions.NoSuchCommandException;
import exceptions.NoSuchVariableException;
import exceptions.SyntaxException;


/**
 * if command
 * 
 * @author Richard Yang
 * 
 */
public class If implements ICommand {

    private List<ICommand> myCommands = new ArrayList<ICommand>();
    private Parser myParser = new Parser();
    private int myStatement;

    /**
     * construcor for if class
     * 
     * @param subCommands command string
     * @param statement parameter to judge whether we should run commands or not
     * @param model model we want to operate
     * @throws NoSuchCommandException do not have such command
     * @throws SyntaxException wrong syntax
     * @throws NoSuchVariableException do not have this variable in this model
     */
    public If (String subCommands, int statement, Model model) throws NoSuchCommandException,
                                                              SyntaxException,
                                                              NoSuchVariableException {

        myStatement = statement;
        myParser.parseOneBracket(subCommands, myCommands, model);

    }

    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        if (myStatement != 0) {
            for (ICommand command : myCommands) {
                command.move(model, turtleNumber);
            }
        }
        return myStatement;
    }

    @Override
    public void initialize (String[] information, Model model) throws SyntaxException {

    }

}
