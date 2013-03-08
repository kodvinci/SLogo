package behavior;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

    public Repeat (String subCommands, int time) throws SyntaxException, NoSuchCommandException {

        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");

        myRunTime = time;
        int position = subCommands.indexOf(this.getClass().toString());
        if (position == -1) {
            addCommands(myParser.split(subCommands));
        }
        else {
            String formerString = subCommands.substring(0, position);
            String postString = subCommands.substring(position);
            addCommands(myParser.split(formerString));
            int bracketPosition = subCommands.indexOf("[");
            int end = findRelatedBrackets(subCommands, bracketPosition);
            String repeatString = subCommands.substring(position, bracketPosition);
            List<String[]> repeatBuffer = myParser.split(repeatString);
            String recursionString = subCommands.substring(bracketPosition, end);
            myCommands.add(new Repeat(recursionString, Integer.parseInt(repeatBuffer.get(0)[0])));
            addCommands(myParser.split(postString));

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

}
