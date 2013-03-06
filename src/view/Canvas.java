package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import object.Turtle;
import slogo.Controller;


/**
 * 
 * @author Leonard
 * 
 */
public class Canvas extends JComponent {

    /**
     * 
     */
    public static final Dimension TURTLE_AREA_SIZE = new Dimension(800, 500);
    /**
     * 
     */
    public static final Dimension DISPLAY_AREA_SIZE = new Dimension(200, 500);
    /**
     * 
     */
    public static final Dimension COMMAND_AREA_SIZE = new Dimension(1000, 40);
    /**
     * 
     */
    public static final Dimension SIZE = new Dimension(1100, 700);
    /**
     * 
     */
    public static final String TITLE = "SLOGO";
    /**
     * 
     */
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    /**
     * 
     */
    public static final String USER_DIR = "user.dir";

    private Controller myController;
    private JPanel myPanel;
    private JFrame myFrame;
    private List<Turtle> myTurtle;
    private JFileChooser myChooser;
    private ResourceBundle myResources;

    /**
     * 
     * @param controller
     *        Slogo controller
     */
    public Canvas (Controller controller) {
        myController = controller;
        myTurtle = myController.getMyModels().get(0).getMyTurtles();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        createGUI();
    }

    /**
     * 
     */
    public void createGUI () {

        myFrame = new JFrame(TITLE);
        myPanel = new JPanel();
        myFrame.setContentPane(myPanel);
        myFrame.setPreferredSize(SIZE);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // for turtle sprite display
        TurtleArea myTurtleArea = new TurtleArea(TURTLE_AREA_SIZE, myTurtle, this);
        myFrame.getContentPane().add(myTurtleArea, BorderLayout.CENTER);

        // for turtle status display
        DisplayArea myDisplay = new DisplayArea(DISPLAY_AREA_SIZE, myTurtle);
        myFrame.getContentPane().add(myDisplay, BorderLayout.EAST);

        // for user input display
        CommandArea myInput = new CommandArea(COMMAND_AREA_SIZE, myController);
        myFrame.getContentPane().add(myInput, BorderLayout.SOUTH);

        // add menu bar
        myFrame.setJMenuBar(makeMenus());

        myFrame.pack();
        myFrame.setVisible(true);
    }

    /**
     * Resize the view
     */
    public void update () {
        Random rand = new Random();
        int hack = rand.nextInt(10);
        Dimension SIZE = new Dimension(1050 + hack, 700);
        myPanel.setSize(SIZE);
        myFrame.validate();
    }

    private JMenuBar makeMenus () {
        JMenuBar result = new JMenuBar();
        result.add(makeFileMenu());
        return result;
    }

    private JMenu makeFileMenu () {
        JMenu result = new JMenu(myResources.getString("FileMenu"));
        result.add(new AbstractAction(myResources.getString("OpenCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    int response = myChooser.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        echo(new FileReader(myChooser.getSelectedFile()));
                    }
                }
                catch (IOException io) {
                    showError(io.toString());
                }
            }
        });
        result.add(new AbstractAction(myResources.getString("SaveCommand")) {
            private static final long serialVersionUID = 1L;

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
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        });
        return result;
    }

    private void echo (FileWriter fileWriter) {
        // TODO do I really need this?
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

    /**
     * 
     * @return
     *         the resource bundle
     */
    public ResourceBundle getResource () {
        return myResources;
    }
}
