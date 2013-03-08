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
<<<<<<< HEAD
             myCommandList.addAll(myParser.buildMultipleCommands(myParser.split(command)));
        }else{
            String formerString = command.substring(0, position);
            if(formerString.length() != 0){
                myCommandList.addAll(myParser.buildMultipleCommands(myParser.split(formerString)));
            }
            int bracketPosition = command.indexOf("[");
            int end = myParser.findRelatedBrackets(command,bracketPosition);
            String postString = command.substring(end);
            String repeatString = command.substring(position, bracketPosition);
            List<String[]> repeatBuffer = myParser.split(repeatString);
            String recursionString = command.substring(bracketPosition+1,end-1);
            myCommandList.add(new Repeat(recursionString ,Integer.parseInt(repeatBuffer.get(0)[1])));
            if(postString.length() != 0){
                parse(postString, myCommandList);
            }
            //System.out.println(myCommandList.size());
        }
=======
             //addCommands(split(commands));
        }

>>>>>>> 5af8cb02d1363f6baf9dce7ee45157843b64f292
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
            
<<<<<<< HEAD
        List<ICommand> myCommandList = new ArrayList<ICommand>();
        parse(commands , myCommandList);
        System.out.println(myCommandList.size());
        for(ICommand ic : myCommandList){
            System.out.println(ic.getClass().toString());
            ic.move(model, turtleNumber);
        } 
=======
            else if (currentCommand[0].toUpperCase().equals("REPEAT")) {
                int repeatValue = 1;
                repeatCommand(model, currentCommand, separatedCommands, repeatValue);
                  
            }

            else {
                translateAndExecute(model, currentCommand);
            }

        }
>>>>>>> 5af8cb02d1363f6baf9dce7ee45157843b64f292
        
       
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
    
    public void translateAndExecute (Model model, String[] str) throws SyntaxException,
    NoSuchCommandException {

        List<Double> bufferList = new ArrayList<Double>();

        for (String element : str) {
            if (myNumPattern.matcher(element).matches()) {
                bufferList.add(Double.parseDouble(element));
            }
        }
        int size = bufferList.size();

        double[] parameters = new double[size];
        for (int i = 0; i < size; i++) {
            parameters[i] = bufferList.get(i).doubleValue();
        }

        myCommands.doCommand(model, str[0].toUpperCase(), parameters);

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
 
