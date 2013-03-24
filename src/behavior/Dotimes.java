package behavior;

import java.util.ArrayList;
import java.util.List;
import exceptions.NoSuchVariableException;
import exceptions.ParameterException;
import exceptions.SyntaxException;
import slogo.Model;
import slogo.Parser;



public class Dotimes extends Repeat {
    
    public static final int PARAMETER_NUMBER = 2;
  
    protected Parser myParser = new Parser();
    protected String myVariable;
    protected double myVariableValue;
    protected int myEndValue;
    protected List<ICommand> myBracketCommandsList;

    @Override
    public double move(Model model, int turtleNumber) throws Exception{
   
         for(ICommand c : myBracketCommandsList) {
             c.move(model, turtleNumber);
         }
        return 0;
    } 
    
    public void construct(String firstBracket, String secondBracket, Model model,int initialValue,int step) throws Exception{
        myBracketCommandsList =  new ArrayList<ICommand>();
        String myFirstPrunedCommand = prune(firstBracket);
        String mySecondPrunedCommand = prune(secondBracket);
        System.out.println(myFirstPrunedCommand);
        System.out.println(mySecondPrunedCommand);
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
        if(myNewContent.length != 2) throw new SyntaxException("wrong syntax");
        else if (myNewContent[0].length()<2 ) throw new NoSuchVariableException("cannot find a variable");
        else if (!myParser.judgeNumeric(myNewContent[1])) throw new ParameterException("parameter Exception");
        myVariable = myNewContent[0];
        model.addVariable(myVariable, myVariableValue+"");
        myEndValue = Integer.parseInt(myNewContent[1]); 
        
        for(int i = initialValue ; i< myEndValue+1 ; i += step) {
            Double tmp = new Double(i);
            model.setVariableValue(myVariable, tmp);
            myBracketCommandsList.addAll(myParser.buildMultipleCommands(myParser.split(mySecondPrunedCommand, model),model));    
        }
        System.out.println(myBracketCommandsList.size());
        
    }
    
    @Override
    public void initialize (String[] information, Model model) throws Exception {
        if(information.length != PARAMETER_NUMBER) throw new ParameterException("parameter not match");
        System.out.println("DOTimes Initialization Successful");
        System.out.println(information[0]);
        System.out.println(information[1]);
        construct(information[0], information[1], model,0,1);
    }
    
    
}
