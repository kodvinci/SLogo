package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import slogo.Controller;


/**
 * Provides the tool bar area where menus can be added
 * 
 * @author Leonard
 * 
 */
public class ToolBarArea extends JMenuBar {

    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    private static final String USER_DIR = "user.dir";
    private static final Color BACKGROUND_COLOR = Color.GREEN;
    private static final long serialVersionUID = 1L;
    private Controller myController;
    private JFileChooser myChooser;
    private ResourceBundle myResources;

    ToolBarArea (Controller control) {
        myController = control;
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");

        setBackground(BACKGROUND_COLOR);
        this.add(makeFileMenu());
    }

    /**
     * make a file menu for opening and saving files
     */
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
    }

    private void showError (String message) {
        JOptionPane.showMessageDialog(this, message, myResources.getString("ErrorTitle"),
                                      JOptionPane.ERROR_MESSAGE);
    }

    private void echo (FileReader fileReader) {
        try {
            BufferedReader input = new BufferedReader(fileReader);
            String line = input.readLine();
            List<String> inputCommands = new ArrayList<String>();
            while (line.length() != 0) {
                inputCommands.add(line);
                line = input.readLine();
            }
            for (String inputCommand : inputCommands) {
                myController.processUserInput(0, inputCommand);
            }
        }
        catch (IOException e) {
            showError(e.toString());
        }
    }

}
