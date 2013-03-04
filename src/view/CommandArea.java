package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JTextField;
import slogo.Controller;


/**
 * 
 * @author Leonard and Alan
 * 
 */
public class CommandArea extends Window {

    private static final long serialVersionUID = 1L;
    private static final int FIELD_SIZE = 30;
    private static final String EMPTY_STRING = "";
    private static final Dimension BUTTON_SIZE = new Dimension(70, 30);
    private ActionListener myActionListener;
    private JTextField myTextField;
    private Controller myController;
    private ResourceBundle myResources;

    /**
     * 
     * @param size
     *        size of user input area
     * @param control
     *        default controller
     */
    public CommandArea (Dimension size, Controller control) {
        super(size, "English");
        makeListeners();
        add(makeTextField());
        add(makeButton());

        setVisible(true);
        revalidate();
        myController = control;
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");

    }

    /**
     * 
     */
    public void makeListeners () {
        myActionListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                myController.processUserInput(0, myTextField.getText());
                myTextField.setText(EMPTY_STRING);
            }
        };
    }

    private JTextField makeTextField () {

        myTextField = new JTextField(FIELD_SIZE);
        myTextField.addActionListener(myActionListener);
        myTextField.setVisible(true);

        return myTextField;

    }

    private JButton makeButton () {

        JButton result = new JButton(myResources.getString("ActionCommand"));
        result.setPreferredSize(BUTTON_SIZE);
        result.addActionListener(myActionListener);

        return result;
    }

}
