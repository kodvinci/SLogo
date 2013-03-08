package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import object.Turtle;


/**
 * 
 * @author Leonard and Alan
 * 
 */
public class DisplayArea extends Window {
    public static final Dimension DEFAULT_AREA_SIZE = new Dimension(200, 600);

    private static final long serialVersionUID = 1L;
    private static final int FIRST_TURTLE = 0;
    private static final String X_LABEL = "x coordinate: ";
    private static final String Y_LABEL = "y coordinate: ";
    private static final String ANGLE_LABEL = "turtle angle: ";
    private static final int FIELD_SIZE = 30;
    private static final int FIELD_SIZE_TWO = 18;
    private List<Turtle> myTurtle;
    private MouseListener myMouseListener;
    private JTextArea myTextArea;

    /**
     * 
     * @param size
     *        display area size
     * @param myTurtles
     *        the pens
     *        DisplayArea constructor, starts listeners
     */
    public DisplayArea (Dimension size, List<Turtle> myTurtles) {
        super(size, "English");
        myTurtle = myTurtles;
        
        makeListeners();
        add(clearDisplayArea(), BorderLayout.NORTH);
        add(makeDisplay(), BorderLayout.CENTER);
        setVisible(true);
        revalidate();

    }

    private JComponent makeDisplay () {
        myTextArea = new JTextArea(FIELD_SIZE, FIELD_SIZE_TWO);
        myTextArea.setEditable(false);
        myTextArea.addMouseListener(myMouseListener);
        return new JScrollPane(myTextArea);
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

    /**
     * Prints current X and Y Location and Angle
     */
    private void echo (String s, MouseEvent e) {
        showMessage(X_LABEL +
                    myTurtle.get(FIRST_TURTLE).toString(myTurtle.get(FIRST_TURTLE).getX()));
        showMessage(Y_LABEL +
                    myTurtle.get(FIRST_TURTLE).toString(myTurtle.get(FIRST_TURTLE).getY()));
        showMessage(ANGLE_LABEL +
                    myTurtle.get(FIRST_TURTLE)
                            .toString(myTurtle.get(FIRST_TURTLE).getMyAngle()));
        showMessage("\n");
    }

    /**
     * 
     * @param message
     *        message to be displayed
     * Displays message in display area
     */
    public void showMessage (String message) {
        myTextArea.append(message + "\n");
        myTextArea.setCaretPosition(myTextArea.getText().length());
    }
    
    private JButton clearDisplayArea () {
        JButton result = new JButton(myResources.getString("ClearCommand"));
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                myTextArea.setText("");
            }
        });
        return result;
    }
    
}
