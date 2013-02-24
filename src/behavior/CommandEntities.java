package behavior;

import java.util.HashMap;
import java.util.Map;
import utilities.Model;

public class CommandEntities {
    
    public static final String FORWARD = "FD";
    
    public static final String BACK = "BK";
    
    public static final String LEFT = "LT";
    
    public static final String RIGHT = "RT";
    
    public static final String SETHEADING = "SETH";
    
    public static final String TOWARDS = "TOWARDS";
    
    public static final String SETXY = "SETXY";
    
    public static final String PENDOWN = "PD";
    
    public static final String PENUP = "PU";
    
    public static final String SHOWTURTLE = "ST";
    
    public static final String HIDETURTLE = "HT";
    
    public static final String HOME = "HOME";
    
    public static final String CLEARSCREEN = "CS";
    
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

    public void initialize(){
        myCommands.put(FORWARD, new Forward());
        myCommands.put(BACK, new Back());
        myCommands.put(LEFT, new Left());
        myCommands.put(RIGHT, new Right());
        myCommands.put(SETHEADING, new SetHeading());
        myCommands.put(TOWARDS, new Towards());
        myCommands.put(SETXY, new SetXY());
        myCommands.put(PENDOWN, new Forward());
        myCommands.put(PENUP, new PenUp());
        myCommands.put(SHOWTURTLE, new ShowTurtle());
        myCommands.put(HIDETURTLE, new HideTurtle());
        myCommands.put(CLEARSCREEN, new ClearScreen());
    }
    
    public ICommand getCommand(String command){
        return myCommands.get(command);
    }

    public void doCommand(int index , String commandName, double distanceOrAngle){
        ICommand command = getCommand(commandName);
        command.move(myModel.getTurtle(index), distanceOrAngle);
    }
    
    public void doCommand(int index , String commandName , double x , double y){
        ICommand command = getCommand(commandName);
        command.move(myModel.getTurtle(index), x,y);
    }









}
