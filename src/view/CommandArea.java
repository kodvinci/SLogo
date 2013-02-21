package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Leonard
 *
 */
public class CommandArea extends Window {

    private static final long serialVersionUID = 1L;
    private static final int FIELD_SIZE = 30;

    public CommandArea (Dimension size) {
        super(size, "English");
        makeInput();
    }

    @Override
    public void paint (Graphics pen) {
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);
    }

    public void update (double elapsedTime) {
        // update
    }

    private JComponent makeInput () {
        JPanel result = new JPanel();
        result.add(makeTextField());
        result.add(makeButton());
        return result;
    }

    private JTextField makeTextField () {
        JTextField result = new JTextField(FIELD_SIZE);
        // TO_DO : Attach Listeners
        return result;
    }

    private JButton makeButton () {
        JButton result = new JButton(myResources.getString("ActionCommand"));
        // TO_DO : Attach Listeners
        return result;
    }

}
