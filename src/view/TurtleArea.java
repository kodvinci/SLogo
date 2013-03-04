package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;
import object.Trail;
import object.Turtle;
import util.Location;


/**
 * 
 * @author Leonard and Alan
 * 
 */
public class TurtleArea extends Window implements ActionListener {
    /**
     * 
     */
    public static final Dimension DEFAULT_AREA_SIZE = new Dimension(800, 600);
    private static final int FRAMES_PER_SECOND = 25;
    private static final int ONE_SECOND = 1000;
    private static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;
    private static final int ENTER_KEY = KeyEvent.VK_ENTER;
    private static final long serialVersionUID = 1L;
    private Turtle myTurtle;
    private Trail myTrail;
    private KeyListener myKeyListener;
    private ActionListener myActionListener;
    private Graphics2D myPen;

    /**
     * 
     * @param size
     *        size of display area
     * @param turtle
     *        pen image
     */
    public TurtleArea (Dimension size, Turtle turtle) {
        super(size, "English");
        setFocusable(true);

        makeKeyListener();
        myTurtle = turtle;
        myTrail = myTurtle.getTrail();
        this.addKeyListener(myKeyListener);
    }

    private void makeKeyListener () {
        System.out.println("made listener");
        myKeyListener = new KeyListener() {
            @Override
            public void keyPressed (KeyEvent e) {
                System.out.println("keyPressed");
                repaint();
            }

            @Override
            public void keyReleased (KeyEvent e) {
            }

            @Override
            public void keyTyped (KeyEvent e) {
            }
        };
    }

    @Override
    public void paint (Graphics pen) {
        super.paintComponent(pen);
        System.out.println("paint turtleArea!");
        myPen = (Graphics2D) pen;
        paintTurtle((Graphics2D) pen);
        paintPaths((Graphics2D) pen);

        new Timer(DEFAULT_DELAY, new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                repaint();
            }
        });

        // Toolkit.getDefaultToolkit().sync();
        // pen.dispose();
    }

    /**
     * 
     */
    public void update () {
        myTurtle.addTrail();

        BufferedImage image = new BufferedImage(2, 2, BufferedImage.TYPE_INT_ARGB);
        Graphics g2 = image.getGraphics();

        // myFrame.revalidate();

        revalidate();
        reSizeFrame();
        // this.setSize(new Dimension(810, 600));

        // myTurtle.paint((Graphics2D) g2);

        System.out.println("Revalidated");
    }

    private void paintTurtle (Graphics2D pen) {
        myTurtle.paint(pen);
        myTurtle.addTrail(); 
        System.out.println("turtle painted!");
    }

    @Override
    public void actionPerformed (ActionEvent arg0) {
        System.out.println("keyPressed");
    }

    private void paintPaths (Graphics2D pen) {
        pen.setColor(Color.BLACK);
        List<Location> trails = myTrail.getTrails();
        if (!(trails.isEmpty())) {
            Location prevLocation = myTrail.getTrails().get(0);
            Location newLocation;
            for (int i = 1; i < trails.size(); i++) {
                newLocation = trails.get(i);
                pen.drawLine((int) prevLocation.getX(), (int) prevLocation.getY(),
                             (int) newLocation.getX(), (int) newLocation.getY());
                prevLocation = newLocation;
            }
        }
    }

}
