package slogo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import behavior.CommandEntities;
import behavior.ICommand;
import exceptions.NoSuchCommandException;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */
public class Interpreter {

    private CommandEntities myCommands;

    private Pattern myNumPattern;
    private Pattern myStrPattern;
    private Pattern myListPattern;

    /**
     * Constructs an interpreter
     */
    public Interpreter () {
        myNumPattern = Pattern.compile("[0-9]*");
        myStrPattern = Pattern.compile("[a-zA-Z]*");
        myListPattern = Pattern.compile("[\\[\\]]*");
        myCommands = new CommandEntities("commands");
    }

    /**
     * Returns an arraylist of the user input
     * 
     * @param commands user input
     * @return
     */
    // have to throw exception
    public ArrayList<String[]> split (String commands) {

        ArrayList<String[]> allCommands = new ArrayList<String[]>();
        ArrayList<StringBuffer> allBuffers = new ArrayList<StringBuffer>();

        String[] cutBySpace = commands.split(" ");

        StringBuffer buffer = new StringBuffer();
        buffer.append(cutBySpace[0]);
        for (int i = 1; i < cutBySpace.length; i++) {
            if (myStrPattern.matcher(cutBySpace[i]).matches() ||
                myListPattern.matcher(cutBySpace[i]).matches()) {

                allBuffers.add(buffer);
                buffer = new StringBuffer();
                buffer.append(cutBySpace[i]);
            }
            else {
                buffer.append(" ");
                buffer.append(cutBySpace[i]);
            }
        }
        allBuffers.add(buffer);

        for (int i = 0; i < allBuffers.size(); i++) {
            String[] str = allBuffers.get(i).toString().split(" ");
            allCommands.add(str);
            str = null;
        }

        return allCommands;
    }

    /**
     * Translates arraylist input and executes command
     * 
     * @param model the model
     * @param str arraylist command
     * @throws SyntaxException syntax exception
     * @throws NoSuchCommandException
     */
    // have to throw exception
    public void parse (Model model, int turtleNumner, String command) throws SyntaxException {

        List<ICommand> myCommandList = new ArrayList<ICommand>();
        
        int position = command.indexOf(this.getClass().toString());
        if( position == -1 ){
             addCommands(split(commands));
        

    }

    /**
     * this method can finish the process of input commands.
     * 
     * @param model the model
     * @param commands input of user
     * @throws SyntaxException Syntax exception
     * @throws NoSuchCommandException
     */
    public void process (Model model, String commands) throws SyntaxException,
                                                      NoSuchCommandException {

        ArrayList<String[]> separatedCommands = split(commands);
   
        for (int i = 0; i < separatedCommands.size(); i++) {
            for (int j = 0; j < separatedCommands.get(i).length; j++) {
                //System.out.println(separatedCommands.get(i)[j]);
            }
        }
        
        
        for (int i = 0; i < separatedCommands.size(); i++) {
            String[] currentCommand = separatedCommands.get(i);

            // to make a variable
            if (currentCommand[0].toUpperCase().equals("MAKE")) {
                i++;
                currentCommand = separatedCommands.get(i);
                makeVariable(model, currentCommand);
            }
            
            else if (currentCommand[0].toUpperCase().equals("REPEAT")) {
                int repeatValue = 1;
                repeatCommand(model, currentCommand, separatedCommands, repeatValue);
                  
            }

            else {
                translateAndExecute(model, currentCommand);
            }

        }
        
       
    }
    
    public void repeatCommand(Model model, String[] currentCommand, ArrayList<String[]> separatedCommands, int repeatValue) throws SyntaxException, NoSuchCommandException {
        currentCommand = separatedCommands.get(0);
        ArrayList<String[]> newSeparatedCommands = new ArrayList<String[]>();
        for (int i = 1; i < separatedCommands.size(); i++) {
            newSeparatedCommands.add(separatedCommands.get(i));
        }
//        if (repeatValue == 0) {
//           return;
//        }
//        else {
            if (currentCommand[0].equals("REPEAT")){
                int nestedRepeat = Integer.parseInt(currentCommand[1]);
                int value = nestedRepeat * repeatValue;
                currentCommand = separatedCommands.get(1);
                repeatCommand(model, currentCommand, newSeparatedCommands, value);
            }
            else {
                for (int i = 0; i < repeatValue-1; i++) {
                    translateAndExecute(model, currentCommand);
                }
            }
            
        
        
    }

    /**
     * Makes a variable from user input
     * 
     * @param model the slogo model
     * @param currentCommand current command
     * @throws SyntaxException syntax exception
     */
    public void makeVariable (Model model, String[] currentCommand) throws SyntaxException {

        if (currentCommand.length < 2) { throw new SyntaxException(); }
        String name = currentCommand[0];
        String value = currentCommand[1];
        if (!(myStrPattern.matcher(name).matches() && myNumPattern.matcher(value).matches())) {
            throw new SyntaxException();
        }
        else {
            model.addVariable(name, Double.parseDouble(value));
        }
    }
    
}
 
