package view;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * 
 * @author Leonard
 * 
 */
public class CommandArea extends Window {

    public static final Dimension DEFAULT_AREA_SIZE = new Dimension(500, 50);

    private static final long serialVersionUID = 1L;
    private static final int FIELD_SIZE = 30;
    private KeyListener myKeyListener;
    private JTextArea myTextArea;
    private FocusListener myFocusListener;
    private ActionListener myActionListener;
    private MouseListener myMouseListener;
    private MouseMotionListener myMouseMotionListener;

    public CommandArea (Dimension size) {
        super(size, "English");
        setLayout(new BorderLayout());
        add(makeTextField(), BorderLayout.WEST);
        setVisible(true);

        revalidate();

    }

    public void update () {
        // update
    }

    public void makeListeners () {
        myKeyListener = new KeyListener() {
            @Override
            public void keyPressed (KeyEvent e) {
                echo("pressed", e);
            }

            @Override
            public void keyReleased (KeyEvent e) {
                echo("released", e);
            }

            @Override
            public void keyTyped (KeyEvent e) {
                echo("typed", e);
            }
        };

        myFocusListener = new FocusListener() {
            @Override
            public void focusGained (FocusEvent e) {
                echo("gained", e);
            }

            @Override
            public void focusLost (FocusEvent e) {
                echo("lost", e);
            }
        };

        myActionListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                echo("action", e);
            }
        };

        myMouseListener = new MouseListener() {
            @Override
            public void mouseClicked (MouseEvent e) {
                echo("clicked", e);
            }

            @Override
            public void mouseEntered (MouseEvent e) {
                echo("enter", e);
            }

            @Override
            public void mouseExited (MouseEvent e) {
                echo("exit", e);
            }

            @Override
            public void mousePressed (MouseEvent e) {
                echo("pressed", e);
            }

            @Override
            public void mouseReleased (MouseEvent e) {
                echo("released", e);
            }
        };

        myMouseMotionListener = new MouseMotionListener() {
            @Override
            public void mouseDragged (MouseEvent e) {
                echo("drag", e);
            }

            @Override
            public void mouseMoved (MouseEvent e) {
                echo("move", e);
            }
        };

    }

    private void echo (String s, KeyEvent e) {
        showMessage(s + " char:" + e.getKeyChar() + " mod: " +
                    KeyEvent.getKeyModifiersText(e.getModifiers()) + " mod: " +
                    KeyEvent.getKeyText(e.getKeyCode()));
    }

    private void echo (String s, AWTEvent e) {
        showMessage(s + " " + e);
    }

    private void echo (String s, ActionEvent e) {
        showMessage(s + " = " + e.getActionCommand() + " " + e.getWhen());
    }

    public void showMessage (String message) {
        myTextArea.append(message + "\n");
        myTextArea.setCaretPosition(myTextArea.getText().length());
    }

    private JTextField makeTextField () {

        JTextField result = new JTextField(FIELD_SIZE);
        // Attach Listeners
        result.addKeyListener(myKeyListener);
        result.addFocusListener(myFocusListener);
        result.addActionListener(myActionListener);

        result.setVisible(true);

        return result;

    }

    private JButton makeButton () {
        JButton result = new JButton(myResources.getString("ActionCommand"));
        // TO_DO : Attach Listeners
        result.addActionListener(myActionListener);
        result.addKeyListener(myKeyListener);
        result.addMouseListener(myMouseListener);

        return result;
    }

}
