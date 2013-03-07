package behavior;

import java.util.ArrayList;
import java.util.List;
import object.Turtle;
import slogo.Parser;
import exceptions.SyntaxException;

public class Repeat implements ICommand {

    List<ICommand> myCommands = new ArrayList<ICommand>();
    Parser myParser = new Parser();
    
    public Repeat(String[] subCommands){
        int length = subCommands.length;
        for(int i =0 ; i<length ; i++){
            
        }
        
    }
    
    
    @Override
    public double move (Turtle turtle, String[] subCommands) throws SyntaxException {
        // TODO Auto-generated method stub
        return 0;
    }

}
