package slogo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import behavior.CommandEntities;
import behavior.ICommand;
import behavior.Repeat;
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
    private Parser myParser;
    
    /**
     * Constructs an interpreter
     */
    public Interpreter () {
        myNumPattern = Pattern.compile("[0-9]*");
        myStrPattern = Pattern.compile("[a-zA-Z]*");
        myListPattern = Pattern.compile("[\\[\\]]*");
        myCommands = new CommandEntities("commands");
        myParser = new Parser();
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
    public void parse ( String command, List<ICommand> myCommandList) throws SyntaxException, NoSuchCommandException {
        
        int position = command.indexOf("REPEAT");
        if( position == -1 ){
             myCommandList.addAll(myParser.buildMultipleCommands(myParser.split(command)));
        }else{
            String formerString = command.substring(0, position);
            if(formerString.length() != 0){
                myCommandList.addAll(myParser.buildMultipleCommands(myParser.split(formerString)));
            }
            int bracketPosition = command.indexOf("[");
            int end = myParser.findRelatedBrackets(command,bracketPosition);
            
            String postString = null;
            
            if(end != command.length()){
                postString = command.substring(end+1);
            }
            
            String repeatString = command.substring(position, bracketPosition);
            
            List<String[]> repeatBuffer = myParser.split(repeatString);
            String recursionString = command.substring(bracketPosition+1,end-1);
            System.out.println("recursionString : " + recursionString);
            myCommandList.add(new Repeat(recursionString ,Integer.parseInt(repeatBuffer.get(0)[1])));
            if(postString != null){
                parse(postString, myCommandList);
            }
            //System.out.println(myCommandList.size());
        }

    }

    /**
     * this method can finish the process of input commands.
     * 
     * @param model the model
     * @param commands input of user
     * @throws SyntaxException Syntax exception
     * @throws NoSuchCommandException
     */
    public void process (Model model, int turtleNumber , String commands) throws SyntaxException,
                                                      NoSuchCommandException {
            

        List<ICommand> myCommandList = new ArrayList<ICommand>();
        parse(commands , myCommandList);
        System.out.println(myCommandList.size());
        for(ICommand ic : myCommandList){
            System.out.println("list size :" + myCommandList.size());
            ic.move(model, turtleNumber);
        } 

    }
    
    
    
}
 
