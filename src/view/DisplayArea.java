package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import object.Turtle;
import slogo.Controller;


/**
 * 
 * @author Leonard and Alan
 * 
 */
public class DisplayArea extends Window {
    /**
     * Default size
     */
    public static final Dimension DEFAULT_AREA_SIZE = new Dimension(200, 600);

    private static final long serialVersionUID = 1L;
    private static final int FIRST_TURTLE = 0;
    private static final String X_LABEL = "x coordinate: ";
    private static final String Y_LABEL = "y coordinate: ";
    private static final String ANGLE_LABEL = "turtle angle: ";
    private static final String ONE = "one";
    private static final String TWO = "two";
    private static final String THREE = "three";
    private static final int HEIGHT_FIELD_SIZE = 10;
    private static final int WIDTH_FIELD_SIZE_TWO = 16;
    private Map<Integer, Turtle> myTurtle;
    private MouseListener myMouseTlistener;
    private MouseListener myMouseClistener;
    private MouseListener myMouseUlistener;
    private JTextArea myTextArea;
    private JTextArea myPrevCommands;
    private JTextArea myUserDefinedVars;
    private Controller myController;

    /**
     * 
     * @param size
     *        display area size
     * @param myTurtles
     *        the pens
     * @param control
     *        controller
     * 
     *        DisplayArea constructor, starts listeners
     */
    public DisplayArea (Dimension size, Map<Integer, Turtle> myTurtles, Controller control) {
        super(size, "English");
        myTurtle = myTurtles;
        myController = control;

        makeListeners();
        add(labelText("TURTLE STATUS "));
        add(clearDisplayArea(ONE), BorderLayout.NORTH);
        add(makeDisplay(), BorderLayout.CENTER);
        add(labelText("PREV COMMANDS "));
        add(clearDisplayArea(TWO), BorderLayout.NORTH);
        add(makePreviousCommandsDisplay(), BorderLayout.CENTER);
        add(labelText("USER-DEF PROC "));
        add(clearDisplayArea(THREE), BorderLayout.NORTH);
        add(makeUserDefinedProceduresDisplay(), BorderLayout.CENTER);
        setVisible(true);
        revalidate();

    }

    private JComponent makeDisplay () {
        myTextArea = new JTextArea(HEIGHT_FIELD_SIZE, WIDTH_FIELD_SIZE_TWO);
        myTextArea.setEditable(false);
        myTextArea.addMouseListener(myMouseTlistener);
        return new JScrollPane(myTextArea);
    }

    private JComponent makePreviousCommandsDisplay () {
        myPrevCommands = new JTextArea(HEIGHT_FIELD_SIZE, WIDTH_FIELD_SIZE_TWO);
        myPrevCommands.setEditable(false);
        myPrevCommands.addMouseListener(myMouseClistener);

        return new JScrollPane(myPrevCommands);
    }

    private JComponent makeUserDefinedProceduresDisplay () {
        myUserDefinedVars = new JTextArea(HEIGHT_FIELD_SIZE, WIDTH_FIELD_SIZE_TWO);
        myUserDefinedVars.setEditable(false);
        myUserDefinedVars.addMouseListener(myMouseUlistener);

        return new JScrollPane(myUserDefinedVars);
    }

    /**
     * 
     * @param commands
     *        previous commands
     */
    public void showprevCommands (String commands) {
        myPrevCommands.append(sanitize(commands).toUpperCase() + "\n");
        myPrevCommands.setCaretPosition(myPrevCommands.getText().length());
    }

    /**
     * 
     * @param commands user-defined commands
     */
    public void showUserDefinedComs (String commands) {
        String parsedCommand = sanitize(commands);
        myUserDefinedVars.append(parsedCommand.toUpperCase() + "\n");
        myUserDefinedVars.setCaretPosition(myUserDefinedVars.getText().length());
    }

    private String sanitize (String commands) {
        String delim = "[ ]+";
        String[] parsedCommandArray = commands.split(delim);
        String parsedCommand = "";
        for (String element : parsedCommandArray) {
            parsedCommand += element + " ";
        }
        return parsedCommand;
    }

    private void reRunPreviousCommands (MouseEvent e, int mouseID) {
        String[] input1 = myPrevCommands.getText().split("\n");
        String[] input2 = myUserDefinedVars.getText().split("\n");
        try {
            if (mouseID == 1) {
                for (String prevComm : input1) {
                    myController.processUserInput(prevComm.trim());
                }
            }
            else if (mouseID == 2) {
                for (String prevComm : input2) {
                    myController.processUserInput(prevComm.trim());
                }
            }
        }
        catch (SecurityException | IllegalArgumentException e1) {
            e1.printStackTrace();
        }
    }

    private void makeListeners () {

        myMouseTlistener = new MouseListener() {
            @Override
            public void mouseClicked (MouseEvent e) {
                showTurtleStatus();
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

        myMouseClistener = new MouseListener() {
            @Override
            public void mouseClicked (MouseEvent e) {
                reRunPreviousCommands(e, 1);
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

        myMouseUlistener = new MouseListener() {
            @Override
            public void mouseClicked (MouseEvent e) {
                reRunPreviousCommands(e, 2);
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
     * Display the turtle's status
     */
    public void showTurtleStatus () {
        String xCoord =
                X_LABEL + myTurtle.get(FIRST_TURTLE).toString(myTurtle.get(FIRST_TURTLE).getX());
        String yCoord =
                Y_LABEL + myTurtle.get(FIRST_TURTLE).toString(myTurtle.get(FIRST_TURTLE).getY());
        String angle =
                ANGLE_LABEL +
                        myTurtle.get(FIRST_TURTLE).toString(myTurtle.get(FIRST_TURTLE).getAngle());

        myTextArea.append(xCoord + "\n" + yCoord + "\n" + angle + "\n" + "\n");
        myTextArea.setCaretPosition(myTextArea.getText().length());
    }

    private JButton clearDisplayArea (String name) {
        JButton result = new JButton(getResourceBundle().getString("ClearCommand"));
        result.setName(name);
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                JButton b = (JButton) e.getSource();
                if (b.getName().equals(ONE)) {
                    myTextArea.setText("");
                }
                else if (b.getName().equals(TWO)) {
                    myPrevCommands.setText("");
                }
                else if (b.getName().equals(THREE)) {
                    myUserDefinedVars.setText("");
                }
            }
        });
        return result;
    }

    private JLabel labelText (String text) {
        return new JLabel(text);
    }
}
