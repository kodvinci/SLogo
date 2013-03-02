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

    public Interpreter () {
        myCommands = new CommandEntities();
        myCommands.initialize();
    }

    // have to throw exception
    public ArrayList<String[]> split (String commands) {

        ArrayList<String[]> allCommands = new ArrayList<String[]>();
        ArrayList<StringBuffer> allBuffers = new ArrayList<StringBuffer>();
        Pattern myPattern = Pattern.compile("[a-zA-Z]*");

        String[] cutBySpace = commands.split(" ");

        StringBuffer buffer = new StringBuffer();
        buffer.append(cutBySpace[0]);
        for (int i = 1; i < cutBySpace.length; i++) {
            if (myPattern.matcher(cutBySpace[i]).matches()) {

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

        Pattern myPattern = Pattern.compile("[0-9]*");
        List<Double> bufferList = new ArrayList<Double>();

        for (String element : str) {
            if (myPattern.matcher(element).matches()) {
                bufferList.add(Double.parseDouble(element));
            }
        }
        int size = bufferList.size();
        
        double[] parameters = new double[size];
        for(int i = 0 ; i< size ; i++){
            parameters[i] = bufferList.get(i).doubleValue();
        }
        
        myCommands.doCommand(model, str[0], parameters);

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
            translateAndExecute(model, separatedCommands.get(i));
        }
    }

    public CommandEntities getMyCommands () {
        return myCommands;
    }

}
