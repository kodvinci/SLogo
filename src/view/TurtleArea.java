package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.List;
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
    private List<Turtle> myTurtle;
    private Trail myTrail;
    private KeyListener myKeyListener;
    private ActionListener myActionListener;
    private Graphics2D myPen;
    private Canvas myView;

    /**
     * 
     * @param size
     *        size of display area
     * @param turtle
     *        pen image
     */
    public TurtleArea (Dimension size, List<Turtle> turtle, Canvas canvas) {
        super(size, "English");
        setFocusable(true);

        myView = canvas;
        makeKeyListener();
        myTurtle = turtle;

        myTrail = myTurtle.get(0).getTrail();
        addKeyListener(myKeyListener);
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
        System.out.println("turtle update1!");

        myTurtle.get(0).addTrail();

        BufferedImage image = new BufferedImage(2, 2, BufferedImage.TYPE_INT_ARGB);
        image.getGraphics();

        // myFrame.revalidate();

        // revalidate();
        // myFrame.revalidate();
        // reSizeFrame();
        // this.setSize(new Dimension(810, 600));

        // myTurtle.paint((Graphics2D) g2);

        myView.update();

        System.out.println("Revalidated");
    }

    private void paintTurtle (Graphics2D pen) {
        myTurtle.get(0).paint(pen);
        System.out.println("turtle painted!");
    }

    @Override
    public void actionPerformed (ActionEvent arg0) {
        System.out.println("keyPressed");
    }

    private void paintPaths (Graphics2D pen) {
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
