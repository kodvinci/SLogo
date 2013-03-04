package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.List;
import object.Trail;
import object.Turtle;
import util.Location;


/**
 * 
 * @author Leonard and Alan
 * 
 */
public class TurtleArea extends Window {

    private static final long serialVersionUID = 1L;
    private List<Turtle> myTurtles;
    private static final int FIRST_TURTLE=0; 
    private static final Color trailColor= Color.BLACK; 
    private Trail myTrail;
    private Canvas myView;

    /**
     * 
     * @param size
     *        size of display area
     * @param turtles
     *        pen image
     */
    public TurtleArea (Dimension size, List<Turtle> turtles, Canvas canvas) {
        super(size, "English");
        setFocusable(true);

        myView = canvas;
        myTurtles = turtles;
        myTrail = myTurtles.get(FIRST_TURTLE).getTrail();
    }

    @Override
    public void paint (Graphics pen) {
        super.paintComponent(pen);
        System.out.println("paint turtleArea!");
        paintTurtle((Graphics2D) pen);
        paintPaths((Graphics2D) pen);

        Toolkit.getDefaultToolkit().sync();
        pen.dispose();
    }

    /**
     * 
     */
    public void update () {
        for (Turtle t : myTurtles) {
            t.addTrail();
        }


        myTurtles.get(FIRST_TURTLE).addTrail();

        revalidate();
        // revalidate();
        // myFrame.revalidate();
        // reSizeFrame();
        // this.setSize(new Dimension(810, 600));

        // myTurtle.paint((Graphics2D) g2);

        myView.update();

    }

    private void paintTurtle (Graphics2D pen) {

        for (Turtle t : myTurtles) {
            t.paint(pen);
            t.addTrail();
        }

    }

    private void paintPaths (Graphics2D pen) {
        pen.setColor(trailColor);
        List<Location> trails = myTrail.getTrails();
        if (!(trails.isEmpty())) {
            Location prevLocation = myTrail.getTrails().get(FIRST_TURTLE);
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
