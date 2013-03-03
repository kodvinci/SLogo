package utilities;

import java.util.ArrayList;
import java.util.List;
import object.Turtle;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */
public class Controller {

    private List<Model> myModels = new ArrayList<Model>();

    private Interpreter myInterpreter;

    public Controller () {
        addModel();
        myInterpreter = new Interpreter();
    }

    public void processUserInput (int seq, String string) {

        try {
            myInterpreter.process(myModels.get(seq), string);
        }
        catch (SyntaxException e) {
            // myModels.get(seq).showMessage("Syntax Error, please check your commands");
            System.out.println("Syntax Error");
        }
        // update view
        myModels.get(seq).update();
    }

    public void addModel () {
        myModels.add(new Model(this));
    }

    public void addModel (Model model) {
        myModels.add(model);
    }

    public void removeModel (int seq) {
        myModels.remove(seq);
    }

    public void removeModel (Model model) {
        myModels.remove(model);
    }

    public Model getModel (int seq) {
        return myModels.get(seq);
    }

    public List<Model> getMyModels () {
        return myModels;
    }

    public Interpreter getMyInter () {
        return myInterpreter;
    }

    public Turtle getMyTurtle () {
        return myModels.get(0).getMyTurtle();
    }
}
