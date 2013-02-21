package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


public class TurtleArea extends Window {

    private static final long serialVersionUID = 1L;

    public TurtleArea (Dimension size) {
        super(size, "English");
    }

    @Override
    public void paint (Graphics pen) {
        pen.setColor(Color.CYAN);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        // TO_DO : first time needs to be special cased
    }

    public void update (double elapsedTime) {
        // update
    }

}
