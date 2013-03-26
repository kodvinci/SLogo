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
    private static final Color TOOLBARCOLOR = Color.GREEN;
    private static final long serialVersionUID = 1L;
    private Controller myController;
    private JFileChooser myChooser;
    private ResourceBundle myResources;
    private ResourceBundle myTurtles;
    private ResourceBundle myBackgroundImages;
    private String[] backgroundImageList={"Brown", "CarolinaBlue", "DukeBlue", "Wooden", "Green" };

    ToolBarArea (Controller control) {
        myController = control;
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
        myBackgroundImages = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Background");
        myTurtles = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Turtles");
        setBackground(TOOLBARCOLOR);
        this.add(makeFileMenu());
        this.add(makeTurtleMenu());
        this.add(makeBackgroundMenu());
        this.add(makePenMenu());
        this.add(makeGridMenu());
    }

    /**
     * make a file menu for opening and saving files
     */
    private JMenu makeFileMenu () {
        JMenu result = new JMenu(myResources.getString("FileMenu"));
        createSaveCommand(result);
        createOpenCommand(result);
        createUndoCommand(result);
        createRedoCommand(result);
        createHelpCommand(result);
        createQuitCommand(result);
        
       
        
        result.add(new JSeparator());
        
        return result;
    }

    private void echo (FileWriter fileWriter) {
    }

    private void showError (String message) {
        JOptionPane.showMessageDialog(this, message, myResources.getString("ErrorTitle"),
                                      JOptionPane.ERROR_MESSAGE);
    }

    private void echo (FileReader fileReader) throws NoSuchFieldException, SecurityException,
                                             IllegalArgumentException, IllegalAccessException {
        try {
            BufferedReader input = new BufferedReader(fileReader);
            String line = input.readLine();
            List<String> inputCommands = new ArrayList<String>();
            while (line.length() != 0) {
                inputCommands.add(line);
                line = input.readLine();
            }
            for (String inputCommand : inputCommands) {
                myController.processUserInput(inputCommand);
            }
        }
        catch (IOException e) {
            showError(e.toString());
        }
    }

    private JMenu makeTurtleMenu () {
        JMenu result = new JMenu(myResources.getString("TurtleMenu"));
        JMenu subMenu = new JMenu(myResources.getString("TurtleSubMenu"));

        subMenu.add(new AbstractAction(myTurtles.getString("Turtle1")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getMyTurtle(0, 0).changeTurtleImage("turtle.gif");
                myController.getView().update();
            }
        });

        subMenu.add(new AbstractAction(myTurtles.getString("Turtle2")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getMyTurtle(0, 0).changeTurtleImage("turtle2.gif");
                myController.getView().update();
            }
        });
        JMenu subMenu2 = new JMenu(myResources.getString("TurtleSubMenu2"));
        subMenu2.add(new AbstractAction(myTurtles.getString("1")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getMyTurtle(0, 0).setTurtleShapeSize(1);
                myController.getView().update();
            }
        });

        subMenu2.add(new AbstractAction(myTurtles.getString("2")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getMyTurtle(0, 0).setTurtleShapeSize(2);
                myController.getView().update();
            }
        });

        subMenu2.add(new AbstractAction(myTurtles.getString("3")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getMyTurtle(0, 0).setTurtleShapeSize(3);
                myController.getView().update();
            }
        });

        subMenu2.add(new AbstractAction(myTurtles.getString("4")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getMyTurtle(0, 0).setTurtleShapeSize(4);
                myController.getView().update();
            }
        });

        subMenu2.add(new AbstractAction(myTurtles.getString("5")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getMyTurtle(0, 0).setTurtleShapeSize(5);
                myController.getView().update();
            }
        });
        result.add(subMenu);
        result.add(subMenu2);
        return result;
    }

    private JMenu makeBackgroundMenu () {
        JMenu result = new JMenu(myResources.getString("BackgroundMenu"));

        JMenu imageSubMenu = new JMenu(myResources.getString("BackgroundSubMenu"));
        JMenu colorSubMenu = new JMenu(myResources.getString("BackgroundColor"));
        for (int i=0; i<backgroundImageList.length; i++){
        	imageSubMenu.add(setBackgroundImage(myBackgroundImages.getString(backgroundImageList[i])));
        	int colorNum= i+1; 
        	colorSubMenu.add(setBackgroundColor(myBackgroundImages.getString("Color"+Integer.toString(colorNum))));
        }
        result.add(imageSubMenu);
        result.add(colorSubMenu);
        return result;
    }
    
    
    private AbstractAction setBackgroundImage (String backgroundImage) {
        final String BACKGROUND_IMAGE = backgroundImage;
        AbstractAction action = new AbstractAction(backgroundImage) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().changeBackgroundImage(BACKGROUND_IMAGE);
            }
        };
        return action;
    }

    private AbstractAction setBackgroundColor (String backgroundColor) {
        final int COLORINT = Integer.parseInt(backgroundColor);
        AbstractAction action = new AbstractAction(backgroundColor) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().changeBackgroundColor(COLORINT);
            }
        };
        return action;
    }

    private JMenu makePenMenu () {
        JMenu result = new JMenu(myResources.getString("PenMenu"));

        JMenu subMenu = new JMenu(myResources.getString("PenProperties"));
        createUpCommand(result);
        createDownCommand(result);

        createDashCommand(subMenu);
        createSolidCommand(subMenu);
        result.add(subMenu);
        return result;

    }

    private JMenu makeGridMenu () {
        JMenu result = new JMenu(myResources.getString("GridMenu"));
        createOnCommand(result);
        createOffCommand(result);    
        return result;
    }
    
    
    private void createDashCommand(JMenu subMenu){
    	subMenu.add(new AbstractAction(myResources.getString("Dash")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().setDashed();
            }
        });
    }
    
    private void createSolidCommand(JMenu subMenu){
    	subMenu.add(new AbstractAction(myResources.getString("Solid")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().setSolid();
            }
        });
    }
    private void createDownCommand(JMenu result){
    	result.add(new AbstractAction(myResources.getString("DownCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().penDown();
            }
        });
    }
    private void createUpCommand(JMenu result){
    	result.add(new AbstractAction(myResources.getString("UpCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().penUp();
            }
        });
    }
    private void createOnCommand(JMenu result){
    	result.add(new AbstractAction(myResources.getString("OnCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().toggleGridOn();
            }
        });
    }
    
    private void createOffCommand(JMenu result){
    	result.add(new AbstractAction(myResources.getString("OffCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().toggleGridOff();
            }
        });
    }
    private void createSaveCommand(JMenu result){
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
    }
    
    private void createOpenCommand(JMenu result){
    	result.add(new AbstractAction(myResources.getString("OpenCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    int response = myChooser.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        try {
                            echo(new FileReader(myChooser.getSelectedFile()));
                        }
                        catch (NoSuchFieldException | SecurityException | IllegalArgumentException
                                | IllegalAccessException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
                catch (IOException io) {
                    showError(io.toString());
                }
            }
        });
    }
    
    private void createUndoCommand(JMenu result){
    	result.add(new AbstractAction(myResources.getString("UndoCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().undo();
            }
        });
    }
    
    private void createRedoCommand(JMenu result){
    	 result.add(new AbstractAction(myResources.getString("RedoCommand")) {
             private static final long serialVersionUID = 1L;

             @Override
             public void actionPerformed (ActionEvent e) {
                 myController.getView().getTurtleArea().redo();
             }
         });
    }
    private void createHelpCommand(JMenu result){
    	result.add(new AbstractAction(myResources.getString("HelpCommand")) {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                String htmlPath =
                        "https://www.cs.duke.edu/courses/cps108/compsci308/cps108/spring13/assign/03_slogo/commands.php"; 

                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(htmlPath));
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
    
    private void createQuitCommand(JMenu result){
    	result.add(new AbstractAction(myResources.getString("QuitCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
