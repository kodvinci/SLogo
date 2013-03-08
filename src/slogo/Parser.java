package slogo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import behavior.ICommand;
import exceptions.NoSuchCommandException;
import exceptions.SyntaxException;


public class Parser {

    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";

    private Pattern myNumPattern;
    private Pattern myStrPattern;
    private Pattern myListPattern;
    private ResourceBundle myResources;

    public Parser () {
        myNumPattern = Pattern.compile("[0-9]*");
        myStrPattern = Pattern.compile("[a-zA-Z]*");
        myListPattern = Pattern.compile("[\\[\\]]*");
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");
    }

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
            else if (myNumPattern.matcher(cutBySpace[i]).matches()) {
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

    public ICommand buildCommand (String[] str) throws NoSuchCommandException, SyntaxException {
        if (!myResources.containsKey(str[0]))
            throw new NoSuchCommandException();
        else {
            String[] subArray = subStringArray(str);
            String commandName = myResources.getString(str[0]);
            Class<?> commandClass = null;
            try {
                commandClass = Class.forName("behavior." + commandName);
            }
            catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Object o = null;
            ICommand myCommand = (ICommand) o;
            Constructor<?>[] cons = commandClass.getConstructors();
            try {
                myCommand = (ICommand) cons[0].newInstance(subArray);
            }
            catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return myCommand;
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
}
