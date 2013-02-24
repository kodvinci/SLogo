package utilities;

import java.util.ArrayList;
import java.util.regex.Pattern;
import behavior.CommandEntities;

public class Interpreter {
     
    private CommandEntities myCommands;    
   
    
    public Interpreter(Model model){
        myCommands = new CommandEntities(model);
        myCommands.initialize();
        
    }
    //have to throw exception
    public ArrayList<String[]> split (String commands){
        ArrayList<String[]>   allCommands = new ArrayList<String[]>();
        ArrayList<StringBuffer> allBuffers = new ArrayList<StringBuffer>();
        Pattern myPattern = Pattern.compile("[a-zA-Z]*");
        
        String[] cutBySpace =  commands.split(" ");
        
        StringBuffer buffer = new StringBuffer();
        buffer.append(cutBySpace[0]);
        for(int i =1 ; i<cutBySpace.length ; i++ ){
            if(myPattern.matcher(cutBySpace[i]).matches()){
                allBuffers.add(buffer);
                buffer = new StringBuffer();
                buffer.append(cutBySpace[i]);
            }else{
                buffer.append(" ");
                buffer.append(cutBySpace[i]);
            }
        }
        
        for(int i =0 ; i<allBuffers.size() ; i++){
            String[] str = allBuffers.get(i).toString().split(" ");
            allCommands.add(str);
            str = null;
        }
        return allCommands;
    }
  //have to throw exception
    public void translateAndExecute (String[] str){
       
        Pattern myPattern = Pattern.compile("[0-9]*");
        int parameterCount = 0;
        
        for(int i =0 ; i< str.length ; i++){
            if(myPattern.matcher(str[i]).matches()){
                parameterCount ++ ;
            }
        }
        
        if(parameterCount == 0){
            myCommands.doCommand(str[0]);
        }
        if(parameterCount == 1){
            double parameter = Double.parseDouble(str[1]);
            myCommands.doCommand( str[0], parameter );
        }
        if(parameterCount == 2){
            double paraX = Double.parseDouble(str[1]);
            double paraY = Double.parseDouble(str[2]);
            myCommands.doCommand(str[0], paraX, paraY);
        }
        if(parameterCount > 2){
            // throw exception            
        }
    }
    /**
     * this method can finish the process of input commands.
     * 
     * @param ind the index of turtle we want to process
     * @param commands input of user
     */
    public void process( String commands){
        ArrayList<String[]> separatedCommands = split(commands);
        for(int i = 0 ; i< separatedCommands.size() ; i++){
            translateAndExecute( separatedCommands.get(i));
        }
    }
    
    
 
}
