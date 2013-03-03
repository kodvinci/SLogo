package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import exceptions.SyntaxException;
import behavior.CommandEntities;


/**
 * 
 * @author Richard Yang
 * 
 */
public class Interpreter {

    private CommandEntities myCommands;
    Pattern numPattern;
    Pattern strPattern;

    public Interpreter () {
        numPattern = Pattern.compile("[0-9]*");
        strPattern = Pattern.compile("[a-zA-Z]*");
        myCommands = new CommandEntities();
        myCommands.initialize();
    }

    // have to throw exception
    public ArrayList<String[]> split (String commands) {

        ArrayList<String[]> allCommands = new ArrayList<String[]>();
        ArrayList<StringBuffer> allBuffers = new ArrayList<StringBuffer>();

        String[] cutBySpace = commands.split(" ");

        StringBuffer buffer = new StringBuffer();
        buffer.append(cutBySpace[0]);
        for (int i = 1; i < cutBySpace.length; i++) {
            if (strPattern.matcher(cutBySpace[i]).matches()) {

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

    // have to throw exception
    public void translateAndExecute (Model model, String[] str) throws SyntaxException{

        
        List<Double> bufferList = new ArrayList<Double>();

        for (String element : str) {
            if (numPattern.matcher(element).matches()) {
                bufferList.add(Double.parseDouble(element));
            }
        }
        int size = bufferList.size();
        
        double[] parameters = new double[size];
        for(int i = 0 ; i< size ; i++){
            parameters[i] = bufferList.get(i).doubleValue();
        }
        
        myCommands.doCommand(model, str[0].toUpperCase(), parameters);

    }

    /**
     * this method can finish the process of input commands.
     * 
     * @param ind the index of turtle we want to process
     * @param commands input of user
     */
    public void process (Model model, String commands) throws SyntaxException {
        
        ArrayList<String[]> separatedCommands = split(commands);

        for (int i = 0; i < separatedCommands.size(); i++) {
            String[] currentCommand = separatedCommands.get(i);
            if(currentCommand[0].toUpperCase() .equals("MAKE")){
                makeVariable(model , currentCommand);
            }else{
                translateAndExecute(model, currentCommand);
            }
            
        }
    }

    public void makeVariable(Model model, String[] currentCommand) throws SyntaxException{
     
        if(currentCommand.length < 3) throw new SyntaxException();
        String name = currentCommand[1];
        String value = currentCommand[2];
        if( !(strPattern.matcher(name).matches() && numPattern.matcher(value).matches()) ){
            throw new SyntaxException() ;
        }else{
            model.addVariable(name, Double.parseDouble(value));
        }
    }
   
}
