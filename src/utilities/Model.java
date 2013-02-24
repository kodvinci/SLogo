package utilities;

import java.util.ArrayList;
import java.util.List;
import object.Turtle;

public class Model {

    private List<Turtle> myTurtles = new ArrayList<Turtle>();
    
    public void addTurtle(Turtle newTurtle){
        myTurtles.add(newTurtle);
    }
    public void removeTurtle(Turtle removeTurtle){
        myTurtles.remove(removeTurtle);
    }
    public void removeTurtle(int ind){
        myTurtles.remove(ind);
    }
    
    public void getTurtle(int ind){
        myTurtles.get(ind);
    }
    
}
