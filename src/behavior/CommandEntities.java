package behavior;

import java.util.List;
import slogo.Model;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public class CommandEntities {

    /**
     * 
     * @param model model to apply command
     * @param turtleNumber which turtle we want to operate
     * @param commands user commands
     * @throws SyntaxException wrong syntax format
     */
    public void doCommand (Model model, int turtleNumber, List<ICommand> commands)
                                                                                  throws SyntaxException {
        for (ICommand command : commands) {
            command.move(model, turtleNumber);
        }
    }

}
