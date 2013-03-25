package behavior;

import java.util.ArrayList;
import java.util.List;
import exceptions.ParameterException;
import slogo.Model;
import slogo.Parser;

public class Tell implements ICommand {
   
    public static final int PARAMETER_NUMBER = 1; 
    protected List<Integer> myActivatedTurtles;
    protected Parser myParser = new Parser();
    
    @Override
    public double move (Model model, int turtleNumber) throws Exception {
        model.clearFutureActivatedTurtles();
        int last = 0;
        for(int i: myActivatedTurtles) {
            model.addFutureActivatedTurtles(i);
            System.out.println("turtle activated:" + i);
            last = i;
        }
        return last;
    }

    @Override
    public void initialize (String[] information, Model model) throws Exception {
        if(information.length != PARAMETER_NUMBER) throw new ParameterException("Parameter doesn't match");
        myActivatedTurtles = new ArrayList<Integer>();
        String[] mySplitedContent = splitFirstBracket(prune(information[0]));
        for(String str:mySplitedContent) {
            if( !myParser.judgeNumeric(str))throw new ParameterException("Parameter doesn't match");
            myActivatedTurtles.add(Integer.parseInt(str));
        }
        System.out.println("activated turtle number :"+ myActivatedTurtles.size());
    }

    public String[] splitFirstBracket(String myFirstPrunedCommand) {
        String[] myContent= myParser.getSpacePattern().split(myFirstPrunedCommand);
        List<String> buffer = new ArrayList<String>();
        for(int i = 0 ; i<myContent.length ; i++) {
            if(!myParser.getSpacePattern().matcher(myContent[i]).matches() && !myContent[i].equals("")) {
                buffer.add(myContent[i]);
            }
        }
        String[] myNewContent = new String[buffer.size()];
        for(int i = 0 ; i<buffer.size() ; i++) {
            myNewContent[i] = buffer.get(i);
        }
        return myNewContent;
    }
    
    public String prune (String bracket) {
        return bracket.substring(1, bracket.length() - 1);
    }
}
