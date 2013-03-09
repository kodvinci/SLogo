package behavior.flow;

import java.util.ArrayList;
import java.util.List;
import slogo.Model;
import slogo.Parser;
import exceptions.NoSuchCommandException;
import exceptions.NoSuchVariableException;
import exceptions.SyntaxException;
import behavior.ICommand;

public class If implements ICommand {

    private List<ICommand> myCommands = new ArrayList<ICommand>();
    private Parser myParser = new Parser();
    private int myStatement;
    
    
    public If(String subCommands, int statement, Model model) throws NoSuchCommandException, SyntaxException, NumberFormatException, NoSuchVariableException{
        
        myStatement = statement ;
        myParser.parseOneBracket(subCommands, myCommands,model);
        
        
    }
    
    
    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        if(myStatement != 0){
            for(ICommand command : myCommands){
                 command.move(model, turtleNumber);
            }
        }
        return myStatement;
    }

    @Override
    public void initialize (String[] information, Model model) throws SyntaxException {

    }

}
