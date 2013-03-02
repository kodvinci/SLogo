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
    
    
    public TurtleArea (Dimension size, Turtle turtle) {
        super(size, "English");
        myTurtle=turtle;
        
    }

    @Override
    public void paint (Graphics pen) {
        System.out.println("painted");
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        System.out.println(myTurtle.getX());
        System.out.println(myTurtle.getY());
        pen.drawOval((int)myTurtle.getX(), (int)myTurtle.getY(),10 , 10);
        
    }

    public void update () {
        System.out.println("update turtle");
        repaint();
    }

}
