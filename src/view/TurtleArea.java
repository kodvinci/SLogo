package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import object.Turtle;

/**
 * 
 * @author Leonard and Alan
 * 
 */
public class TurtleArea extends Window {

    public static final Dimension DEFAULT_AREA_SIZE = new Dimension(800, 600);

    private static final long serialVersionUID = 1L;
    private Turtle myTurtle; 

    public TurtleArea (Dimension size, Turtle turtle) {
        super(size, "English");
        myTurtle=turtle;
        
    }

    @Override
    public void paint (Graphics pen) {
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        pen.setColor(Color.GREEN);
        pen.fillRect((int)myTurtle.getX(), (int)myTurtle.getY(), (int)myTurtle.getWidth(), (int)myTurtle.getHeight());        
        // TO_DO : first time needs to be special cased
    }

    public void update () {
        // update
    }

}
