package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JComponent;
import javax.swing.Timer;


public class Window extends JComponent {

    public static final int FRAMES_PER_SECOND = 25;
    public static final int ONE_SECOND = 1000;
    public static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;

    public static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    public static final String USER_DIR = "user.dir";
    public ResourceBundle myResources;

    private static final long serialVersionUID = 1L;
    private Timer myTimer;

    public Window (Dimension size, String language) {
        setPreferredSize(size);
        setSize(size);
        setFocusable(true);
        requestFocus();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);

    }

    @Override
    public void paintComponent (Graphics pen) {
        pen.setColor(Color.GRAY);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        // TO_DO : first time needs to be special cased
    }

    public void start () {
        myTimer = new Timer(DEFAULT_DELAY, new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                step();
            }
        });

        // TO_DO : call instance of model class here!
        myTimer.start();
    }

    public void step () {
        // TO_DO : call update method of model class here!!
        repaint();
    }

    public void stop () {
        myTimer.stop();
    }

}
