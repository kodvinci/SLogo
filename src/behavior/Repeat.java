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
<<<<<<< HEAD

    public Repeat (String subCommands, int time) throws SyntaxException, NoSuchCommandException {

=======
    
    
    public Repeat(String subCommands, int time) throws NoSuchCommandException, SyntaxException{
        
>>>>>>> b2a081ede9a10bb2459cfc1c755da2c5104500ea
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");

        myRunTime = time;
        int position = subCommands.indexOf(this.getClass().toString());
<<<<<<< HEAD
        if (position == -1) {
            addCommands(myParser.split(subCommands));
        }
        else {
=======
        if( position == -1 ){
             System.out.println(subCommands);
             List<String[]> splitedCommands = myParser.split(subCommands);
             System.out.println(splitedCommands.size());
             System.out.println(splitedCommands.get(0)[0]);
             System.out.println(splitedCommands.get(0)[1]);
             myCommands.addAll(myParser.buildMultipleCommands(splitedCommands));
        }else{
>>>>>>> b2a081ede9a10bb2459cfc1c755da2c5104500ea
            String formerString = subCommands.substring(0, position);
            String postString = subCommands.substring(position);
            if(formerString.length() != 0){
                myParser.buildMultipleCommands(myParser.split(formerString));
            }
            int bracketPosition = subCommands.indexOf("[");
<<<<<<< HEAD
            int end = findRelatedBrackets(subCommands, bracketPosition);
            String repeatString = subCommands.substring(position, bracketPosition);
            List<String[]> repeatBuffer = myParser.split(repeatString);
            String recursionString = subCommands.substring(bracketPosition, end);
            myCommands.add(new Repeat(recursionString, Integer.parseInt(repeatBuffer.get(0)[0])));
            addCommands(myParser.split(postString));

=======
            int end = findRelatedBrackets(subCommands,bracketPosition);
            
            String repeatString = subCommands.substring(position, bracketPosition);
            List<String[]> repeatBuffer = myParser.split(repeatString);
            String recursionString = subCommands.substring(bracketPosition +1,end);
            myCommands.add(new Repeat(recursionString ,Integer.parseInt(repeatBuffer.get(0)[1])));
            if(postString.length() != 0){
                addCommands(myParser.split(postString));    
            }
            System.out.println("here");
            
>>>>>>> b2a081ede9a10bb2459cfc1c755da2c5104500ea
        }

    }

    public int findRelatedBrackets (String str, int position) throws SyntaxException {
        if (str.charAt(position) != '[')
            throw new SyntaxException();
        else {
            int priority = 0;
            int i = position;
            for (i = position + 1; i < str.length(); i++) {
                if (priority == 1 && str.charAt(i) == ']')
                    break;
                else if (str.charAt(i) == '[')
                    priority++;
                else if (str.charAt(i) == ']') priority--;
            }
            return i;
        }
    }
<<<<<<< HEAD

    public void addCommands (List<String[]> commands) throws SyntaxException, NoSuchCommandException {
        for (String[] str : commands) {
            if (myResources.containsKey(str[0]))
                throw new SyntaxException();
            else {
                myCommands.add(myParser.buildCommand(str));
            }
        }
    }

    public String[] subStringArray (String[] str) {
        int size = str.length;
        String[] subArray = new String[size - 1];
        for (int i = 0; i < size - 1; i++) {
            subArray[i] = str[i + 1];
        }

        return subArray;
    }

=======
    
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
    
  
    
    
>>>>>>> b2a081ede9a10bb2459cfc1c755da2c5104500ea
    @Override
    public double move (Model model, int turtleNumber) throws SyntaxException {
        double returnValue = 0;
        while (myRunTime != 0) {
            for (ICommand command : myCommands) {
                returnValue = command.move(model, turtleNumber);
            }
        }
        return returnValue;
    }



    @Override
    public void initialize (String[] information) throws SyntaxException {
        // TODO Auto-generated method stub
        
    }

}
