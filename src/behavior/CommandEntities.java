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
    
    public void doCommand (Model model, int turtleNumber , List<ICommand> commands) throws SyntaxException  {
        for(ICommand command : commands){
            command.move(model, turtleNumber);
        }
    }

}
