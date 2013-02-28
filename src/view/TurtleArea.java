package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import object.Turtle;


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
    private KeyListener myKeyListener;

    public TurtleArea (Dimension size, Turtle turtle) {
        super(size, "English");
        setFocusable(true);

        // makeKeyListener();
        myTurtle = turtle;

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

        Toolkit.getDefaultToolkit().sync();
        pen.dispose();
    }

    public void update () {
        System.out.println("turtle update");
        repaint();
    }

    private void paintTurtle (Graphics2D pen) {
        myTurtle.paint(pen);
        System.out.println("turtle painted!");
    }
}
