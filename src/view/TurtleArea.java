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
        myTrail = myTurtles.get(0).getTrail();
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

        System.out.println("turtle update1!");

        myTurtles.get(0).addTrail();

        BufferedImage image = new BufferedImage(2, 2, BufferedImage.TYPE_INT_ARGB);
        image.getGraphics();

        revalidate();
        // revalidate();
        // myFrame.revalidate();
        // reSizeFrame();
        // this.setSize(new Dimension(810, 600));

        // myTurtle.paint((Graphics2D) g2);

        myView.update();

        System.out.println("Revalidated");
    }

    private void paintTurtle (Graphics2D pen) {

        for (Turtle t : myTurtles) {
            t.paint(pen);
            t.addTrail();
        }

        System.out.println("turtle painted!");
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
