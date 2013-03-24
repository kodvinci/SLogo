package slogo;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import object.Turtle;
import util.Location;
import view.Canvas;


/**
 * 
 * @author Richard Yang & Jerry Li
 * 
 */
public class Controller {

    /**
     * Default Turtle area size
     */
    public static final Dimension TURTLE_AREA_SIZE = new Dimension(800, 500);
    /**
     * Default Display area size
     */
    public static final Dimension DISPLAY_AREA_SIZE = new Dimension(200, 500);

    private Map<Integer, Model> myModels = new HashMap<Integer, Model>();

    private Interpreter myInterpreter;
    private Factory myFactory;
    private Canvas myView;

    /**
     * Initialize a model view controller
     */
    public Controller () {

        myFactory = new Factory(this);
        addModel();
        myInterpreter = new Interpreter();
        for (int i = 0; i < myModels.size(); i++) {
            myFactory.createTurtle(i);
        }
        myView = new Canvas(this);
    }

    /**
     * Return factory
     * 
     * @return
     */
    public Factory getFactory () {
        return myFactory;
    }

    /**
     * Update display areas
     */
    public void update () {
        myView.update();
    }

    /**
     * Process user input
     * 
     * @param seq sequence
     * @param string string
     * 
     */
    public void processUserInput (String string) {

        Map<Integer, Turtle> myTurtles = myModels.get(myModels.size()-1).getMyTurtles();
        
        for (Model m : myModels.values()) {
           for(int i : m.getMyCurrentActivatedTurtles()) {
               try {
                  myInterpreter.process(m, i , string);
               }
               catch (Exception e) {
//                   if(e.getMessage() != null) {
//                       myModels.get(modelIndex).showMessage(e.getMessage());
//                   } else {
//                       myModels.get(modelIndex).showMessage(e.getClass().toString());
//                   }
                   e.printStackTrace();
               }
               m.replaceActivatedTurtles();
           }
            
        }
        
        for (Turtle t : myTurtles.values()) {
            checkBounds(t);
        }
        // update view
        update();
    }

    /**
     * Checks bounds
     * 
     * @param t the turtle
     */
    public static void checkBounds (Turtle t) {
        double x = t.getX();
        double y = t.getY();
        double xMargin = Turtle.DEFAULT_SIZE.getWidth() / 2;
        double yMargin = Turtle.DEFAULT_SIZE.getHeight() / 2;
        if (x > TURTLE_AREA_SIZE.getWidth() - xMargin) {
            x = TURTLE_AREA_SIZE.getWidth() - xMargin;
        }
        if (y > TURTLE_AREA_SIZE.getHeight() - yMargin) {
            y = TURTLE_AREA_SIZE.getHeight() - yMargin;
        }
        if (x < xMargin) {
            x = xMargin;
        }
        if (y < yMargin) {
            y = yMargin;
        }
        t.setCenter(new Location(x, y));

    }

    /**
     * Add a model
     */
    public void addModel () {
        Model currentModel =new Model(this, myModels.size());
        myModels.put(currentModel.getID(), currentModel);
    }

    /**
     * Add a specific model
     * 
     * @param model the model to add
     */
    public void addModel (Model model) {
        myModels.put(model.getID(), model);
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
    public Model getModel (Model model) {
        return myModels.get(model.getID());
    }

    /**
     * Return the list of models
     * 
     * @return list of models
     */
    public Map<Integer, Model> getMyModels () {
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
    public Turtle getMyTurtle (int modelIndex, int turtleIndex) {
        return myModels.get(modelIndex).getMyTurtle(turtleIndex);
    }

    /**
     * Returns list of turtles
     * 
     * @return
     */
    public Map<Integer, Turtle> getMyTurtles (int modelIndex) {
        return myModels.get(modelIndex).getMyTurtles();
    }

    /**
     * 
     * @return
     *         the Canvas area
     */
    public Canvas getView () {
        return myView;
    }

}
