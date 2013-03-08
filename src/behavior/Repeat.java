package behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import slogo.Model;
import slogo.Parser;
import exceptions.NoSuchCommandException;
import exceptions.SyntaxException;

public class Repeat implements ICommand {

    private List<ICommand> myCommands = new ArrayList<ICommand>();
    private Parser myParser = new Parser();
    private int myRunTime;
    private ResourceBundle myResources;
    
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    
    
    public Repeat(String subCommands, int time) throws NoSuchCommandException, SyntaxException{
        
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");
       
        myRunTime = time ;
        int position = subCommands.indexOf("REPEAT");
        if( position == -1 ){
             List<String[]> splitedCommands = myParser.split(subCommands);
             myCommands.addAll(myParser.buildMultipleCommands(splitedCommands));
        }else {
            String formerString = subCommands.substring(0, position);
            if(formerString.length() != 0){
               myParser.buildMultipleCommands(myParser.split(formerString));
            }
            int bracketPosition = subCommands.indexOf("[");
            int end = myParser.findRelatedBrackets(subCommands,bracketPosition);
            String postString = null;
            if(end != subCommands.length()){
                postString = subCommands.substring(end + 1);    
            }
            
            String repeatString = subCommands.substring(position, bracketPosition);
            List<String[]> repeatBuffer = myParser.split(repeatString);
            String recursionString = subCommands.substring(bracketPosition +1,end-1);
            System.out.println("formerString : " + formerString);
            System.out.println("recursionString : " + recursionString);
            System.out.println("postString : " + postString);
            myCommands.add(new Repeat(recursionString ,Integer.parseInt(repeatBuffer.get(0)[1])));
            if(postString != null){
                addCommands(myParser.split(postString));    
            }
            System.out.println("here");
            
        }
        
        
    }
    
    
    public void addCommands(List<String[]> commands) throws SyntaxException, NoSuchCommandException{
        for(String[] str : commands){
            if( !myResources.containsKey(str[0])) {
                System.out.print(str[0]);
                throw new SyntaxException();
            }
            else{
                myCommands.add( myParser.buildCommand(str));
            
            }
        }
    }
    
  
    
    
    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        double returnValue = 0;
        int time = myRunTime;
        while (time != 0){
            for(ICommand command : myCommands){
                returnValue = command.move(model, turtleNumber);
            }
            time -- ;
        }
        return returnValue;
    }



    @Override
    public void initialize (String[] information) throws SyntaxException {
        // TODO Auto-generated method stub
        
    }

}
