package behavior;

import java.util.ArrayList;
import java.util.List;
import exceptions.ParameterException;
import slogo.Model;
import slogo.Parser;

public class Ask implements ICommand {

    public static final int PARAMETER_NUMBER = 2;
    
    private List<Integer> myActivatedTurtles;
    private Parser myParser = new Parser();
    private List<ICommand> myCommands;
    
    @Override
    public double move (Model model, int turtleNumber) throws Exception {
        model.clearFutureActivatedTurtles();
        model.activatedAllTurtles();
        model.replaceActivatedTurtles();
        int last = 0;
        for(int i: myActivatedTurtles) {
            model.addFutureActivatedTurtles(i);
            for(ICommand ic : myCommands) {
                ic.move(model, i);
            }
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
        String myPrunedStringCommand = prune(information[1]);
        myCommands = createCommandsList(myPrunedStringCommand, model);
    
    }
    
    public List<ICommand> createCommandsList (String commands, Model model) throws Exception {
        List<String[]> myListOfCommands = myParser.split(commands, model);
        return myParser.buildMultipleCommands(myListOfCommands, model);
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
