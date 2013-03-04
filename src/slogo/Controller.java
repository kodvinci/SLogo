package slogo;

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

    /**
     * Initialize a model view controller
     */
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

    /**
     * Process user input
     * 
     * @param seq sequence
     * @param string string
     */
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

    /**
     * Add a model
     */
    public void addModel () {
        myModels.add(new Model(this));
    }

    /**
     * Add a specific model
     * 
     * @param model the model to add
     */
    public void addModel (Model model) {
        myModels.add(model);
    }

    /**
     * remove model at a index
     * 
     * @param seq the index
     */
    public void removeModel (int seq) {
        myModels.remove(seq);
    }

    /**
     * Remove a specific model
     * 
     * @param model the model to remove
     */
    public void removeModel (Model model) {
        myModels.remove(model);
    }

    /**
     * Return a model at an inex
     * 
     * @param seq the index
     * @return the model
     */
    public Model getModel (int seq) {
        return myModels.get(seq);
    }

    /**
     * Return the list of models
     * 
     * @return list of models
     */
    public List<Model> getMyModels () {
        return myModels;
    }

    /**
     * Return interpreter
     * 
     * @return
     */
    public Interpreter getMyInter () {
        return myInterpreter;
    }

    /**
     * return turtle
     * 
     * @return
     */
    public Turtle getMyTurtle () {
        return myModels.get(0).getMyTurtle();
    }

    public List<Turtle> getMyTurtles () {
        return myModels.get(0).getMyTurtles();
    }
}
