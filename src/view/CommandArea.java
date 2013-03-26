package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import slogo.Controller;


/**
 * 
 * @author Leonard and Alan
 * 
 */
public class CommandArea extends Window {

    /**
     * Default size
     */
    public static final Dimension DEFAULT_AREA_SIZE = new Dimension(500, 50);

    private static final long serialVersionUID = 1L;
    private static final int FIELD_SIZE = 30;
    private static final String EMPTY_STRING = "";
    private static final Dimension BUTTON_SIZE = new Dimension(70, 30);

    private JTextField myTextField;
    private Controller myController;
    private ActionListener myActionListener;

    /**
     * 
     * @param size view size
     * @param control default controller
     *        Constructor for CommandArea
     */
    public CommandArea (Dimension size, Controller control) {
        super(size, "English");

        makeListeners();
        add(makeTextField());
        add(makeButton());

        setVisible(true);
        revalidate();

        myController = control;
    }

    /**
     * Sends text to controller and clears textfield
     */
    public void makeListeners () {
        myActionListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    myController.processUserInput(myTextField.getText());
                }
                catch (SecurityException | IllegalArgumentException e1) {
                    // ignore run time exceptions
                    myController.showMessage(e1.getMessage());
                }

                myController.getView().getDisplayArea().showTurtleStatus();
                separateCommands(myTextField.getText());
                myTextField.setText(EMPTY_STRING);
            }

        };
    }

    private void separateCommands (String text) {
        String myText = text.toUpperCase();
        if (myText.startsWith("REPEAT") | myText.startsWith("IF") | myText.startsWith("IFELSE") |
            myText.startsWith("TO")) {
            myController.getView().getDisplayArea().showUserDefinedComs(text);
        }
        else {
            myController.getView().getDisplayArea().showprevCommands(myTextField.getText());
        }

    }

    /**
     * 
     * Set textfield equal to userinput
     */

    private JTextField makeTextField () {

        myTextField = new JTextField(FIELD_SIZE);
        myTextField.addActionListener(myActionListener);
        myTextField.setVisible(true);

        return myTextField;

    }

    /**
     * Creates button that allows for user submission of command
     */

    private JButton makeButton () {

        JButton result = new JButton(getResourceBundle().getString("ActionCommand"));
        result.setPreferredSize(BUTTON_SIZE);
        result.addActionListener(myActionListener);

        return result;
    }

}
