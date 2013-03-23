package behavior;

import java.util.List;
import slogo.Model;


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
     * @throws Exception 
     */
    public void doCommand (Model model, int turtleNumber, List<ICommand> commands)
                                                                                  throws Exception {
        for (ICommand command : commands) {
            command.move(model, turtleNumber);
        }
    }

}
