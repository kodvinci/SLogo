package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import utilities.Controller;


/**
 * 
 * @author Leonard
 * 
 */
public class CommandArea extends Window {

    public static final Dimension DEFAULT_AREA_SIZE = new Dimension(500, 50);

    private static final long serialVersionUID = 1L;
    private static final int FIELD_SIZE = 30;
    private ActionListener myActionListener;
    private static final Dimension BUTTON_SIZE = new Dimension(70, 30);
    private JTextField myTextField;
    private Controller myController;

    public CommandArea (Dimension size) {
        super(size, "English");
        makeListeners();
        add(makeTextField());
        add(makeButton());

        setVisible(true);
        revalidate();

        // place holder
        myController = new Controller();
    }

    public void update () {
        myController.getUserInput(myTextField.getText());
        myTextField.setText("");
    }

    public void makeListeners () {

        myActionListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                System.out.println(myTextField.getText());
                update();
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
