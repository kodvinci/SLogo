package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.List; 
import util.Location;  
import object.Turtle;
import object.Trail; 



/**
 * 
 * @author Leonard and Alan
 * 
 */
public class TurtleArea extends Window {

    public static final Dimension DEFAULT_AREA_SIZE = new Dimension(800, 600);

    private static final int ENTER_KEY = KeyEvent.VK_ENTER;
    private static final long serialVersionUID = 1L;
    private Turtle myTurtle;
    private Trail myTrail;  
    private KeyListener myKeyListener;

    public TurtleArea (Dimension size, Turtle turtle) {
        super(size, "English");
        setFocusable(true);
        
        // makeKeyListener();
        myTurtle = turtle;
        myTrail=myTurtle.getTrail(); 

        // this.addKeyListener(myKeyListener);
    }

    // private void makeKeyListener () {
    // System.out.println("made listener");
    // myKeyListener = new KeyListener() {
    // @Override
    // public void keyPressed (KeyEvent e) {
    // System.out.println("keyPressed");
    // if(e.equals(ENTER_KEY)){
    // System.out.println("KEY KEY");
    // repaint();
    // }
    // }
    // @Override
    // public void keyReleased (KeyEvent e) {
    // System.out.println("keyReleased");
    // }
    // @Override
    // public void keyTyped (KeyEvent e) {
    // System.out.println("keyTyped");
    // }
    // };
    // }

    @Override
    public void paint (Graphics pen) {
        super.paintComponent(pen);
        System.out.println("paint turtleArea!");

        paintTurtle((Graphics2D) pen);
        paintPaths((Graphics2D) pen);

        Toolkit.getDefaultToolkit().sync();
        pen.dispose();
    }

    public void update () {
        System.out.println(myTrail.getTrails().size());
        myTurtle.addTrail(); 
       // repaint();
       // Random myRand = new Random();
       // int myHack = myRand.nextInt(1);
        this.setSize(this.getWidth(), this.getHeight());

        repaint();
    }

    private void paintTurtle (Graphics2D pen) {
        myTurtle.paint(pen);
        System.out.println("turtle painted!");
    }
    private void paintPaths(Graphics2D pen){
    	List<Location> trails= myTrail.getTrails();
    	if (!(trails.isEmpty())){
	    	Location prevLocation=myTrail.getTrails().get(0);
	    	Location newLocation;
	    	for (int i=1; i<trails.size(); i++){
	    		newLocation= trails.get(i);
	    		pen.drawLine((int)prevLocation.getX(), (int)prevLocation.getY(), (int)newLocation.getX(), (int)newLocation.getY());
	    		prevLocation=newLocation;  
	    	}
    	}
    }
}
