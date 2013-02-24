package behavior;

import java.util.HashMap;
import java.util.Map;
import utilities.Model;

public class CommandEntities {
    
    private Map<String , ICommand> myCommands = new HashMap<String , ICommand>();

    private Model myModel;
    
    public CommandEntities(Model model){
        myModel = model;
    }
    

    public void addCommand(String command , ICommand newCommand){
        myCommands.put(command, newCommand);
    }
    public void removeCommand(String command){
        myCommands.remove(command);
    }

    public ICommand getCommand(String command){
        return myCommands.get(command);
    }

    public void doCommand(int index , String commandName, double distanceOrAngle){
        ICommand command = getCommand(commandName);
        command.move(myModel.getTurtle(index), distanceOrAngle);
    }
    
    









}
