package utilities;

import java.util.ArrayList;
import java.util.regex.Pattern;
import behavior.CommandEntities;

public class Interpreter {
     
    private CommandEntities myCommands;    
    
    public Interpreter(){
        myCommands.initialize();
    }
    
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
 
}
