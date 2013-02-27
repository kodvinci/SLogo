package utilities;

import java.util.ArrayList;
import java.util.regex.Pattern;
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
        // for(int i =0 ; i<allCommands.size() ; i++){
        // String[] str = allCommands.get(i);
        // for(int j =0 ; j<str.length ; j++){
        // System.out.print(str[j]);
        // System.out.print(" ");
        // }
        // System.out.print("\n");
        // }

        return allCommands;
    }

    // have to throw exception
    public void translateAndExecute (Model model , String[] str) {

        // for(int j =0 ; j<str.length ; j++){
        // System.out.print(str[j]);
        // System.out.print(" ");
        // System.out.print("\n");
        // }

        Pattern myPattern = Pattern.compile("[0-9]*");
        int parameterCount = 0;

        for (String element : str) {
            if (myPattern.matcher(element).matches()) {
                parameterCount++;
            }

            if (parameterCount == 0) {
                myCommands.doCommand(model , str[0].toUpperCase());
            }
            if (parameterCount == 1) {
                double parameter = Double.parseDouble(str[1]);
                myCommands.doCommand(model , str[0].toUpperCase(), parameter);
            }
            if (parameterCount == 2) {
                double paraX = Double.parseDouble(str[1]);
                double paraY = Double.parseDouble(str[2]);
                myCommands.doCommand(model , str[0].toUpperCase(), paraX, paraY);
            }
            if (parameterCount > 2) {
                // throw exception
            }
        }
    }

    /**
     * this method can finish the process of input commands.
     * 
     * @param ind the index of turtle we want to process
     * @param commands input of user
     */
    public void process (Model model , String commands) {

        ArrayList<String[]> separatedCommands = split(commands);

        for (int i = 0; i < separatedCommands.size(); i++) {
            // System.out.print(separatedCommands.size());
            translateAndExecute(model , separatedCommands.get(i));

        }
    }

    public CommandEntities getMyCommands () {
        return myCommands;
    }

}
