package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import object.Turtle;


/**
 * 
 * @author Leonard
 * 
 */
public class DisplayArea extends Window {

    public static final Dimension DEFAULT_AREA_SIZE = new Dimension(200, 600);

    private static final long serialVersionUID = 1L;
    private static final int FIRST_TURTLE=0; 
    private JTextArea myTextArea;
    private static final String X_LABEL="x coordinate: " ;
    private static final String Y_LABEL="y coordinate: ";
    private static final String ANGLE_LABEL="turtle angle: " ;
    private static final int FIELD_SIZE = 30;
    private List<Turtle> myTurtle;
    private MouseListener myMouseListener;

    public DisplayArea (Dimension size, List<Turtle> myTurtles) {
        super(size, "English");
        myTurtle = myTurtles;
        makeListeners();

        add(makeDisplay(), BorderLayout.CENTER);
        setVisible(true);
        revalidate();

    }

    private JComponent makeDisplay () {
        myTextArea = new JTextArea(FIELD_SIZE, 18);
        myTextArea.addMouseListener(myMouseListener);

        return new JScrollPane(myTextArea);
    }

    public void update () {
    }

    private void makeListeners () {

        myMouseListener = new MouseListener() {
            @Override
            public void mouseClicked (MouseEvent e) {
                echo("clicked", e);
            }

            @Override
            public void mouseEntered (MouseEvent e) {
            }

            @Override
            public void mouseExited (MouseEvent e) {
            }

            @Override
            public void mousePressed (MouseEvent e) {
            }

            @Override
            public void mouseReleased (MouseEvent e) {
            }
        };

    }

    private void echo (String s, MouseEvent e) {
        showMessage(X_LABEL+
                        myTurtle.get(FIRST_TURTLE).toString(myTurtle.get(FIRST_TURTLE).getX()));
        showMessage(Y_LABEL+
                        myTurtle.get(FIRST_TURTLE).toString(myTurtle.get(FIRST_TURTLE).getY()));
        showMessage(ANGLE_LABEL+
                        myTurtle.get(FIRST_TURTLE).toString(myTurtle.get(FIRST_TURTLE).getMyAngle()));
        showMessage("\n");
    }

    public void showMessage (String message) {
        myTextArea.append(message + "\n");
        myTextArea.setCaretPosition(myTextArea.getText().length());
    }

}
