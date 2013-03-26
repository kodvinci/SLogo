package view;

import javax.swing.JOptionPane;
import slogo.Controller;


/**
 * 
 * @author Leonard
 * 
 */
public class MessageWindow {

    private Controller myController;

    /**
     * 
     * @param controller
     *        controller
     * @param s
     *        message
     */
    public MessageWindow (Controller controller, String s) {
        myController = controller;
        makeDialogueBox(s);
    }

    private void makeDialogueBox (String message) {
        JOptionPane.showMessageDialog(myController.getView().getFrame(), message);
    }

}
