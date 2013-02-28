package utilities;

import java.util.ArrayList;
import java.util.List;
import object.Turtle;


/**
 * 
 * @author Richard Yang
 * 
 */
public class Controller {

    private List<Model> myModels = new ArrayList<Model>();

    private Interpreter myInter;

    public Controller () {
        addModel();
        myInter = new Interpreter();
    }

    public void processUserInput (int seq, String string) {
        myInter.process(myModels.get(seq), string);

        // update view
        myModels.get(0).update();
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
        return myInter;
    }

    public Turtle getMyTurtle () {
        return myModels.get(0).getMyTurtle();
    }
}
