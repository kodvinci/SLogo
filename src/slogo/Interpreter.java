package slogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import behavior.CommandEntities;
import behavior.ICommand;
import behavior.Repeat;
import exceptions.NoSuchCommandException;
import exceptions.SyntaxException;
import behavior.To;
import java.util.Map;
import java.util.HashMap;

/**
 * 
 * @author Richard Yang
 * 
 */
public class Interpreter {

    private CommandEntities myCommands;

    private Pattern myNumPattern;
    private Pattern myStrPattern;
    private Parser myParser;
    
    private Map<String, ICommand> myUserToCommands = new HashMap<String, ICommand>();
    
    /**
     * Constructs an interpreter
     */
    public Interpreter () {
        myNumPattern = Pattern.compile("[0-9]*");
        myStrPattern = Pattern.compile("[a-zA-Z]*");
        myParser = new Parser();
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
        
        myParser.parseOneBracket(command, myCommandList);

    }
//
//             //addCommands(split(commands));
//
//    
// public int parseTo (String command, List<ICommand> myCommandList) throws SyntaxException, NoSuchCommandException {
//        
//        int position = command.indexOf("TO");
//        if( position == -1 ){
//             myCommandList.addAll(myParser.buildMultipleCommands(myParser.split(command)));
//        }
//        else{
//            String formerString = command.substring(0, position);
//            if(formerString.length() != 0){
//                myCommandList.addAll(myParser.buildMultipleCommands(myParser.split(formerString)));
//            }
//            int bracketPosition = command.indexOf("[");
//            String commandName = command.substring(position + 3, bracketPosition);
//            String post = command.substring(bracketPosition+1, command.length());
//            String variable = post.substring(0, post.indexOf("]"));
//            String commandsBracket = post.substring(post.indexOf("[")+1, post.length()-1);
//            System.out.println(commandName);
//            System.out.println(variable);
//            System.out.println(commandsBracket);
//            List<String[]> variables = split(variable);
//            List<String[]> commandsFromBracket = split(commandsBracket);
//            System.out.println(Arrays.toString(commandsFromBracket.get(0)) + " " + Arrays.toString(commandsFromBracket.get(1)));
//            myCommandList.add(new To(commandName, variables, commandsFromBracket));
//            myUserToCommands.put(commandName, new To(commandName, variables, commandsFromBracket));
//            
//              if (variables.get(0).length == commandsFromBracket.size()) {
//                  return 1;
//              }
//              else {
//                  return 0;
//              }
//        }
//
//        return 0;
//     }
//
// public int ifElse (String command, List<ICommand> myCommandList) throws SyntaxException, NoSuchCommandException {
//         int position = command.indexOf("IFELSE");
//         if (position == -1) {
//             myCommandList.addAll(myParser.buildMultipleCommands(myParser.split(command)));
//         }
//         else {
//             String formerString = command.substring(0, position);
//             if(formerString.length() != 0){
//                 myCommandList.addAll(myParser.buildMultipleCommands(myParser.split(formerString)));
//             }
//             int bracketPosition = command.indexOf("[");
//             String value = command.substring(position + 3, bracketPosition);
//             String post = command.substring(bracketPosition+1, command.length());
//             String trueCommand = post.substring(0, post.indexOf("]"));
//             String falseCommand = post.substring(post.indexOf("[")+1, post.length()-1);
//             System.out.println(value);
//             System.out.println(trueCommand);
//             System.out.println(falseCommand);
//             List<String[]> trueCommands = split(trueCommand);
//             List<String[]> falseCommands = split(falseCommand);
//             System.out.println(Arrays.toString(trueCommands.get(0)) + " " + Arrays.toString(trueCommands.get(1)));
//             myCommandList.add(new IfElse(commandName, variables, commandsFromBracket, value));
//             myUserToCommands.put(commandName, new To(commandName, variables, commandsFromBracket, value));
//             
//               if (variables.get(0).length == commandsFromBracket.size()) {
//                   return 1;
//               }
//               else {
//                   return 0;
//               }
//         }
// }
    

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
        parse(commands,myCommandList);
        //parseTo(commands , myCommandList);
        System.out.println(myCommandList.size());
        for(ICommand ic : myCommandList){

            System.out.println(myUserToCommands.size());

            System.out.println("list size :" + myCommandList.size());
            ic.move(model, turtleNumber);
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
 
