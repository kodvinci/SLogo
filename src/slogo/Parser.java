package slogo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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
    private Pattern mySpacePattern;
    private ResourceBundle myResources;
    
    public Parser(){
        myNumPattern = Pattern.compile("[0-9]*");
        myStrPattern = Pattern.compile("[a-zA-Z]*");
        myListPattern = Pattern.compile("[\\[\\]]*");
        mySpacePattern = Pattern.compile("[\\s]+");
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "commands");
    }

    public ArrayList<String[]> split (String commands) {
        
        
        if(commands == null) {
            return null;
        }
        
        ArrayList<String[]> allCommands = new ArrayList<String[]>();
        ArrayList<StringBuffer> allBuffers = new ArrayList<StringBuffer>();

        for(int i = 0 ; i<commands.length() ; i++){
            if(commands.charAt(i) != ' '){
                commands = commands.substring(i);
                break;
            }
        }
        
        String[] cutBySpace = mySpacePattern.split(commands);
        if(cutBySpace.length == 0) return null;
        StringBuffer buffer = new StringBuffer();
        buffer.append(cutBySpace[0]);
        for (int i = 1; i < cutBySpace.length; i++) {
            if (myStrPattern.matcher(cutBySpace[i]).matches() ) {

                allBuffers.add(buffer);
                buffer = new StringBuffer();
                buffer.append(cutBySpace[i]);
            }
            else if(myNumPattern.matcher(cutBySpace[i]).matches()) {
                buffer.append(" ");
                buffer.append(cutBySpace[i]);
            }
        }
        allBuffers.add(buffer);

        for (int i = 0; i < allBuffers.size(); i++) {
            String[] str = mySpacePattern.split(allBuffers.get(i).toString());
            allCommands.add(str);
            str = null;
        }
        
        return allCommands;
    }
    
    public ICommand buildCommand(String[] str)throws NoSuchCommandException, SyntaxException{
        if( !myResources.containsKey(str[0])) throw new NoSuchCommandException();
        else{
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
            try {
                o=commandClass.newInstance();
            }
            catch (InstantiationException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ICommand myCommand = (ICommand) o;
            myCommand.initialize(subArray);
            return myCommand;
            
        }
    }
    
    public List<ICommand> buildMultipleCommands(List<String[]> commands) throws SyntaxException, NoSuchCommandException{
        if(commands == null) {
            return null; 
        }
        
        List<ICommand> myCommandList = new ArrayList<ICommand>();
         for(String[] str : commands){
             myCommandList.add(buildCommand(str));
         }
         return myCommandList;
    }
    
    public String[] subStringArray(String[] str){
        int size = str.length;
        String[] subArray = new String[size-1];
        for(int i =0 ; i< size - 1 ; i ++){
            subArray[i] = str[i+1];  
        }
       
        return subArray;
    }
    public int findRelatedBrackets(String str, int position) throws SyntaxException{
        if(str.charAt(position) != '[') throw new SyntaxException();
        else{
            int priority = 0;
            int i = position;
            for( i = position + 1 ; i< str.length() ; i++){
                if(priority == 0 && str.charAt(i) == ']') break;
                else if(str.charAt(i) == '[') priority ++;
                else if (str.charAt(i) == ']') priority --;
            }
            return i;
        }
    }
}
