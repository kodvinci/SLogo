package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import object.Turtle;
import utilities.Controller;


/**
 * 
 * @author Leonard and Alan
 * 
 */
public class Window extends JPanel {

    public static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    public static final String USER_DIR = "user.dir";
    public ResourceBundle myResources;

    public JFrame myFrame;
    public JPanel myPanel;
    //
    public static final Dimension TURTLE_AREA_SIZE = new Dimension(800, 500);
    public static final Dimension DISPLAY_AREA_SIZE = new Dimension(200, 500);
    public static final Dimension COMMAND_AREA_SIZE = new Dimension(1000, 40);
    public static final Dimension SIZE = new Dimension(1100, 700);
    public static final Dimension SIZE1 = new Dimension(1000, 700);
    public static final String TITLE = "SLOGO";
    private Controller myController;
    private Turtle myTurtle;
    //

    private static final int ENTER_KEY = KeyEvent.VK_ENTER;
    private static final long serialVersionUID = 1L;
    private KeyListener myKeyListener;
    private JFileChooser myChooser;
    private Canvas myView;

    public Window (Controller controller) {
        // createGUI();
        // makeKeyListener();
        myController = controller;
        myTurtle = myController.getMyTurtle();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));

        // addKeyListener(myKeyListener);
    }

    public Window (Dimension size, String language) {
        setPreferredSize(size);
        setSize(size);
        setFocusable(true);
        requestFocus();
        revalidate();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
    }

    public Window (Dimension size, String language, Canvas canvas) {
        setPreferredSize(size);
        setSize(size);
        setFocusable(true);
        requestFocus();
        revalidate();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        myView = canvas;
    }

    @Override
    public void paintComponent (Graphics pen) {
        System.out.println("Window!");
        super.paintComponent(pen);
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);

        if (myTurtle != null) {
            myTurtle.paint((Graphics2D) pen);
            System.out.println("Window Turtle!");
        }
    }

    /**
     * 
     */
    public void createGUI () {

        // JFrame myFrame = new JFrame(TITLE);

        myFrame = new JFrame(TITLE);
        myPanel = new JPanel();
        myFrame.setLayout(new BorderLayout());
        myFrame.setContentPane(myPanel);
        myFrame.setSize(SIZE);
        myFrame.setPreferredSize(SIZE);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // for turtle sprite display
        TurtleArea myTurtleArea = new TurtleArea(TURTLE_AREA_SIZE, myTurtle, myView);
        myFrame.getContentPane().add(myTurtleArea, BorderLayout.CENTER);

        // for turtle status display
        DisplayArea myDisplay = new DisplayArea(DISPLAY_AREA_SIZE, myTurtle);
        myFrame.getContentPane().add(myDisplay, BorderLayout.EAST);

        // for user input display
        CommandArea myInput = new CommandArea(COMMAND_AREA_SIZE, myController);
        myFrame.getContentPane().add(myInput, BorderLayout.SOUTH);

        // add menu
        myFrame.setJMenuBar(makeMenus());

        myFrame.pack();
        myFrame.setVisible(true);
    }

    // /**
    // *
    // */
    // public void reSizeFrame () {
    // // myFrame.setPreferredSize(SIZE1);
    // // myFrame.setBounds(0, 0, 1000, 500);
    // // this.setSize(SIZE1);
    // // myPanel.setPreferredSize(SIZE1);
    // myPanel.setSize(SIZE1);
    // validate();
    // }

    private void makeKeyListener () {
        System.out.println("made listener");
        myKeyListener = new KeyListener() {
            @Override
            public void keyPressed (KeyEvent e) {
                System.out.println("keyPressed");
                if (e.equals(ENTER_KEY)) {
                    System.out.println("KEY KEY");
                    repaint();
                }
            }

            @Override
            public void keyReleased (KeyEvent e) {
                System.out.println("keyReleased");
            }

            @Override
            public void keyTyped (KeyEvent e) {
                System.out.println("keyTyped");
            }
        };
    }

    private JMenuBar makeMenus () {
        JMenuBar result = new JMenuBar();
        result.add(makeFileMenu());
        return result;
    }

    private JMenu makeFileMenu () {
        JMenu result = new JMenu(myResources.getString("FileMenu"));
        result.add(new AbstractAction(myResources.getString("OpenCommand")) {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    int response = myChooser.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        echo(new FileReader(myChooser.getSelectedFile()));
                    }
                }
                catch (IOException io) {
                    // let user know an error occurred, but keep going
                    showError(io.toString());
                }
            }
        });
        result.add(new AbstractAction(myResources.getString("SaveCommand")) {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    echo(new FileWriter("demo.out"));
                }
                catch (IOException io) {
                    showError(io.toString());
                }
            }
        });
        result.add(new JSeparator());
        result.add(new AbstractAction(myResources.getString("QuitCommand")) {
            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        });
        return result;
    }

    private void echo (FileWriter fileWriter) {
        // TODO Auto-generated method stub

    }

    private void showError (String message) {
        JOptionPane.showMessageDialog(this, message, myResources.getString("ErrorTitle"),
                                      JOptionPane.ERROR_MESSAGE);
    }

    private void echo (FileReader fileReader) {
        try {
            String userInput = "";
            BufferedReader input = new BufferedReader(fileReader);
            String line = input.readLine();
            while (line != null) {
                userInput += line + "\n";
                line = input.readLine();
            }
            myController.processUserInput(0, userInput);
        }
        catch (IOException e) {
            showError(e.toString());
        }
    }

}
