package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    private Graphics2D myPen;
    
    public TurtleArea (Dimension size, Turtle turtle) {
        super(size, "English");
        myTurtle=turtle;
        
    }

    @Override
    public void paint (Graphics pen) {
        myPen = (Graphics2D) pen;
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        myTurtle.paint((Graphics2D) pen);
    }

    public void update () {
        // update
        myTurtle.paint(myPen);
    }

}
