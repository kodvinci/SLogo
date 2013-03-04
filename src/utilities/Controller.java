package utilities;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import object.Turtle;
import view.Canvas;
import view.DisplayArea;
import view.TurtleArea;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */
public class Controller {

    public static final Dimension TURTLE_AREA_SIZE = new Dimension(800, 500);
    public static final Dimension DISPLAY_AREA_SIZE = new Dimension(200, 500);
    private Turtle myTurtle;

    private DisplayArea myDisplayArea;
    private TurtleArea myTurArea;
    private List<Model> myModels = new ArrayList<Model>();

    private Interpreter myInterpreter;
    private Canvas myView;

    public Controller () {
        addModel();
        myInterpreter = new Interpreter();
        myView = new Canvas(this);
    }

    public void update () {
        // myDisplayArea.update();
        // myTurArea.update();
        myView.update();
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
        update();
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
