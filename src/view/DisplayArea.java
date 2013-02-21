package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class DisplayArea extends Window {

    private static final long serialVersionUID = 1L;
    private JTextArea myTextArea;
    private static final int FIELD_SIZE = 30;

    public DisplayArea (Dimension size) {
        super(size, "English");
        makeDisplay();
    }

    private JComponent makeDisplay () {
        myTextArea = new JTextArea(FIELD_SIZE, FIELD_SIZE);
        return new JScrollPane(myTextArea);
    }

    @Override
    public void paint (Graphics pen) {
        pen.setColor(Color.GRAY);
        pen.fillRect(0, 0, getSize().width, getSize().height);
    }

    public void update (double elapsedTime) {
        // update
    }

}
